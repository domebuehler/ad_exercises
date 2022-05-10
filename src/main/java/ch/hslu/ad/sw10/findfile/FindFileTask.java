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
package ch.hslu.ad.sw10.findfile;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.concurrent.CountedCompleter;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Codevorlage zu CountedCompleter für eine Dateisuche.
 */
@SuppressWarnings("serial")
public final class FindFileTask extends CountedCompleter<String> {

    private final String regex;
    private final File dir;
    private final AtomicReference<String> result;
    private static final int THRESHOLD = 100;

    private static final Logger LOG = LogManager.getLogger(FindFileTask.class);

    /**
     * Erzeugt eine File-Such-Aufgabe.
     *
     * @param regex Ausdruck der den Filenamen enthält.
     * @param dir   Verzeichnis in dem das File gesucht wird.
     */
    public FindFileTask(String regex, File dir) {
        this(null, regex, dir, new AtomicReference<>(null));
    }

    private FindFileTask(final CountedCompleter<?> parent, final String regex, final File dir, final AtomicReference<String> result) {
        super(parent);
        this.regex = regex;
        this.result = result;
        this.dir = dir;
    }

    @Override
    public void compute() {
        final File[] list = this.dir.listFiles();
        if (list.length < THRESHOLD) {
            findFile(this.dir);
        } else {
            int partitionIndex = list.length / 2;
            this.addToPendingCount(2);
            final FindFileTask taskLeft = new FindFileTask(this, this.regex, list[0], this.result);
            taskLeft.fork();
            final FindFileTask taskRight = new FindFileTask(this, this.regex, list[partitionIndex], this.result);
            taskRight.fork();
        }
    }

    @Override
    public String getRawResult() {
        if (result != null) {
            return this.result.get();
        }
        return null;
    }

    private void findFile(final File dir) {
        final File[] list = dir.listFiles();
        if (list != null) {
            for (File file : list) {
                if (file.isDirectory()) {
                    findFile(file);
                } else if (this.regex.equalsIgnoreCase(file.getName())) {
                    LOG.info(file.getParentFile());
                    this.result.set(file.getAbsolutePath());
                    this.quietlyCompleteRoot();
                    break;
                }
            }
        }
        this.tryComplete();
    }
}
