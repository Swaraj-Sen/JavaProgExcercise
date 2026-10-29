package be.abis.courseadmin.model;

public class Company {
    private String name;

    //constructor
    public Company(String name) {
        this.name = name;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printInfo()
    {
        System.out.println("Company Name: " + name);
    }

}
