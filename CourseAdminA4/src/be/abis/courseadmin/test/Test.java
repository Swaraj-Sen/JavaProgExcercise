package be.abis.courseadmin.test;

import be.abis.courseadmin.enumeration.Gender;
import be.abis.courseadmin.model.*;
import be.abis.courseadmin.repository.MemoryArrayCompanyRepository;

public class Test {
    public static void main(String[] args) {
        Person per  = new Person(
                "Bob","Smith",new Company("ABIS"),
                Gender.MALE
        );
        Course javaCourse = new Course("JavaCourse",10,15.6);

        Company locationCourse = new Company("RTL");
        PublicSession ps1 = new PublicSession(javaCourse,"10/10/2026",locationCourse,per);
        CompanySession cs1 = new CompanySession(javaCourse,"10/10/2026",locationCourse,per);
        CompanySession cs2 = new CompanySession(javaCourse,"10/10/2026",locationCourse,per);
        cs2.setNumberofParticipants(10);

        //Task 1
        ps1.printInfo();
        cs1.printInfo();
        cs2.printInfo();

        //Task 2
        Session[] arrSession = new Session[3];
        arrSession[0] = ps1;
        arrSession[1] = cs1;
        arrSession[2] = cs2;

        for(Session s : arrSession){
            s.printInfo();
            System.out.println();
        }

        //Task 3
        Consultancy cons = new Consultancy("IT consultancy");
        Service[] services = new Service[4];
        services[0] = cons;
        services[1] = ps1;
        services[2] = cs1;
        services[3] = cs2;
        for(Service s : services){
            System.out.println("The price for the "+ s.getClass().getSimpleName()+" is "+s.calculatePrice()+".");

            if(s instanceof Session) {
                ((Session)s).printInfo();
            }
        }

        //Task 5
        System.out.println(per);
        System.out.println(javaCourse);

        MemoryArrayCompanyRepository memoryRepo = new MemoryArrayCompanyRepository();
        Company com1 = memoryRepo.findCompany("Python");
        System.out.println(com1.getCompanyNumber());
        Company com2 = memoryRepo.findCompany(3);
        System.out.println(com2);

        ((CourseParticipant)per).attendCourse(javaCourse);
        ((Instructor)per).teachCourse(javaCourse);

        System.out.println(per);
    }
}
