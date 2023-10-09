package lab1;

public class Walk extends Strategy{
    public Walk() {
    }//constructor for class Walk
    @Override
    public void move(){ //overriding move method from Strategy class
        System.out.println("Hero is walking");
    }
}
