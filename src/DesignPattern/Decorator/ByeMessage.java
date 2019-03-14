package DesignPattern.Decorator;

public class ByeMessage implements Decorator {

    private Decorator decorator;

    public ByeMessage(Decorator decorator){
        this.decorator = decorator;
    }

    @Override
    public void byeMessage(String name) {
        decorator.byeMessage("Mr Thanh");
        System.out.println("Thank you for choosing our system. Wish you have a nice day!");
    }
}
