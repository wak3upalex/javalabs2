package lab1;

public class Fly extends Strategy{
    public Fly(){}
    @Override
    public void move(){
        System.out.println("Hero is flying");
    }
}
