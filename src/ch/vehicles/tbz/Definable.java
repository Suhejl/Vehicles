package ch.vehicles.tbz;

import java.util.Scanner;

/**
 * Interface that allows entities to create a form, with which they can define their attributes.
 */
public interface Definable {

    /**
     * method that gets passed on and represents a form with which the user can define the attributes of the given class.
     * @param inputValue is a Scanner object, that allows the user to scan userentries from the console.
     */
    public void defineAttributes(Scanner inputValue);

}
