package proxy.zilei;

public class SubIntermediaryProxy extends FatherRentHouse {

    @Override
    public void rentHouse() {
        System.out.println("交中介费---Intermediary");
        super.rentHouse();
        System.out.println("中介负责维修管理---Intermediary");
    }

    @Override
    public void moveHouse() {
        System.out.println("退钱---Intermediary");
        super.moveHouse();
        System.out.println("找下家---Intermediary");
    }
}