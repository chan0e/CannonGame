package org.nhnacademy.tip;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

public class MovableBall extends Ball implements Movable {
    boolean stop;
    final Vector motion;
    final List<Vector> effectList;

    public MovableBall(Point location, int radius, Color color) {
        super(location, radius, color);

        stop = true;
        motion = new Vector();
        effectList = new LinkedList<>();
    }

    public void start() {
        stop = false;
    }

    public void stop() {
        stop = true;
    }

    public void setMotion(Vector motion) {
        this.motion.set(motion);
    }

    public Vector getMotion() {
        return motion;
    }

    public void addEffect(Vector effect) {
        effectList.add(effect);
    }

    public void next() {
        if (!stop) {
            for (Vector effect : effectList) {
                getMotion().add(effect);
            }

            location.move(motion.getDisplacement());
        }
    }


}
