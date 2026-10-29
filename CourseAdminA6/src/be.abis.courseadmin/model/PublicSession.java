package be.abis.courseadmin.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PublicSession extends Session {
    private final List<CourseParticipant> lstParticipant;
    public PublicSession(Course sessionCourse, String startDate, Company location, Person instructor){
        super(sessionCourse, startDate, location, instructor);
        lstParticipant = new ArrayList<>();
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

    public void addEnrollment(CourseParticipant courPart)
    {
        lstParticipant.add(courPart);
    }

    public void addEnrollments(CourseParticipant...courPart)
    {
        for(CourseParticipant crp:courPart)
        {
            addEnrollment(crp);
        }
    }

    public void cancelEnrollment(CourseParticipant courPart)
    {
        lstParticipant.remove(courPart);
    }

    public void printParticipationList()
    {
        for(CourseParticipant courPart:lstParticipant)
        {
            System.out.println(courPart.getInfo());
        }
        lstParticipant.forEach(corp-> System.out.println(corp.getInfo()));
    }

    public List<CourseParticipant> findAbisParticipants()
    {
        return lstParticipant.stream().filter(com->com.getComapnyInfo().equals("ABIS")).toList();
    }

    public void removeAbisParticipants()
    {
        Iterator<CourseParticipant> courseIterator = lstParticipant.iterator();

        while (courseIterator.hasNext())
        {
            CourseParticipant courPart = courseIterator.next();
            if(courPart.getComapnyInfo().equals("ABIS"))
            {
                courseIterator.remove();
            }
        }
    }
}
