package lab1;

public class Hero {
    Strategy heroStrategy = new Walk();             //setting default strategy of movemement (walk)
    private String strategy;

    public void setStrategy(String strategy) {      //setter for strategy
        this.strategy = strategy;
    }

    public void move(){
        heroStrategy.move();
    }
}
