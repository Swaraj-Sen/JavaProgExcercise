package be.abis.courseadmin.exception;

public class PriceTooLowException extends PriceException {
    public PriceTooLowException(String message) {
        super(message);
    }

    public PriceTooLowException(double actualPrice, String message) {
        super(actualPrice,message);
    }

    @Override
    public String getMessage()
    {
        if(this.getLimitPrice() > 0) {
            return "Price is  lower than " + this.getLimitPrice();
        }

        return super.getMessage();
    }
}
