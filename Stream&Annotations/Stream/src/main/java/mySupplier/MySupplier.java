package mysupplier;

import person.Person;
import sex.Sex;

import java.util.Random;
import java.util.function.Supplier;

/**
 * Created by Р on 07.06.2016.
 */
public class MySupplier implements Supplier<Person> {
    final static int NAMESLIMIT = 20;
    final static int AGELIMIT = 151;
    final static int GENDERLIMIT = 2;

    public Person get() {
        Person person = new Person();
        Random random = new Random();
        setRandomName(person, random);
        setRandomAge(person, random);
        setRandomSex(person, random);
        return person;
    }


    public void setRandomName(Person person, Random random) {
        person.setName("name" + random.nextInt(NAMESLIMIT));
    }

    public void setRandomAge(Person person, Random random) {
        person.setAge(random.nextInt(AGELIMIT));
    }

    public void setRandomSex(Person person, Random random) {
        int newInt = random.nextInt(GENDERLIMIT);
        switch (newInt) {
            case 0:
                person.setSex(Sex.MALE);
                break;
            case 1:
                person.setSex(Sex.FEMALE);
                break;
        }
    }
}
