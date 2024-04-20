package interfaces;

public class powerengine implements Engine {
    @Override
    public void start() {
        System.out.println("Power Enginer start");
    }

    @Override
    public void stop() {
        System.out.println("PW stop");
    }

    @Override
    public void acc() {
        System.out.println("PW acc");
    }
}
