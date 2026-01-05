class Vehical {
    public String vehical_type;

    public void info() {
        System.out.println("\nVehical Type: " + vehical_type);
    }
}

class Car extends Vehical {
    public String compony_name, model_name;
    @Override
    public void info() {
        super.info();
        System.out.println("\nCompany: " + compony_name);
        System.out.println("\nModel: " + model_name);
    }
}

public class _18_MethodOverRiddingClass {
    public static void main(String args[]) {
        Car car = new Car();
        car.vehical_type = "car";
        car.compony_name = "TATA";
        car.model_name = "TATA SS 4";
        car.info();
        ((Vehical)car).info();
    }
}