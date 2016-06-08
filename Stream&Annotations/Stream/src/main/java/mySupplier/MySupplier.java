package mySupplier;

import person.Person;
import sex.Sex;

import java.util.Random;
import java.util.function.Supplier;

/**
 * Created by Р on 07.06.2016.
 */
public class MySupplier implements Supplier<Person> {

    public Person get() {
        Person person = new Person();
        setRandomName(person);
        setRandomAge(person);
        setRandomSex(person);
        return person;
    }


    public void setRandomName(Person person) {
        Random random = new  Random();
        person.setName("name"+random.nextInt(20));
    }

    public void setRandomAge(Person person) {
        Random random = new  Random();
        person.setAge(random.nextInt(151));
    }

    public void setRandomSex(Person person) {
        Random random = new  Random();
        int newInt = random.nextInt(2);
        switch(newInt){
            case 0:
                person.setSex(Sex.Male);
                break;
            case 1:
                person.setSex(Sex.Female);
                break;
        }
    }
}
