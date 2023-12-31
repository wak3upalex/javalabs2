package lab2;

public class TestMethods {
    public void publicMethod1 (int message){
        System.out.println("Public method 1: " + message);
    }
    public void publicMethod2 (int message){
        System.out.println("Public method 2: " + message);
    }

    @Repeat(2)
    protected void protectedMethod1 (int message){
        System.out.println("Protected method 1: " + message);
    }
    protected void protectedMethod2 (int message){
        System.out.println("Protected method 2: " + message);
    }

    @Repeat(4)
    private void privateMethod1 (int message){
        System.out.println("Private method 1: " + message);
    }
    private void privateMethod2 (int message){
        System.out.println("Private method 2: " + message);
    }
}
