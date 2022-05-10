/*
 * Copyright 2022 Hochschule Luzern Informatik.
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
package ch.hslu.ad.sw10.fibo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Codevorlage für ein klassisches Beispiel zur Berechnung von Fibonacci Zahlen.
 */
@SuppressWarnings("serial")
public final class FibonacciTask extends RecursiveTask<Long> {

    private final int n;
    private static final int THRESHOLD = 30;

    /**
     * Erzeugt einen Fibonacci Task.
     *
     * @param n für die Fibonacci Berechnung.
     */
    public FibonacciTask(final int n) {
        this.n = n;
    }

    @Override
    protected Long compute() {
        return fibo(n);
    }

    private long fibo(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (n < THRESHOLD) {
            return fibo(n -2) + fibo(n -1);
        } else {
            ForkJoinTask fiboTask1 = new FibonacciTask(n - 1).fork();
            ForkJoinTask fiboTask2 = new FibonacciTask(n - 2).fork();

            try {
                return (long)fiboTask1.get() + (long) fiboTask2.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                return 0;
            }
        }
    }
}
