package be.abis.courseadmin.model;

import be.abis.courseadmin.exception.PriceException;
import be.abis.courseadmin.exception.PriceTooHighException;
import be.abis.courseadmin.exception.PriceTooLowException;

public class Company {
    private String name;
    private final int companyNumber;
    private static int counter = 0;
    private static final double MIN_PRICE_SESS = 5000.0;
    private static final double MAX_PRICE_SESS = 100.0;

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

    public double getMinPriceSess()
    {
        return MIN_PRICE_SESS;
    }

    public double getMaxPriceSess()
    {
        return MAX_PRICE_SESS;
    }


    public void printInfo()
    {
        System.out.println(aboutInfo());
    }

    public double requestPriceOfferForCompanySession(Course c,int numberOfparticipants) throws PriceTooLowException
    {
        double totalPrice = numberOfparticipants * c.calculateTotalPrice();
        if(totalPrice < MIN_PRICE_SESS)
        {
           throw new PriceTooLowException(MIN_PRICE_SESS," Price is lower than min price of "+ MIN_PRICE_SESS);
        }

        return  totalPrice;
    }

    public double requestPriceOfferForCompanySessionMul(Course c,int numberOfparticipants) throws PriceException
    {
        double totalPrice = numberOfparticipants * c.calculateTotalPrice();
        if(totalPrice < MIN_PRICE_SESS)
        {
            throw new PriceTooLowException("Price is lower than min price of "+ MIN_PRICE_SESS);
        }
        if (totalPrice > MAX_PRICE_SESS)
        {
            throw new PriceTooHighException("Price is higher than max price of "+ MAX_PRICE_SESS);
        }

        return  totalPrice;
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
