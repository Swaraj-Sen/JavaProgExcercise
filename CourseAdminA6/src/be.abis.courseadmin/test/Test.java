package be.abis.courseadmin.test;

import be.abis.courseadmin.enumeration.Gender;
import be.abis.courseadmin.exception.CompanyNotFoundException;
import be.abis.courseadmin.exception.PriceException;
import be.abis.courseadmin.exception.PriceTooHighException;
import be.abis.courseadmin.exception.PriceTooLowException;
import be.abis.courseadmin.model.*;
import be.abis.courseadmin.repository.FileCompanyRepository;
import be.abis.courseadmin.repository.MemoryArrayCompanyRepository;
import be.abis.courseadmin.repository.MemoryListCompanyRepository;
import be.abis.courseadmin.service.AbisCompanyService;
import be.abis.courseadmin.service.CompanySortType;

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
        Company com1 = null;
        try {
            com1 = memoryRepo.findCompany("Python");
        } catch (CompanyNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(com1.getCompanyNumber());
        Company com2 = null;
        try {
            com2 = memoryRepo.findCompany(3);
        } catch (CompanyNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(com2);

        ((CourseParticipant)per).attendCourse(javaCourse);
        ((Instructor)per).teachCourse(javaCourse);

        System.out.println(per);

        //A5 task 1 & 2
        try {
            Course cour = new Course("Python",5,10);
            CompanySession csess = new CompanySession(cour, "10/10/2026", locationCourse, per);
            csess.setNumberofParticipants(5);
            double totPrice = csess.calculatePrice();
            double maxPrice = 10.0;

            System.out.println("tot:"+totPrice);
            if (totPrice > maxPrice) {
                throw new PriceTooHighException("Price is higher than max price " + maxPrice);

            }
        } catch (PriceTooHighException e) {
            System.out.println("got exception "+e.getMessage());
        }
        finally {
            System.out.println("finally block executed");
        }

        //Task 4
        try
        {
            Company abisCompany = new Company("ABIS");
            abisCompany.requestPriceOfferForCompanySession(javaCourse,2);
        }
        catch (PriceTooLowException ex)
        {
            System.out.println("PriceTooLowException: "+ex.getMessage());
        }
        finally
        {
            System.out.println("finally block executed");
        }

        //Task 5
        Company abisCompany = new Company("IBM");
        Course[] arCourse =new Course[2];
        arCourse[0] = new Course("Python",50,50);
        arCourse[1] = new Course("Java",1,10);

        for (Course c : arCourse) {
            try {
                abisCompany.requestPriceOfferForCompanySessionMul(c,4);
            } catch (PriceException ex) {
                System.out.println(ex.getMessage());
            } finally {
                System.out.println("finally block executed");
            }
        }

        //Task 6
        MemoryArrayCompanyRepository memRepo = new MemoryArrayCompanyRepository();

        try
        {
            memRepo.findCompany("AXA");
        }
        catch (CompanyNotFoundException cex)
        {
            System.out.println(" Caught Exception: "+cex.getMessage());
            System.out.println(" StackTrace: "+cex.getStackTrace());
        }
        finally {
            System.out.println("finally block executed");
        }

        Company com = new Company("ABIS");
        Company com3 = new Company("ING");
        Person per1 =new Person("John","Smith",com,Gender.MALE);
        Person per2 =new Person("Marry","Jane",com,Gender.FEMALE);
        Person per3 =new Person("Martha","Smith",com3,Gender.FEMALE);
        Person perInstr =new Person("Alex","Vnet",com,Gender.MALE);
        PublicSession ps = new PublicSession(javaCourse,"20/10/2026",com2,perInstr) ;
        ps.addEnrollments(per1,per2,per3);

        System.out.println("Print participant list:");
        ps.printParticipationList();

        System.out.println("find participants who works for ABIS:");
        ps.findAbisParticipants().forEach(
                courPart->
                        System.out.println(courPart.getInfo())
        );

        System.out.println("removing participants who works for ABIS:");
        ps.removeAbisParticipants();
        ps.printParticipationList();

        MemoryListCompanyRepository memCompRepo = new MemoryListCompanyRepository();
        memCompRepo.addCompany(new Company(1,"ING"));
        memCompRepo.addCompany(new Company(3,"ABIS"));
        memCompRepo.addCompany(new Company(2,"IBM"));

        AbisCompanyService abisCompSer = new AbisCompanyService(memCompRepo);
        System.out.println("sorting companies by name");
        for(Company c: abisCompSer.sortAllCompaniesByName())
        {
            System.out.println(c.getCompanyNumber()+":"+c.getName());
        }
        System.out.println("sorting companies by company number ascending");
        for(Company c: abisCompSer.sortAllComapniesByCompanyNumber(CompanySortType.ASC))
        {
            System.out.println(c.getCompanyNumber()+":"+c.getName());
        }
        System.out.println("sorting companies by company number descending");
        for(Company c: abisCompSer.sortAllComapniesByCompanyNumber(CompanySortType.DESC))
        {
            System.out.println(c.getCompanyNumber()+":"+c.getName());
        }

        System.out.println("Reading companies with FileCompanyRepository");
        FileCompanyRepository fileCompRepo = new FileCompanyRepository();
        for(Company fileCom : fileCompRepo.findAllCompanies())
        {
            System.out.println(fileCom.getCompanyNumber()+":"+ fileCom.getName());
        }

        System.out.println("Deleting some companies from file");
        fileCompRepo.deleteCompany(1);
        for(Company fileCom : fileCompRepo.findAllCompanies())
        {
            System.out.println(fileCom.getCompanyNumber()+":"+ fileCom.getName());
        }

        System.out.println("Changing the file content");
        Company comColruyt = new Company(38,"Colruyt Evere");
        fileCompRepo.updateCompany(comColruyt);
        for(Company fileCom : fileCompRepo.findAllCompanies())
        {
            System.out.println(fileCom.getCompanyNumber()+":"+ fileCom.getName());
        }
    }
}
