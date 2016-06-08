package person;

import sex.Sex;

/**
 * Created by Р on 07.06.2016.
 */
public class Person {

    private String name;
    private int age;
    private Sex sex;
    public void setName(String newName){
        this.name = newName;
    }
    public void setAge(Integer newAge){
        this.age = newAge;
    }
    public void setSex(Sex newSex){
        sex = newSex;
    }
    public String getName(){
        return name;
    }
    public Integer getAge(){
        return age;
    }
    public Sex getSex(){
        return sex;
    }
    @Override
    public String toString(){
        return "[Person: " + name + ", " + age + ", "+ sex +"]";
    }
}
