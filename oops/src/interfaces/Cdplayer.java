package interfaces;

public class Cdplayer implements Media{

    @Override
    public void start() {
        System.out.println("Start");
    }

    @Override
    public void stop() {
        System.out.println("Stop");
    }
}
