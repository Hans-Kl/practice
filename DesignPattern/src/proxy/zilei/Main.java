package proxy.zilei;

/**
 * @author klhans
 */
public class Main {
    public static void main(String[] args) {
        FatherRentHouse rentHouse = new SubIntermediaryProxy();
        rentHouse.rentHouse();
        rentHouse.moveHouse();
    }
}
