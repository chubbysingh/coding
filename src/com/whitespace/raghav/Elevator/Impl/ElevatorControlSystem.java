package com.whitespace.raghav.Elevator.Impl;

import com.whitespace.raghav.Elevator.ElevatorControlSystemFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by rbhatnagar2 on 2/24/17.
 */
public class ElevatorControlSystem implements ElevatorControlSystemFactory {
    public static final int MAX_ELEVATORS = 16;
    Integer numberOfElevators = 0;
    Integer numberOfFloors = 0;

    List<Elevator> elevatorList;
    Queue<Integer> pickupLocations;

    public ElevatorControlSystem(Integer numberOfElevators, Integer numberOfFloors) {
        this.numberOfElevators = numberOfElevators > MAX_ELEVATORS ?
                MAX_ELEVATORS : numberOfElevators;
        this.numberOfFloors = numberOfFloors;

        initializeElevators();
    }

    private void initializeElevators() {
        elevatorList = new ArrayList<Elevator>();
        for (int i = 0; i < numberOfElevators; i++) {
            elevatorList.add(new Elevator(1));
        }
    }

    public List<Elevator> getElevators() {
        return elevatorList;
    }

    @Override
    public void pickup(int pickUpFloor) {
        pickupLocations.add(pickUpFloor);
    }

    @Override
    public void destination(int eId, int floor) {
        elevatorList.get(eId).addNewDestination(floor);
    }

    @Override
    public void step() {
        for (Elevator elevator : elevatorList) {
            switch (elevator.status()) {
                case ELEVATOR_EMPTY:
                    if (!pickupLocations.isEmpty())
                        elevator.addNewDestination(pickupLocations.poll());
                    break;
                case ELEVATOR_OCCUPIED:
                    switch (elevator.direction()) {
                        case ELEVATOR_UP:
                            elevator.moveUp();
                            break;
                        case ELEVATOR_DOWN:
                            elevator.moveDown();
                            break;
                        case ELEVATOR_HOLD:
                            //do nothing
                    }
            }
        }
    }
}
