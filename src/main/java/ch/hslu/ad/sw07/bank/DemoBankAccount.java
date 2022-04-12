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
package ch.hslu.ad.sw07.bank;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Demonstration der Bankgeschäfte - Aufgabe 4 - N3_EX_WeiterführendeKonzepte.
 * Auch bei diesem Beispiel erkennt man, dass die Lösung mit Atom-Variabel einiges schneller ist (vgl. SW05)
 */
@SuppressWarnings("DuplicatedCode")
public final class DemoBankAccount {

    private static final Logger LOG = LogManager.getLogger(DemoBankAccount.class);
    final static ArrayList<BankAccount> source = new ArrayList<>();
    final static ArrayList<BankAccount> target = new ArrayList<>();
    final static int AMOUNT = 3_645_324;
    final static int NUMBER = 10;

    public static void main(String[] args) throws InterruptedException {
        initTest();
        long start = System.currentTimeMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
        for (int i = 0; i < NUMBER; i++) {
            executorService.execute(new AccountTask(source.get(i), target.get(i), AMOUNT));
            executorService.execute(new AccountTask(target.get(i), source.get(i), AMOUNT));
        }
        executorService.shutdown();
        while(!executorService.isTerminated()) {

        }
        long duration = System.currentTimeMillis() - start;

        LOG.info("Bank accounts after transfers");
        for (int i = 0; i < NUMBER; i++) {
            LOG.info("source({}) = {}; target({}) = {};", i, source.get(i).getBalance(), i, target.get(i).getBalance());
        }
        LOG.info("duration = {} ms", duration);
    }

    private static void initTest() {

        for (int i = 0; i < NUMBER; i++) {
            source.add(new BankAccount(AMOUNT));
            target.add(new BankAccount());
        }
    }

    private DemoBankAccount() {
    }
}
