package runner;

import mySupplier.MySupplier;
import person.Person;
import personComparator.PersonComparator;
import sex.Sex;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * Created by Р on 08.06.2016.
 */
public class Runner {

    public static void run() {
        MySupplier mySupplier = new MySupplier();
        Consumer<Person> reduceAge = (person)->{
            if(person.getSex()== Sex.Female && person.getAge()>=18) {
                person.setAge(person.getAge()-10);
            }
        };
        List<Person> personList = Stream.generate(mySupplier)
                .limit(10)
                .collect(Collectors.toList());
        System.out.println("List after init:  "+personList);
        System.out.println("Average age:      "+getAverageAge(personList));
        System.out.println("Sorted by age:    "+sortByAge(personList));
        System.out.println("Grouped by index: "+groupingByName(personList));
        System.out.println("Filtered by age:  "+filteringByAge(personList));
        System.out.println("Reduce age for women: "+makeWomensYounger(personList,reduceAge));
    }


    private static int getAverageAge(List<Person> inputList) {
        int averageAge = (int) inputList.stream()
                .limit(10)
                .mapToInt(Person::getAge).average().getAsDouble();
        return averageAge;
    }

    private static List<Person> sortByAge(List<Person> inputList){
        PersonComparator personComparator = new PersonComparator();
        List<Person> sortedList = inputList.stream()
                .limit(10)
                .sorted( personComparator)
                .collect(Collectors.toList());
        return sortedList;
        }

    private static Map<String,Long> groupingByName(List<Person> inputList){
        Map<String,Long> groupedMap = inputList.stream()
                .limit(10)
                .collect(Collectors.groupingBy(Person::getName, Collectors.counting()));
        return groupedMap;
    }
    private static List<Person> filteringByAge(List<Person> inputList) {
        List<Person> filteredList = inputList.stream()
                .limit(10)
                .filter((person)->person.getAge()>=18)
                .collect(Collectors.toList());
        return filteredList;
    }
    private static List<Person> makeWomensYounger(List<Person> person, Consumer<Person> inputFunc){
        person.forEach(inputFunc);
        return person;
    }
}



