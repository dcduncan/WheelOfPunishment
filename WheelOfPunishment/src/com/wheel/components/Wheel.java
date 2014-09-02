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
     * Returns a color for the wheel.
     *
     * @param currentSection Current section of the wheel it is coloring.
     * @return Color, the color for the section.
     */
    private Color getColor(final int currentSection) {
        switch (currentSection) {
            case 0:
                return Color.RED;
            case 1:
                return Color.ORANGE;
            case 2:
                return Color.YELLOW;
            case 3:
                return Color.GREEN;
            case 4:
                return Color.BLUE;
            case 5:
                return Color.PINK;
            case 6:
                return Color.MAGENTA;
            case 7:
                return Color.CYAN;
            case 8:
                return Color.GRAY;
            case 9:
                return Color.BLACK;
            default:
                return randomColor(currentSection);
        }
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
        final int numberOfSections = 11;
        final int delta = (int) Math.ceil((double) degreesInCircle / numberOfSections);

        final int xPos = (int) (g.getClipBounds().getWidth() - width) / 2;
        final int yPos = (int) (g.getClipBounds().getHeight() - height) / 2;

        int currentSection = 0;
        do {
            g.setColor(getColor(currentSection));
            g.fillArc(
                    xPos, yPos, width, height, currentSection * delta, delta);
            ++currentSection;
        } while (currentSection < numberOfSections);
    }

    /**
     * Returns a random color with the seed.
     *
     * @param seed int that will seed for the random color.
     * @return Color, for coloring the wheel.
     */
    private Color randomColor(final int seed) {
        return Color.WHITE;
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
