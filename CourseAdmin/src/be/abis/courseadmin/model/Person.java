package be.abis.courseadmin.model;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String firstName;
    private String lastName;
    private Company personCompany = null;
    private static int counter = 0;
    private final int idNumber ; //it is set only once
    private List<String> hobbies;

    //constructors
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        counter++;
        idNumber = counter;
        hobbies = new ArrayList();
    }

    public Person(String firstName, String lastName, Company personCompany) {
        this(firstName, lastName);
        this.personCompany = personCompany;
    }

    //getters and setters
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Company getPersonCompany() {
        return personCompany;
    }
    public void setPersonCompany(Company personCompany) {
        this.personCompany = personCompany;
    }

    public void attendCourse(Course course) {
        System.out.println(firstName + " " + lastName + " attends " + course.getTitle());

    }

    private int getIdNumber() {
        return idNumber;
    }

    public void addHobby(String hobby) {
        hobbies.add(hobby);
    }

    public void addHobbies(String... hobbies) {
        for (String hobby : hobbies) {
            this.hobbies.add(hobby);
        }
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void printInfo()
    {
        String message = "";

        if(personCompany != null)
        {
            message = "works for "+ personCompany.getName();
        }else
        {
            message ="is not linked to a company for the moment";
        }
        System.out.println(firstName + " " + lastName+ " " + message);
        System.out.println("Person number: " + getIdNumber());
    }
}
