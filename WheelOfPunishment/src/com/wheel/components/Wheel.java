package com.wheel.components;

/**
 * The wheel is the main component of the Wheel of Punishment. It is varying colors, and has a
 * variety of texts, it can spin and notify what it has landed on.
 *
 * @author niklj_000
 */
public final class Wheel {

    /**
     * Allows user to edit the options of the wheel.
     */
    public void edit() {
        System.err.println("Edit");
    }

    /**
     * Spins the Wheel.
     *
     * @return string The section that it landed on.
     */
    public String spin() {
        return "Spin";
    }

}
