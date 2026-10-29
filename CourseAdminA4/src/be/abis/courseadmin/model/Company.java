package be.abis.courseadmin.model;

public class Company {
    private String name;
    private final int companyNumber;
    private static int counter = 0;

    //constructor
    public Company(String name) {
        this.name = name;
        counter++;
        companyNumber = counter;
    }

    public Company(int companyNumber, String name) {
        this.name = name;
        this.companyNumber = companyNumber;
        counter++;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCompanyNumber() {
        return companyNumber;
    }
    /*
    public void setCompanyNumber(int companyNumber) {
        this.companyNumber = companyNumber;
    }*/

    public void printInfo()
    {
        System.out.println(aboutInfo());
    }

    @Override
    public String toString() {
        return aboutInfo();
    }

    private String aboutInfo()
    {
        return "Company name " + name;
    }
}
