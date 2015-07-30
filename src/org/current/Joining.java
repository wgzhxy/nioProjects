package org.current;

class Sleeper extends Thread {
    
    private int duration;

    public Sleeper(String name, int sleepTime) {
        super(name);
        duration = sleepTime;
        start();
    }

    public void run() {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            System.out.println(getName() + " was interrupted."
                    + "isInterrupted():" + isInterrupted());
            return;
        }
        System.out.println(getName() + " has awakened");
    }
}

class Joiner extends Thread {
    private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println(getName() + " join completed");
    }
}

public class Joining {
    public static void main(String[] args) {
        Sleeper sleepy01 = new Sleeper("Sleepy01", 1500), sleepy02 = new Sleeper("Sleepy02", 1500);
        Joiner joiner01 = new Joiner("Joiner01", sleepy01), joiner02 = new Joiner("Joiner02", sleepy02);
        joiner01.interrupt();

    }
}