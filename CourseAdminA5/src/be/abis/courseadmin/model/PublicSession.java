package be.abis.courseadmin.model;

public class PublicSession extends Session {
    public PublicSession(Course sessionCourse, String startDate, Company location, Person instructor){
        super(sessionCourse, startDate, location, instructor);
    }

    @Override
    public void printInfo()
    {
        super.printInfo();
    }


    @Override
    public double calculatePrice()
    {
        return 200.0;
    }

    @Override
    public String getOrganizor()
    {
        return this.getInstructor().getFirstName() + " " + this.getInstructor().getLastName();
    }


}
