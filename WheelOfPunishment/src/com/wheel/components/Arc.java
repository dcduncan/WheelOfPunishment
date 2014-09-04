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
     * Initializes the arc properly to be filled.
     */
    public Arc() {
        super(Arc2D.PIE);
    }


    /**
     * @return String, the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param desc the description to set
     */
    public void setDescription(final String desc) {
        description = desc;
    }

}
