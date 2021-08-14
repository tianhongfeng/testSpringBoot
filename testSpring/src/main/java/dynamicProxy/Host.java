package dynamicProxy;

public class Host implements Rent{
    @Override
    public void rentHouse() {
        System.out.println("房东租房子");
    }
}
