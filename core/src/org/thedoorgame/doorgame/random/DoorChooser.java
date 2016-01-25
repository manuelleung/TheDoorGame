package org.thedoorgame.doorgame.random;

import org.thedoorgame.doorgame.Objects.Door;
import org.thedoorgame.doorgame.Objects.Floor;
import org.thedoorgame.doorgame.Objects.FloorCreator;

import java.util.ArrayList;

/**
 * Created by Manuel on 1/25/2016.
 */
public class DoorChooser {

    private ArrayList<FloorCreator> floors;
    private ArrayList<Door> doors;

    public DoorChooser() {
        floors = new ArrayList<FloorCreator>();
    }

    public void addFloor(FloorCreator f) {
        floors.add(f);
    }

    public void addDoors() {
        for(int i=0; i<floors.size(); i++) {
            for(int j=0; j<floors.get(0).getNumberOfDoors(); j++) {
                doors.add(floors.get(i).getDoor(j));
            }
        }
    }




}
