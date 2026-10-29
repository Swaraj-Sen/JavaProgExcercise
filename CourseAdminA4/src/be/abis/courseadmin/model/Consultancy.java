package be.abis.courseadmin.model;

public class Consultancy extends Service {
    private String name;

    public Consultancy() {

    }

    public Consultancy(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public final double calculatePrice() {
        return 150.0;
    }
}
