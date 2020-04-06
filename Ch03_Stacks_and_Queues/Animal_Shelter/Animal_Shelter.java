import java.util.LinkedList;
import java.time.LocalDateTime;
import java.util.Queue;

/**
 * Implementation of an animal shelter where a cat, dog or any can be taken from based on date of entry (FIFO).
 * Cats and dogs can be added to the shelter as well but only the animals (dog, cat or any) that have been in the 
 * shelter the longest can be taken out of it.
 * @author Gillis Werrebrouck
 */

public class Animal_Shelter {
    public static void main(final String args[]) {
        final Shelter shelter = new Shelter();

        final Dog dog01 = new Dog("Vixen");
        final Cat cat01 = new Cat("Sam");
        final Dog dog02 = new Dog("Max");
        final Cat cat02 = new Cat("Charlie");

        shelter.enqueue(dog01);
        shelter.enqueue(cat01);
        shelter.enqueue(dog02);
        shelter.enqueue(cat02);

        shelter.dequeueAny();
        shelter.dequeueDog();
        shelter.dequeueAny();
        shelter.dequeueAny();
        shelter.dequeueAny();
        shelter.dequeCat();
    }
}

abstract class ShelterAnimal {
    private final String name;
    private LocalDateTime entryDateTime;

    public ShelterAnimal(final String name) {
        this.name = name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    public void setEntryDateTime(final LocalDateTime entryDateTime) {
        this.entryDateTime = entryDateTime;
    }

    /**
     * @return the entryDateTime
     */
    public LocalDateTime getEntryDateTime() {
        return entryDateTime;
    }
}

class Dog extends ShelterAnimal {
    public Dog(final String name) {
        super(name);
    }
}

class Cat extends ShelterAnimal {
    public Cat(final String name) {
        super(name);
    }
}

class Shelter {
    Queue<Dog> dogs = new LinkedList<Dog>();
    Queue<Cat> cats = new LinkedList<Cat>();

    public Shelter() {}

    public void enqueue(final Dog dog) {
        dog.setEntryDateTime(LocalDateTime.now());
        System.out.println("enqueuing " + dog.getName() + " at " + dog.getEntryDateTime().toString());
        dogs.add(dog);
    }

    public void enqueue(final Cat cat) {
        cat.setEntryDateTime(LocalDateTime.now());
        System.out.println("enqueuing " + cat.getName() + " at " + cat.getEntryDateTime().toString());
        cats.add(cat);
    }

    public Dog dequeueDog() {
        if(dogs.size() == 0) {
            System.out.println("no dogs in shelter");
            return null;
        }

        dogs.peek().setEntryDateTime(null);
        System.out.println("denqueuing " + dogs.peek().getName());
        return dogs.remove();
    }

    public Cat dequeCat() {
        if(cats.size() == 0) {
            System.out.println("no cats in shelter");
            return null;
        }

        cats.peek().setEntryDateTime(null);
        System.out.println("denqueuing " + cats.peek().getName());
        return cats.remove();
    }

    public ShelterAnimal dequeueAny() {
        final Dog dog = dogs.peek();
        final Cat cat = cats.peek();

        if(dog == null && cat == null) {
            System.out.println("shelter is empty");
            return null;
        } else if(dog == null) {
            return dequeCat();
        } else if(cat == null) {
            return dequeueDog();
        }

        if(dog.getEntryDateTime().compareTo(cat.getEntryDateTime()) > 0) {
            return dequeCat();
        }
        return dequeueDog();
    }
}
