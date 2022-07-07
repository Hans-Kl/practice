package proxy.jiekou;

public class RentHouse implements IRentHouse {
    @Override
    public void rentHouse() {
        System.out.println("租了一间房子---rent");
        moveHouse();//这就是 spring 代理失效的原因
    }

    @Override
    public void moveHouse() {
        System.out.println("搬走了---rent");
    }


}