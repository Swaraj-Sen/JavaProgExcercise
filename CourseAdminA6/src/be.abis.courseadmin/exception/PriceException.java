package be.abis.courseadmin.exception;

public class PriceException extends Exception {
    private double limitPrice;
    public PriceException(String message) {
        super(message);
        this.limitPrice = 0.0;
    }

    public PriceException(double limitPrice, String message)
    {
        this(message);
        this.limitPrice = limitPrice;
    }

    public double getLimitPrice() {
        return limitPrice;
    }
}
