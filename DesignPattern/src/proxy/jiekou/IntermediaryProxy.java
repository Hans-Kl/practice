package proxy.jiekou;

public class IntermediaryProxy implements IRentHouse {

    private IRentHouse rentHouse;

    public IntermediaryProxy(IRentHouse irentHouse){
        rentHouse = irentHouse;
    }

    @Override
    public void rentHouse() {
        System.out.println("交中介费---Intermediary");
        rentHouse.rentHouse();
        System.out.println("中介负责维修管理---Intermediary");
    }

    @Override
    public void moveHouse() {
        System.out.println("退钱---Intermediary");
        rentHouse.moveHouse();
        System.out.println("找下家---Intermediary");
    }
}