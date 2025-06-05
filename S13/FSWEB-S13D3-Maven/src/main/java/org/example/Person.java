package org.example;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String occupation;
    private String location;
    private boolean loveDogs;

    public Person(String firstName, String lastName, int age, String occupation, String location, boolean loveDogs) {
        this(firstName, lastName, age);
        this.occupation = occupation;
        this.location = location;
        this.loveDogs = loveDogs;
    }

    public Person(String firstName, String lastName, int age) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName(){return firstName;}
    public String getLastName(){return lastName;}
    public int getAge() {return age;}
    public boolean isTeen() {return this.age>=13 && this.age<=19;}
}
