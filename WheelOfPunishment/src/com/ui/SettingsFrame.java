package com.ui;

import javax.swing.JFrame;

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
    private final int size = 300;

    /**
     * Constructs and shows the settings window.
     */
    public SettingsFrame() {
        setSize(size, size);
        setVisible(true);
    }

}
