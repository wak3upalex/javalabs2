package lab1;

public class Hero {
    Strategy heroStrategy = new Walk();             //setting default strategy of movemement (walk)

    public void setStrategy(Strategy strategy) {    //setter for strategy via Object of Strategy
        this.heroStrategy = strategy;
    }

    public void move(){
        heroStrategy.move();
    }
}
