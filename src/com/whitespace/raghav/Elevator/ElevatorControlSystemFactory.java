package com.whitespace.raghav.Elevator;

/**
 * Created by rbhatnagar2 on 2/24/17.
 */
public interface ElevatorControlSystemFactory {
    public void pickup(int floor);

    public void destination(int eId, int floor);

    public void step();
}
