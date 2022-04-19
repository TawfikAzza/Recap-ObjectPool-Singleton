package dk.easv;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SlowObjectPool {

    List<SlowObject> slowObjects = new ArrayList<>();
    Deque<SlowObject> objectReleased = new ArrayDeque<>();

    private static SlowObjectPool instance;
    private SlowObjectPool() {}
    public static SlowObjectPool getInstance() {
        if(instance==null)
            return new SlowObjectPool();
        return instance;
    }

    public void createSlowObject() {
        SlowObject slowObject;
        if(objectReleased.isEmpty()) {
          slowObject = new SlowObject();
        } else {
            slowObject = objectReleased.poll();
        }
        slowObjects.add(slowObject);
    }

    public void releaseSlowObject(SlowObject slowObject) {
        slowObjects.remove(slowObject);
        objectReleased.add(slowObject);
    }
}
