package dk.easv;

public class SlowObject {

    public SlowObject() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
