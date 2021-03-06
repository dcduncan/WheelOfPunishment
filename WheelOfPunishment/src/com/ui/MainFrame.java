package com.ui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.listeners.ButtonListener;
import com.wheel.components.Wheel;

/**
 * Is the frame that holds all buttons and panels for the game.
 *
 * @author niklj_000
 */
@SuppressWarnings("serial")
public final class MainFrame extends JFrame {

    /**
     * The content pane in which the wheel will go.
     */
    private final JPanel contentPane;

    /**
     * The width of the screen.
     */
    private final int    width      = 1500;

    /**
     * The height of the screen.
     */
    private final int    height     = 1000;

    /**
     * The pixel border size.
     */
    private final int    borderSize = 5;

    /**
     * The wheel for the game.
     */
    private Wheel        wheel      = null;


    /**
     * Create the frame.
     */
    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(
                0, 0, width, height);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(borderSize, borderSize, borderSize, borderSize));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        wheel = new Wheel();
        contentPane.add(wheel);
        contentPane.addMouseListener(wheel);

        initializeButtons();


    }

    /**
     * Opens dialog to edit the wheels options.
     */
    public void editWheelOptions() {
        new SettingsFrame(wheel);
    }

    /**
     * Initializes the buttons and the button listener.
     */
    private void initializeButtons() {
        final ButtonListener buttonListener = new ButtonListener(this);

        final JButton btnSpinTheWheel = new JButton("Spin The Wheel!");
        contentPane.add(
                btnSpinTheWheel, BorderLayout.SOUTH);
        btnSpinTheWheel.addActionListener(buttonListener);

        final JButton btnEditWheelOptions = new JButton("Edit Wheel Options");
        contentPane.add(
                btnEditWheelOptions, BorderLayout.NORTH);
        btnEditWheelOptions.addActionListener(buttonListener);

    }

    /**
     * Spins the wheel.
     */
    public void spinWheel() {
        System.err.println(wheel.spin());
    }

}
