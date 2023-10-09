package lab1;

public class Walk extends Strategy{
    @Override
    public void move(){ //overriding move method from Strategy class
        System.out.println("Hero is walking");
    }
}
