package be.abis.courseadmin.model;

public class CompanySession extends Session {
    private int numberofParticipants;

    public CompanySession(Course sessionCourse, String startDate, Company location, Person instructor){
        super(sessionCourse, startDate, location, instructor);
        this.numberofParticipants = 0;
    }

    public CompanySession(Course sessionCourse, String startDate, Company location, Person instructor, int numberofParticipants){
        super(sessionCourse, startDate, location, instructor);
        this.numberofParticipants = numberofParticipants;
    }

    public int getNumberofParticipants() {
        return numberofParticipants;
    }

    public void setNumberofParticipants(int numberofParticipants) {
        this.numberofParticipants = numberofParticipants;
    }

    @Override
    public void printInfo()
    {
        String message = "The session is offered to you by "+ getLocation().getName()+" . There will be "+this.numberofParticipants + " participants.";
        super.printInfo();
        System.out.println(message);
    }

    @Override
    public double calculatePrice()
    {
        return 300.0;
    }

    @Override
    public String getOrganizor()
    {
        return this.getInstructor().getFirstName() + " " + this.getInstructor().getLastName();
    }


}
