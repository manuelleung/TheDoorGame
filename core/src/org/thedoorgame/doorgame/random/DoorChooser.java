package org.thedoorgame.doorgame.random;

import org.thedoorgame.doorgame.Objects.*;
import org.thedoorgame.doorgame.Objects.Character;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

/**
 * Created by Manuel on 1/25/2016.
 */
public class DoorChooser {

    private ArrayList<FloorCreator> floors;
    private ArrayList<Door> doors;
    private ArrayList<Character> characters;

    private Character chosenCharacter;

    private Random rand;

    private int randomIndex;

    boolean charactersAvailable = true;


    /* Constructor */
    public DoorChooser() {
        floors = new ArrayList<FloorCreator>();
        doors = new ArrayList<Door>();
        characters = new ArrayList<Character>();
        rand = new Random();
    }

    /* Register floors */
    public void addFloor(FloorCreator f) {
        floors.add(f);
    }

    /* Register doors */
    public void addDoors() {
        for(int i=0; i<floors.size(); i++) {
            for(int j=0; j<floors.get(0).getNumberOfDoors(); j++) {
                doors.add(floors.get(i).getDoor(j));
            }
        }
    }

    /* Register characters */
    public void addCharacters(Character c) {
        characters.add(c);
    }

    /* Shuffle the lists for more randomization */
    public void shuffleLists() {
        Collections.shuffle(doors);
        Collections.shuffle(characters);
    }

    /* Chosen character to question */
    public Character chooseCharacter() {
        randomIndex = rand.nextInt(characters.size());
        chosenCharacter = characters.get(randomIndex);
        return chosenCharacter;
    }

    /* Random chooser for characters to doors */
    public void randomDoorChooser() {
        Character theChar;
        Door theDoor;
        while (charactersAvailable) {
            theChar = characters.remove(0);

            randomIndex = rand.nextInt(doors.size());

            theDoor = doors.remove(randomIndex);

            // TODO assign theChar -> theDoor / theFloor
            // theChar.chosenDoor(theDoor);

            if(characters.isEmpty()) {
                charactersAvailable = false;
            }
        }

    }

}
