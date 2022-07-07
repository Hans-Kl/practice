package proxy.zilei;

import proxy.jiekou.IRentHouse;

public class FatherRentHouse {
    public void rentHouse() {
        System.out.println("租了一间房子---rent");
        moveHouse();//这就是 spring 代理失效的原因
    }

    public void moveHouse() {
        System.out.println("搬走了---rent");
    }


}