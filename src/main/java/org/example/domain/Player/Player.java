package org.example.domain.Player;

public class Player {

    private int attemptCount = 0;

    public int getAttemptCount() {
        return attemptCount;
    }

    public void increaseAttemptCount() {
        ++this.attemptCount;
    }

}
