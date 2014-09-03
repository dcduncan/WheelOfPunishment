package com.ui;

import javax.swing.JFrame;

import com.wheel.components.Wheel;

/**
 * The settings window for the wheel. Allows for adjusting each wheel section label and the amount
 * of sections.
 *
 * @author niklj_000
 */
@SuppressWarnings("serial")
public class SettingsFrame extends JFrame {

    /**
     * The size of the settings window.
     */
    private final int size  = 300;

    /**
     * The shared wheel of the game.
     */
    private Wheel     wheel = null;

    /**
     * Constructs and shows the settings window.
     *
     * @param w Wheel that the settings will configure.
     */
    public SettingsFrame(final Wheel w) {
        setSize(size, size);
        setVisible(true);
        wheel = w;
    }

}
