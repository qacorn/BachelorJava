package com.class2018092607;

public class Person extends DeepClone{



    private int age;
    private String name;
    private Address adress;

    public Person(int age, String name, Address adress) {
        this.age = age;
        this.name = name;
        this.adress = adress;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAdress() {
        return adress;
    }

    public void setAdress(Address adress) {
        this.adress = adress;
    }

//    @Override
//    protected Object clone() throws CloneNotSupportedException {
////        Person person = (Person) super.clone();
////        person.adress = (Address) adress.clone();
////
////        return person;
//        try {
//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
//            objectOutputStream.writeObject(this);
//
//            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
//            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
//            return objectInputStream.readObject();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", adress=" + adress +
                '}';
    }
}
