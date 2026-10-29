package be.abis.courseadmin.model;

public abstract class Session extends Service {
    private Course sessionCourse;
    private String startDate;
    private Company location;
    private Person instructor;

    public Session(Course sessionCourse, String startDate, Company location, Person instructor) {
        this.sessionCourse = sessionCourse;
        this.startDate = startDate;
        this.location = location;
        this.instructor = instructor;
    }

    public Course getSessionCourse() {
        return sessionCourse;
    }
    public void setSessionCourse(Course sessionCourse) {
        this.sessionCourse = sessionCourse;
    }
    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public Company getLocation() {
        return location;
    }
    public void setLocation(Company location) {
        this.location = location;
    }
    public Person getInstructor() {
        return instructor;
    }
    public void setInstructor(Person instructor) {
        this.instructor = instructor;
    }

    public void printInfo()
    {
        String messsage = "The "+ getSessionCourse().getTitle() +" will start on "+
                getStartDate() +" .It will take place at "+getLocation().getName()+"."+
                " Your instructor is "+getInstructor().getFirstName()+ " "+getInstructor().getLastName() + " of "+getInstructor().getPersonCompany();
        System.out.println(messsage);
    }

    public abstract double calculatePrice();
    public abstract String getOrganizor();
}
