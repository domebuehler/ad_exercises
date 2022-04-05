package ch.hslu.ad.sw06.latch;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public final class Race {

    private final CountDownLatch starterBox;
    private final static List<Thread> participants = new LinkedList<>();

    public Race(final int numOfParticipants) {
        this.starterBox = new CountDownLatch(numOfParticipants);
        for (int i = 1; i <= numOfParticipants; i++) {
            Thread participant = new Thread(new RaceHorse(this.starterBox), "Horse " + i);
            participants.add(participant);
            participant.start();
        }
    }

    public void startRace() {
        try {
            this.starterBox.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void interruptRace() {
        for (Thread participant : participants) {
            participant.interrupt();
        }
    }
}
