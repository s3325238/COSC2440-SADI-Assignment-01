package DesignPattern.Singleton;

public class Singleton {
    private static Singleton instance = new Singleton();
    private Singleton(){

    }

    public static Singleton getInstance(){
        return instance;
    }

    //other methods etc
    public void hello(){
        System.out.println("\nWelcome to Enrollment System! -- This message using singleton\n");
    }
}
