package com.main;

import java.awt.EventQueue;

import com.ui.MainFrame;

/**
 * The main class that runs the program.
 *
 * @author niklj_000
 */
public final class WheelOfPunishment {

    /**
     * Launch the application.
     *
     * @param args String []
     */
    public static void main(final String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    final MainFrame frame = new MainFrame();
                    frame.setVisible(true);

                } catch (final Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Private constructor for utility class.
     */
    private WheelOfPunishment() {
    }
}
