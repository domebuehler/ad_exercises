/*
 * Copyright 2022 Hochschule Luzern - Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.hslu.ad.sw06.buffer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Puffer nach dem First In First Out Prinzip mit einer begrenzten Kapazität.
 * Der Puffer ist thread sicher.
 *
 * @param <T> Elememente des Buffers
 */
public final class BoundedBuffer<T> implements Buffer<T> {

    private static final Logger LOG = LogManager.getLogger(BoundedBuffer.class);

    private final ArrayDeque<T> queue;
    private final Semaphore putSema;
    private final Semaphore takeSema;
    private final int initSize;

    /**
     * Erzeugt einen Puffer mit bestimmter Kapazität.
     *
     * @param n Kapazität des Puffers
     */
    public BoundedBuffer(final int n) {
        queue = new ArrayDeque<>(n);
        initSize = n;
        putSema = new Semaphore(n);
        takeSema = new Semaphore(0);
    }

    @Override
    public void put(final T elem) throws InterruptedException {
        putSema.acquire();
        synchronized (queue) {
            queue.addFirst(elem);
        }
        takeSema.release();
    }

    @Override
    public T get() throws InterruptedException {
        takeSema.acquire();
        T elem;
        synchronized (queue) {
            elem = queue.removeLast();
        }
        putSema.release();
        return elem;
    }

    @Override
    public boolean put(T elem, long millis) throws InterruptedException {
        /*while (this.full()) {
            waiting(millis);
            if (this.full()) {
                return false;
            }
        }
        this.put(elem);
        return true;*/


        if (!putSema.tryAcquire(millis, TimeUnit.MILLISECONDS)) {
            return false;
        }

        synchronized (queue) {
            queue.addFirst(elem);
        }
        takeSema.release();
        return true;
    }

    @Override
    public T get(long millis) throws InterruptedException {
        /*while (this.empty()) {
            waiting(millis);
            if (this.empty()) {
                return null;
            }
        }
        return this.get();*/

        if (!this.takeSema.tryAcquire(millis, TimeUnit.MILLISECONDS)) {
            return null;
        }

        T elem;
        synchronized (queue) {
            elem = queue.removeLast();
        }
        putSema.release();
        return elem;
    }

    private void waiting(long millis) throws InterruptedException {
        synchronized (this) {
            wait(millis);
        }
    }

    @Override
    public T first() throws InterruptedException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T last() throws InterruptedException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean empty() {
        synchronized (this.queue) {
            return queue.isEmpty();
        }
    }

    @Override
    public boolean full() {
        synchronized (this.queue) {
            return queue.size() == initSize;
        }
    }

    @Override
    public int size() {
        synchronized (this.queue) {
            return this.queue.size();
        }
    }
}
