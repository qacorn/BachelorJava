package com.class2018092607;

import java.io.IOException;

public class Test {

    public static void main(String[] args) {
        Address address = new Address("hebei", "chengde", "PeaceStreet");
        Person person = new Person(10, "Mike", address);

        try {
            Person clonePerson = (Person) person.deepClone();
            System.out.println(clonePerson);


            person.getAdress().setProvince("beijing");
            clonePerson.getAdress().setStreet("PeopleStreet");
            System.out.println("原 " + person);
            System.out.println("克隆  " + clonePerson);

        }  catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
