package com.wheel.components;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

/**
 * The wheel is the main component of the Wheel of Punishment. It is varying colors, and has a
 * variety of texts, it can spin and notify what it has landed on.
 *
 * @author niklj_000
 */
public final class Wheel extends JComponent {

    /**
     * Allows user to edit the options of the wheel.
     */
    public void edit() {
        System.err.println("Edit");
    }

    /**
     * Draws the wheel on the graphics.
     *
     * @param g Graphics which will draw the wheel.
     */
    @Override
    public void paint(final Graphics g) {
        g.setColor(Color.RED);
        g.fillArc(
                100, 100, 100, 100, 0, 51);
        g.setColor(Color.ORANGE);
        g.fillArc(
                100, 100, 100, 100, 51, 52);
        g.setColor(Color.YELLOW);
        g.fillArc(
                100, 100, 100, 100, 103, 51);
        g.setColor(Color.GREEN);
        g.fillArc(
                100, 100, 100, 100, 154, 52);
        g.setColor(Color.BLUE);
        g.fillArc(
                100, 100, 100, 100, 206, 51);
        g.setColor(Color.PINK);
        g.fillArc(
                100, 100, 100, 100, 257, 52);
        g.setColor(Color.GRAY);
        g.fillArc(
                100, 100, 100, 100, 308, 52);


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
