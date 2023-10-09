package lab1;

class Walk implements Strategy{
    @Override
    public void move(){ //overriding move method from Strategy class
        System.out.println("Hero is walking");
    }
}
