package be.abis.courseadmin.model;

public class TopConsultancy extends Consultancy {
    public TopConsultancy(String name) {
        super(name);
    }


    public void doExtras() {
        System.out.println("Top Consultancy " + super.getName());
    }

}
