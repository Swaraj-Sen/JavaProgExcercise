package be.abis.courseadmin.exception;

public class PriceTooHighException extends PriceException {
    public PriceTooHighException(String message) {
        super(message);
    }

    public PriceTooHighException(double actualPrice, String message) {
        super(actualPrice,message);
    }

    @Override
    public String getMessage()
    {
        if(this.getLimitPrice() > 0) {
            return "Price is higher than " + this.getLimitPrice() ;
        }

        return super.getMessage();
    }
}
