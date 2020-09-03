import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Implementation of dining philosophers problem.
 * 
 * @author Gillis Werrebrouck
 */

public class Dining_Philosophers {
    public static void main(final String args[]) {
        int numberOfPhilosophers = 4;
        Chopstick chopsticks[] = new Chopstick[numberOfPhilosophers];
        Philosopher philosophers[] = new Philosopher[numberOfPhilosophers];

        for (int i = 0; i < numberOfPhilosophers; i++) {
          chopsticks[i] = new Chopstick();
        }

        philosophers[0] = new Philosopher(chopsticks[0], chopsticks[numberOfPhilosophers - 1]);
        for (int i = 1; i < numberOfPhilosophers; i++) {
          philosophers[i] = new Philosopher(chopsticks[i], chopsticks[i-1]);
        }

        for (int i = 0; i < numberOfPhilosophers; i++) {
          philosophers[i].eat();
        }
    }
}

class Chopstick {
  private Lock lock;

  public Chopstick() {
    this.lock = new ReentrantLock();
  }

  public boolean pickUp() {
    return this.lock.tryLock();
  }

  public void putDown() {
    this.lock.unlock();
  }
}

class Philosopher extends Thread {
  private final Chopstick left;
  private final Chopstick right;

  public Philosopher(final Chopstick left, final Chopstick right) {
    this.left = left;
    this.right = right;
  }

  public void eat() {
    if (this.pickupChopsticks()) {
      // EAT
      this.putDownChopsticks();
    }
  }

  public boolean pickupChopsticks() {
    if (!this.left.pickUp()) {
      return false;
    }
    if (!this.right.pickUp()) {
      this.left.putDown();
      return false;
    }
    return true;
  }

  public void putDownChopsticks() {
    this.left.putDown();
    this.right.putDown();
  }

  public void run() {
    for (int i = 0; i < 20; i++) {
      this.eat();
    }
  }
}
