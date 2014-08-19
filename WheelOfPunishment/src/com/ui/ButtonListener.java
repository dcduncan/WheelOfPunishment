package com.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listens to the buttons from the GUI.
 *
 * @author niklj_000
 */
public class ButtonListener implements ActionListener {

    /**
     * The Frame with the wheel and buttons and methods.
     */
    private MainFrame mainFrame = null;

    /**
     * The constructor take a MainFrame for where the wheel is called.
     *
     * @param frame MainFrame
     */
    public ButtonListener(final MainFrame frame) {
        mainFrame = frame;
    }

    @Override
    public final void actionPerformed(final ActionEvent arg0) {
        // TODO Auto-generated method stub

        if (arg0.getActionCommand().matches(
                ".*Spin.*")) {
            mainFrame.spinWheel();
        } else if (arg0.getActionCommand().matches(
                ".*Edit.*")) {
            mainFrame.editWheelOptions();
        }

    }
}
