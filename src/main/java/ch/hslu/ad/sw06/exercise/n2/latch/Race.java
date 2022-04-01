package ch.hslu.ad.sw06.exercise.n2.latch;

import java.util.LinkedList;
import java.util.List;

public final class Race {

    private final Synch starterBox = new Latch();
    private final static List<Thread> participants = new LinkedList<>();

    public Race(final int numOfParticipants) {
        for (int i = 1; i <= numOfParticipants; i++) {
            Thread participant = new Thread(new RaceHorse(this.starterBox), "Horse " + i);
            participants.add(participant);
            participant.start();
        }
    }

    public void startRace() {
        this.starterBox.release();
    }

    public void interruptRace() {
        for (Thread participant : participants) {
            participant.interrupt();
        }
    }
}
