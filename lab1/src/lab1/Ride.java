package lab1;

public class Ride extends Strategy{
    public Ride(){} //constructor for class Ride
    @Override
    public void move(){
        System.out.println("Hero is riding");
    }
}
