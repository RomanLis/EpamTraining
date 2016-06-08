package personComparator;

import person.Person;

import java.util.Comparator;

/**
 * Created by Р on 08.06.2016.
 */
public class PersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person person1, Person person2) {
        return person1.getAge().compareTo(person2.getAge());
    }
}
