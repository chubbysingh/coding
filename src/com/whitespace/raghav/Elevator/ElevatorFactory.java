package com.whitespace.raghav.Elevator;

/**
 * Created by rbhatnagar2 on 2/24/17.
 */
public interface ElevatorFactory {
    public void moveUp();

    public void moveDown();

    public void addNewDestination(int destination);

    public ElevatorDirection direction();

    public ElevatorStatus status();
}
