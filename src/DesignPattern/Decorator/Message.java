package DesignPattern.Decorator;

public class Message implements Decorator {

    @Override
    public void byeMessage(String name) {
        System.out.println("Goodbye " + name);
    }
}
