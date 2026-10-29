package be.abis.courseadmin.test;

import be.abis.courseadmin.model.*;

public class Test {
    public static void main(String[] args) {
        //Task 1
        Course courseDetail = new Course(
                "Java",
                10,
                15.6
        );

        //print info
        courseDetail.printInfo();

        //System.out.println("Total course price is: "+ courseDetail.calculateTotalPrice());

        //Task 3
        Company companyDetail = new Company(
                "ABIS"
        );
        companyDetail.printInfo();

        //Task 4
        Person per1 = new Person("Mary","Jones",
                new Company("ABIS"));
        per1.printInfo();

        Person per2 = new Person("John","Doe");
        per2.printInfo();

        Person[] listPerson = new Person[4];
        listPerson[0] = per1;
        listPerson[1] = per2;
        listPerson[2] = new Person("Alice","Smith");
        listPerson[3] = new Person("Bob","Smith",new Company("ABIS") );

        for(Person person : listPerson)
        {
            person.printInfo();
        }

        double reductionPercentage = 2;
        System.out.println("total price with reduction :"+ courseDetail.calculateTotalPrice(reductionPercentage));

        per1.addHobby("Reading");
        per1.addHobby("Writing");
        per1.addHobbies("Swimming","Hockey");

        System.out.println(per1.getFirstName() + " " + per1.getLastName() +" has hobbies:");
        for (String hobby : per1.getHobbies())
        {
            System.out.println(hobby);
        }
    }

}
