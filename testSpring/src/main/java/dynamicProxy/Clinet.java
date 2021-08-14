package dynamicProxy;

public class Clinet {

    public static void main(String[] args) {
        // 真实的实现接口的角色
        Host host = new Host();


        /**
         * 通过动态代理 来获取代理角色
          */
        ProxyInvocationHandler pin = new ProxyInvocationHandler();
        pin.setTarget(host);
        // 动态生成代理类
        Rent rent = (Rent) pin.getProxy();
        rent.rentHouse();


        // 通过静态代理 来获取代理角色
        ProxyRent proxyRent = new ProxyRent(host);
        proxyRent.rentHouse();


    }
}
