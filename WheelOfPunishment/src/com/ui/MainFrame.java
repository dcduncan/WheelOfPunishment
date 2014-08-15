package com.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * Is the frame that holds all buttons and panels for the game.
 *
 * @author niklj_000
 */
@SuppressWarnings("serial")
public class MainFrame extends JFrame {

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
     * The content pane in which the wheel will go.
     */
    private final JPanel contentPane;

    /**
     * The x ending bound of the screen.
     */
    private final int    xEndBound   = 750;

    /**
     * The y ending bound of the screen.
     */
    private final int    yEndBound   = 750;

    /**
     * The x starting bound of the screen.
     */
    private final int    xStartBound = 750;

    /**
     * The y starting bound of the screen.
     */
    private final int    yStartBound = 750;

    /**
     * The pixel border size.
     */
    private final int    borderSize  = 5;

    /**
     * The
     */

    /**
     * Create the frame.
     */
    public MainFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(
                this.xStartBound, this.yStartBound, this.xEndBound, this.yEndBound);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(this.borderSize, this.borderSize,
                this.borderSize, this.borderSize));
        this.contentPane.setLayout(new BorderLayout(0, 0));
        this.setContentPane(this.contentPane);

        final JButton btnSpinTheWheel = new JButton("Spin The Wheel!");
        this.contentPane.add(
                btnSpinTheWheel, BorderLayout.SOUTH);

        final JButton btnEditWheelOptions = new JButton("Edit Wheel Options");
        this.contentPane.add(
                btnEditWheelOptions, BorderLayout.NORTH);
    }

}
