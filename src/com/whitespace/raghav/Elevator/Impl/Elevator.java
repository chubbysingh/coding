package com.whitespace.raghav.Elevator.Impl;

import com.whitespace.raghav.Elevator.ElevatorDirection;
import com.whitespace.raghav.Elevator.ElevatorFactory;
import com.whitespace.raghav.Elevator.ElevatorStatus;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rbhatnagar2 on 2/24/17.
 */
public class Elevator implements ElevatorFactory {
    private Integer currentFloor;
    private Queue<Integer> destinationFloors;

    public Elevator(Integer currentFloor) {
        this.currentFloor = currentFloor;
        this.destinationFloors = new LinkedList<Integer>();
    }

    public int nextDestination() {
        return destinationFloors.peek();
    }

    public int currentFloor() {
        return this.currentFloor;
    }

    public void popDestination() {
        this.destinationFloors.poll();
    }

    @Override
    public void moveUp() {
        this.currentFloor++;
    }

    @Override
    public void moveDown() {
        this.currentFloor--;
    }

    @Override
    public void addNewDestination(int destination) {
        this.destinationFloors.add(destination);
    }

    @Override
    public ElevatorDirection direction() {
        if (destinationFloors.size() > 0) {
            if (currentFloor < destinationFloors.peek())
                return ElevatorDirection.ELEVATOR_UP;
            else if (currentFloor > destinationFloors.peek())
                return ElevatorDirection.ELEVATOR_DOWN;
        }
        return ElevatorDirection.ELEVATOR_HOLD;
    }

    @Override
    public ElevatorStatus status() {
        return destinationFloors.size() > 0 ? ElevatorStatus.ELEVATOR_OCCUPIED
                : ElevatorStatus.ELEVATOR_EMPTY;
    }
}
