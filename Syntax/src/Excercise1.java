public class Excercise1 {
    public static void main(String[] args) {
        String firstName = "John";
        int age = 43;
        double salary = 10000.00;
        boolean isSenior = false;
        Gender gender = Gender.Male;

        System.out.println("Information about ABIS Instructor: \n"+
                    "Firstname:" + firstName + "\n" +
                    "Age:" + age + "\n" +
                    "Salary:" + salary + "\n" +
                    "Senior:" + isSenior);

        double taxRate = 0.48;
        System.out.println("The monthly net salary of "+firstName+" is: " + calculateNetSalary(salary,taxRate));

        double grossYearlySalary = 40000;
        System.out.println("The yearly net salary of "+firstName+" is: " + calculateYearlyNetSalary(grossYearlySalary));

        System.out.println(
                firstName + " is " + ((isSenior)?"":"not")+" a Senior"
        );

        int startAge=23;
        double monthyGrossSalary = 2700.0;
        double percentIncrease = 1.05;
        printSalaryHistory(firstName,monthyGrossSalary,age,startAge,percentIncrease,0);

        //print with limit upto 35 years
        int maxWorkYear = 25;
        age = 53;
        printSalaryHistory(firstName,monthyGrossSalary,age,startAge,percentIncrease,maxWorkYear);

        String[] arDomains = {"Domain1","Domain2","Domain3"};
        printInstructorDomains(firstName,arDomains);

        System.out.println(
                firstName + " works for ABIS. "+
                        getGenderPronoun(gender,PronounType.Possesive) + " age is "+age+"."+
                        getGenderPronoun(gender,PronounType.Possesive) + " salary is " + salary);

    }

    public enum Gender
    {
        Male,Female,Other
    }

    public enum PronounType
    {
        Personal,
        Reflexive,
        Possesive
    }


    private static String getGenderPronoun(Gender instrctGender, PronounType instrctPronounType)
    {
        String pronoun = "";
        switch (instrctGender)
        {
            case Male:
                if(instrctPronounType == PronounType.Personal)
                {
                    pronoun = "he";
                }
                else if (instrctPronounType == PronounType.Reflexive)
                {
                    pronoun = "him";
                }
                else
                {
                    pronoun = "his";
                }
                break;
                case Female:
                if(instrctPronounType == PronounType.Personal)
                {
                    pronoun = "she";
                }
                else if (instrctPronounType == PronounType.Reflexive)
                {
                    pronoun = "her";
                }
                else
                {
                    pronoun = "her";
                }
                break;
                case Other:
                    if(instrctPronounType == PronounType.Personal)
                    {
                        pronoun = "they";
                    }
                    else if (instrctPronounType == PronounType.Reflexive)
                    {
                        pronoun = "them";
                    }
                    else
                    {
                        pronoun = "their";
                    }
                    break;
                    default:


        }

        if(!pronoun.isEmpty())
        {
            pronoun = pronoun.substring(0,1).toUpperCase()+pronoun.substring(1);
        }

        return pronoun;
    }

    private static void printInstructorDomains(String firstName,String[] arDomains)
    {
        System.out.println(firstName + " has domains:\n ");
        for(String domain : arDomains)
        {
            System.out.println(domain);
        }
    }
    private static double calculateNetSalary(double salary, double taxRate)
    {
        //deduct 48 percent from salary
       double netsalary = salary - salary * taxRate;
       return netsalary;
    }

    private static double calculateYearlyNetSalary(double yearlyGrossSalary)
    {
        double taxRate = 0;
        double yearlyNetSalary = 0;

        if(yearlyGrossSalary < 15200)
        {
            taxRate =  25;
        }
        else if(yearlyGrossSalary >= 15200 && yearlyGrossSalary < 26830)
        {
            taxRate =  40;
        }
        else if (yearlyGrossSalary >= 26830 && yearlyGrossSalary < 46400)
        {
            taxRate =  45;
        }
        else
        {
            taxRate =  50;
        }

        yearlyNetSalary = yearlyGrossSalary - yearlyGrossSalary*taxRate/100;
        return yearlyNetSalary;
    }

    private static void printSalaryHistory(String firstName,
                                           double monthlyGrossSalary,
                                           int age,int startingAge,
                                           double percentIncrease,
                                           int maxYearWork)
    {
        double yearlyGrossSalary = monthlyGrossSalary * 12;
        double netYearlySalary = 0;
        double montlyNetSalary = 0;
        int incrAge = startingAge;

        //limit should be on the number of working years
        int maxAgeIncr = 0;

        //check max year of work
        if(maxYearWork > 0)
            maxAgeIncr = startingAge + maxYearWork;

        while(incrAge <= age)
        {
            netYearlySalary = calculateYearlyNetSalary(yearlyGrossSalary);
            montlyNetSalary = netYearlySalary/12;
            System.out.println(firstName +"'s net salary at "+ incrAge + " is " + montlyNetSalary);

            boolean blnDoIncr = isBlnDoIncr(maxAgeIncr, incrAge);

            if(blnDoIncr)
            {
                yearlyGrossSalary = yearlyGrossSalary * percentIncrease;
            }

            incrAge += 2;
        }

    }

    private static boolean isBlnDoIncr(int maxAgeIncr, int incrAge) {
        boolean blnDoIncr = false;
        if(maxAgeIncr > 0) {
            if (incrAge <= maxAgeIncr) {
                blnDoIncr = true;
            }
        }
        else
        {
            blnDoIncr = true;
        }
        return blnDoIncr;
    }
}
