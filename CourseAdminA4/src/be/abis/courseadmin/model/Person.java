package be.abis.courseadmin.model;

import be.abis.courseadmin.enumeration.Gender;
import be.abis.courseadmin.model.Company;
import be.abis.courseadmin.model.Course;
import be.abis.courseadmin.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a person
 *
 * @author Swaraj Sen
 * @Version 1.0
 */
public class Person implements Instructor,CourseParticipant {
    private String firstName;
    private String lastName;
    private Company personCompany = null;
    private static int counter = 0;
    private final int idNumber ; //it is set only once
    private List<String> hobbies;
    private Gender genderPerson;

    /**
     *
     * @param firstName The first name of the person
     * @param lastName The last name of the person
     * @param genderPerson The gender of the person
     */
    //constructors
    public Person(String firstName, String lastName, Gender genderPerson) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.genderPerson = genderPerson;
        counter++;
        idNumber = counter;
        hobbies = new ArrayList();
    }

    public Person(String firstName, String lastName, Company personCompany, Gender genderPerson) {
        this(firstName, lastName, genderPerson);
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

    /**
     *
     * @param course The course to attens
     */
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
        /*String message = "";

        if(personCompany != null)
        {
            message = "works for "+ personCompany.getName();
        }else
        {
            message ="is not linked to a company for the moment";
        }
        System.out.println(firstName + " " + lastName+ " " + message);
        System.out.println("Person number: " + getIdNumber());*/
        System.out.println(aboutInfo());
    }

    @Override
    public String toString() {
        return aboutInfo();
    }

    private String aboutInfo()
    {
        String message = "";
        String pronounceCapitalized = StringUtils.capitalize(genderPerson.getSubjectPronoun());
        String possCapitalized = StringUtils.capitalize(genderPerson.getPossessivePronoun());
        if(personCompany != null)
        {
            message = " works for "+ personCompany.getName();
        }else
        {
            message =" is not linked to a company for the moment";
        }
        message = "Name of the person is "+ firstName + " " + lastName+ ". "+pronounceCapitalized + message;
        message += ". "+ possCapitalized+ " person number is: " + getIdNumber() +".";
        return message;
    }

    @Override
    public void teachCourse(Course course) {
        System.out.println(firstName + " " + lastName + " teaches " + course.getTitle());
    }

}
