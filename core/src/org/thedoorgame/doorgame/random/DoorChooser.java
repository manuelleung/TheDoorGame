package org.thedoorgame.doorgame.random;

import org.thedoorgame.doorgame.Objects.*;
import org.thedoorgame.doorgame.Objects.Character;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
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
    public void addCharacters(ArrayList<Character> characters) {
        //characters.add(character);
        this.characters= new ArrayList<Character>(characters);
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

    Door theDoor;
    /* Random chooser for characters to doors */
    public void randomDoorChooser() {
        Character theChar;
        //Door theDoor;
        while (charactersAvailable) {
            theChar = characters.remove(0);

            randomIndex = rand.nextInt(doors.size());

            theDoor = doors.remove(randomIndex);

            // TODO
            //theChar.setDoorNumber(theDoor.getDoorNumber());
            //theChar.setFloorNumber(theDoor.getFloorNumber());

            theChar.setFloorDestination(floors.get(theDoor.getFloorNumber()).getFloor());
            theChar.setDoorDestination(floors.get(theDoor.getFloorNumber()).getDoor(theDoor.getDoorNumber()));

            System.out.println(theDoor.getDoorNumber() + " " + theDoor.getFloorNumber());

            if(characters.isEmpty()) {
                charactersAvailable = false;
            }
        }

    }

    public void print() {
        System.out.println("Door#: " + theDoor.getDoorNumber());
        System.out.println("Floor#: " + theDoor.getFloorNumber());
    }

    public Character getChosenCharacter() {
        return chosenCharacter;
    }

    public ArrayList<Character> getCharacters() {
        return characters;
    }

    /**
     * goToDestination
     */
    public void goToDestination(Character character) {

        //for (int i=0; i<characters.size(); i++) {

            //Character character = characters.get(i);

            // Get Floor and Door numbers
            int floorNumber = character.getFloorNumber();
            int doorNumber = character.getDoorNumber();

            // Get the floor and door actors
            Floor floor = floors.get(floorNumber).getFloor();

            Door door = floors.get(floorNumber).getDoor(doorNumber);


            // Check if the character is on the correct floor;
            if (character.getLocationY() == (floor.getLocationY() + floor.getHeight())) {

                // comparare distance between door and character
                if (character.getLocationX() > door.getLocationX() + 10) {
                    character.moveLeft();
                } else if (character.getLocationX() < door.getLocationX() - 10) {
                    character.moveRight();
                } else {
                    //System.out.println("HEREeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
                    character.stop(); // stop the character from moving.
                    door.play();      // Open the door
                    character.setVisible(false); // make the character disappear inside the door
                }

            }

        //}
    }

}
