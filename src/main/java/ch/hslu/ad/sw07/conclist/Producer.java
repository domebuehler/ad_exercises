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
package ch.hslu.ad.sw07.conclist;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.Callable;

/**
 * Produzent, der eine maximale Anzahl Werte produziert und diese in eine Queue speichert.
 */
public final class Producer implements Callable<Long> {

    private List<Integer> list;
    private Queue<Integer> queue;
    private boolean queueFlag = false;
    private final int maxRange;
    private long sum;

    /**
     * Erzeugt einen Produzent, der eine bestimmte Anzahl Integer-Werte produziert.
     * @param list Queue zum Speichern der Integer-Werte.
     * @param max Anzahl Integer-Werte.
     */
    public Producer(final List<Integer> list, final int max) {
        this.list = list;
        this.maxRange = max;
    }

    public Producer(final Queue<Integer> queue, final int maxRange){
        this.queue = queue;
        this.queueFlag = true;
        this.maxRange = maxRange;
    }

    /**
     * Liefert die Summe aller zusammengezählter Integer Werte.
     * @return Summe.
     * @throws java.lang.Exception falls Ausnahmen passieren.
     */
    @Override
    public Long call() throws Exception {
        if (queueFlag) {
            sum = handleQueue();
        } else {
            sum = handleList();
        }
        return this.sum;
    }

    private Long handleList() {
        for (int i = 1; i <= maxRange; i++) {
            this.sum += i;
            this.list.add(i);
        }
        return this.sum;
    }

    private Long handleQueue() {
        for (int i = 1; i <= maxRange; i++) {
            this.sum += i;
            this.queue.offer(i);
        }
        return this.sum;
    }
}
