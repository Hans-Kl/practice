package proxy.jiekou;

/**
 * @author klhans
 */
public class Main {
    public static void main(String[] args) {
        IRentHouse rentHouse = new IntermediaryProxy(new RentHouse());
        rentHouse.rentHouse();
    }
}
