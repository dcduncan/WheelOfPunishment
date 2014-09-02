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

        final int width = 100;
        final int height = 100;

        final int degreesInCircle = 360;
        final int numberOfSections = 7;
        final int delta = (int) Math.ceil((double) degreesInCircle / numberOfSections);

        final int xPos = (int) (g.getClipBounds().getWidth() - width) / 2;
        final int yPos = (int) (g.getClipBounds().getHeight() - height) / 2;

        int currentSection = 0;

        g.setColor(Color.RED);
        g.fillArc(
                xPos, yPos, width, height, currentSection * delta, delta);
        ++currentSection;
        g.setColor(Color.ORANGE);
        g.fillArc(
                xPos, yPos, width, height, currentSection * delta, delta);
        ++currentSection;
        g.setColor(Color.YELLOW);
        g.fillArc(
                xPos, yPos, width, height, currentSection * delta, delta);
        ++currentSection;
        g.setColor(Color.GREEN);
        g.fillArc(
                xPos, yPos, width, height, currentSection * delta, delta);
        ++currentSection;
        g.setColor(Color.BLUE);
        g.fillArc(
                xPos, yPos, width, height, currentSection * delta, delta);
        ++currentSection;
        g.setColor(Color.PINK);
        g.fillArc(
                xPos, yPos, width, height, currentSection * delta, delta);
        ++currentSection;
        g.setColor(Color.GRAY);
        g.fillArc(
                xPos, yPos, width, height, currentSection * delta, delta);


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
