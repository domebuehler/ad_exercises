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

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Demonstration des BoundedBuffers mit n Producer und m Consumer.
 */
public final class DemoBoundedBuffer {

    private static final Random random = new Random();
    private static final int nPros = 3;
    private static final Producer[] producers = new Producer[nPros];
    private static final ThreadGroup prosGroup = new ThreadGroup("Producer-Threads");
    private static final int mCons = 2;
    private static final Consumer[] consumers = new Consumer[mCons];
    private static final ThreadGroup consGroup = new ThreadGroup("Consumer-Threads");
    private static final BoundedBuffer<Integer> queue = new BoundedBuffer<>(50);

    private static final Logger LOG = LogManager.getLogger(DemoBoundedBuffer.class);
    /**
     * Main-Demo.
     * @param args not used.
     * @throws InterruptedException wenn das warten unterbrochen wird.
     */
    public static void main(final String args[]) throws InterruptedException {
        for (int i = 0; i < nPros; i++) {
            producers[i] = new Producer(queue, random.nextInt(10000));
            new Thread(prosGroup, producers[i], "Prod  " + (char) (i + 65)).start();
        }

        for (int i = 0; i < mCons; i++) {
            consumers[i] = new Consumer(queue);
            new Thread(consGroup, consumers[i], "Cons " + (char) (i + 65)).start();
        }

        //warten bis Produzenten fertig
        while (prosGroup.activeCount() > 0) {
            Thread.yield();
        }

        TimeUnit.MILLISECONDS.sleep(100);
        consGroup.interrupt();
        int sumPros = 0;
        for (int i = 0; i < nPros; i++) {
            LOG.info("Prod " + (char) (i + 65) + " = " + producers[i].getSum());
            sumPros += producers[i].getSum();
        }
        int sumCons = 0;
        for (int i = 0; i < mCons; i++) {
            LOG.info("Cons " + (char) (i + 65) + " = " + consumers[i].getSum());
            sumCons += consumers[i].getSum();
        }
        LOG.info(sumPros + " = " + sumCons);
        LOG.info("queue size = " + queue.size());
        LOG.info("queue empty? " + queue.empty());
    }

    /**
     * Privater Konstruktor.
     */
    private DemoBoundedBuffer() {
    }
}
