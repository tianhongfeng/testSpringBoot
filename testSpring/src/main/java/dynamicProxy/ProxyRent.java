package dynamicProxy;

public class ProxyRent implements Rent{


    // 被代理的接口
    private Rent rent;

    public ProxyRent(Rent rent){
        this.rent = rent;
    }

    @Override
    public void rentHouse() {
        System.out.println("before");
        rent.rentHouse();
        System.out.println("after");
    }
}
