package interfaces;

public class Car implements Break , Engine {

    @Override
    public void brake() {
        System.out.println("I break ");
    }

    @Override
    public void start() {
        System.out.println("she start");
    }

    @Override
    public void stop() {
        System.out.println("he stop");
    }

    @Override
    public void acc() {
        System.out.println("Things accelerate");
    }

    public static void main(String[] args) {
        Car c = new Car();
        c.brake();
        c.start();
        c.stop();
        c.acc();
    }
}
