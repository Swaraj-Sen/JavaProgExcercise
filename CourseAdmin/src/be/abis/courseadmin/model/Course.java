package be.abis.courseadmin.model;

public class Course {
    private String title;
    private int numofDays;
    private double pricePerDay;

    //constructor
    public Course(String title, int numofDays, double pricePerDay) {
        this.title = title;
        this.numofDays = numofDays;
        this.pricePerDay = pricePerDay;
    }

    //getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumofDays() {
        return numofDays;
    }

    public void setNumofDays(int numofDays) {
        this.numofDays = numofDays;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public void printInfo()
    {
        System.out.println("Title: " + title);
        System.out.println("Number of days: " + numofDays);
        System.out.println("Price per day: " + pricePerDay);
        System.out.println("The total course price is : "+calculateTotalPrice());
    }

    double calculateTotalPrice()
    {
        double totalPrice = pricePerDay * numofDays;
        return totalPrice;
    }

    public double calculateTotalPrice(double reductionPercentage)
    {
        double totalPrice = calculateTotalPrice()*(1-reductionPercentage/100.0);
        return totalPrice;
    }

}
