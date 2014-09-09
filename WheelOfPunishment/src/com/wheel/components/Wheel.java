package com.wheel.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JComponent;

/**
 * The wheel is the main component of the Wheel of Punishment. It is varying colors, and has a
 * variety of texts, it can spin and notify what it has landed on.
 *
 * @author niklj_000
 */
@SuppressWarnings("serial")
public final class Wheel extends JComponent implements MouseListener, MouseMotionListener {

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
    private int            numberOfSections = 0;

    /**
     * List that holds all of the arcs.
     */
    private ArrayList<Arc> arcList;

    /**
     * Tells if it is the first time drawing the Arc.
     */
    private boolean        initial          = true;

    /**
     * Tells if the wheel is currently spinning.
     */
    private boolean        isSpinning;

    /**
     * Constructs the wheel with the default number of sections.
     */
    public Wheel() {
        final int defaultNumberOfSections = 12;
        numberOfSections = defaultNumberOfSections;
        arcList = new ArrayList<Arc>();
        isSpinning = false;
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

    @Override
    public void mouseClicked(final MouseEvent m) {
        for (Arc arc : arcList) {
            if (arc.contains(
                    m.getX(), m.getY())) {
                System.err.println(arc.getDescription());
                break;
            }
        }
    }

    @Override
    public void mouseDragged(final MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseEntered(final MouseEvent m) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(final MouseEvent m) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseMoved(final MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(final MouseEvent m) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(final MouseEvent m) {
        // TODO Auto-generated method stub
        for (Arc arc : arcList) {
            if (arc.contains(
                    m.getX(), m.getY())) {
                System.err.println(spin());
                break;
            }
        }
    }

    /**
     * Draws the wheel on the graphics.
     *
     * @param graphics Graphics which will draw the wheel.
     */
    @Override
    public void paint(final Graphics graphics) {

        Graphics2D g = (Graphics2D) graphics;

        final int width = 800;
        final int height = 800;

        final int xPos = (int) (g.getClipBounds().getWidth() - width) / 2;
        final int yPos = (int) (g.getClipBounds().getHeight() - height) / 2;

        if (initial) {
            initial = false;

            final int degreesInCircle = 360;
            final int delta = (int) Math.ceil((double) degreesInCircle / numberOfSections);

            int currentSection = 0;
            do {
                Arc arc = new Arc();
                arc.setFrame(
                        xPos, yPos, width, height);
                arc.setAngleStart(currentSection * delta);
                arc.setAngleExtent(delta);
                arc.setColor(currentSection);
                g.setColor(getColor(arc.getColor()));
                arc.setDescription(getColor(
                        currentSection).toString());
                g.draw(arc);
                g.fill(arc);
                arcList.add(arc);
                /*
                 * g.fillArc( xPos, yPos, width, height, currentSection * delta, delta);
                 */
                ++currentSection;
            } while (currentSection < numberOfSections);
        } else {
            for (Arc arc : arcList) {
                g.setColor(getColor(arc.getColor()));
                g.draw(arc);
                g.fill(arc);
            }
        }
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
        if (!isSpinning) {
            isSpinning = true;
            Thread t = new Thread(new Runnable() {

                @Override
                public void run() {
                    int i = 0;
                    final int maxRotation = 1200;
                    final int minRotation = 360;
                    final int smoothRotation = 20;
                    final int rotation = (int) (Math.random() * maxRotation) + minRotation;
                    while (i < rotation) {

                        for (Arc arc : arcList) {
                            arc.setAngleStart(arc.getAngleStart()
                                    + (((rotation - i) / smoothRotation)));
                        }
                        repaint();
                        revalidate();
                        ++i;

                        try {
                            Thread.sleep(smoothRotation);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    isSpinning = false;
                }
            });

            t.start();
        }
        return "Spin";
    }

    /**
     * Subtracts one sections from the wheel.
     */
    public void subtractSection() {
        --numberOfSections;
    }
}
