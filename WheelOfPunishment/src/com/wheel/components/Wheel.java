package com.wheel.components;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JComponent;

/**
 * The wheel is the main component of the Wheel of Punishment. It is varying colors, and has a
 * variety of texts, it can spin and notify what it has landed on.
 *
 * @author niklj_000
 */
@SuppressWarnings("serial")
public final class Wheel extends JComponent {

    /**
     * Predefined choices for the wheel section colors.
     *
     * @author niklj_000
     */
    private enum WheelColor {
        /**
         * The predefined color choices.
         */
        RED, ORANGE, YELLOW, GREEN, BLUE, PINK, MAGENTA, CYAN, GRAY, BLACK, WHITE, NULL
    }

    /**
     * The number of sections that are in the wheel.
     */
    private int numberOfSections = 0;

    /**
     * Constructs the wheel with the default number of sections.
     */
    public Wheel() {
        final int defaultNumberOfSections = 12;
        numberOfSections = defaultNumberOfSections;
    }

    /**
     * Adds an additional section to the wheel.
     */
    public void addSection() {
        ++numberOfSections;
    }

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
        WheelColor color = getWheelColor(currentSection);
        switch (color) {
            case RED:
                return Color.RED;
            case ORANGE:
                return Color.ORANGE;
            case YELLOW:
                return Color.YELLOW;
            case GREEN:
                return Color.GREEN;
            case BLUE:
                return Color.BLUE;
            case PINK:
                return Color.PINK;
            case MAGENTA:
                return Color.MAGENTA;
            case CYAN:
                return Color.CYAN;
            case GRAY:
                return Color.GRAY;
            case BLACK:
                return Color.BLACK;
            case WHITE:
                return Color.WHITE;
            default:
                return randomColor(currentSection);
        }
    }

    /**
     * Retrieves the current amount of sections from the wheel.
     *
     * @return int, the number of sections in the wheel.
     */
    public int getNumberOfSections() {
        return numberOfSections;
    }

    /**
     * Gets the enum of the wheel color.
     *
     * @param currentSection int to determine which enum to use.
     * @return WheelColor, the color to use.
     */
    private WheelColor getWheelColor(final int currentSection) {
        WheelColor[] colors = WheelColor.values();
        if ((currentSection >= 0) && (currentSection < (colors.length - 1))) {
            return colors[currentSection];
        } else {
            return colors[colors.length - 1];
        }
    }

    /**
     * Draws the wheel on the graphics.
     *
     * @param g Graphics which will draw the wheel.
     */
    @Override
    public void paint(final Graphics g) {

        final int width = 800;
        final int height = 800;
        final int degreesInCircle = 360;

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
        final int colorMax = 255;
        Random random = new Random(seed);
        return new Color(random.nextInt(colorMax), random.nextInt(colorMax),
                random.nextInt(colorMax));
    }

    /**
     * Sets the number of sections for the wheel.
     *
     * @param numSections int of how many sections to set.
     */
    public void setNumberOfSections(final int numSections) {
        numberOfSections = numSections;
    }

    /**
     * Spins the Wheel.
     *
     * @return string The section that it landed on.
     */
    public String spin() {
        return "Spin";
    }

    /**
     * Subtracts one sections from the wheel.
     */
    public void subtractSection() {
        --numberOfSections;
    }
}
