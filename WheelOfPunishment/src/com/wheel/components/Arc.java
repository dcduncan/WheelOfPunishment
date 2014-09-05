package com.wheel.components;

import java.awt.geom.Arc2D;


/**
 * The Arcs that are in the Wheel.
 *
 * @author niklj_000
 */
@SuppressWarnings("serial")
public final class Arc extends Arc2D.Double {

    /**
     * The Description that is on the Arc.
     */
    private String description;

    /**
     * The integer that determines the color for the Arc.
     */
    private int    color;


    /**
     * Initializes the arc properly to be filled.
     */
    public Arc() {
        super(Arc2D.PIE);
    }


    /**
     * @return the color
     */
    public int getColor() {
        return color;
    }


    /**
     * @return String, the description
     */
    public String getDescription() {
        return description;
    }


    /**
     * Sets the color of the Arc.
     *
     * @param color the color to set
     */
    public void setColor(final int color) {
        this.color = color;
    }

    /**
     * @param desc the description to set
     */
    public void setDescription(final String desc) {
        description = desc;
    }

}
