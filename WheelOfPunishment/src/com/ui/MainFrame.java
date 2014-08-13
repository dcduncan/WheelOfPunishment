package com.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {

    /**
     * Launch the application.
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

    private final JPanel contentPane;

    /**
     * Create the frame.
     */
    public MainFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 755, 756);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.contentPane.setLayout(new BorderLayout(0, 0));
        this.setContentPane(this.contentPane);

        final JButton btnSpinTheWheel = new JButton("Spin The Wheel!");
        this.contentPane.add(btnSpinTheWheel, BorderLayout.SOUTH);

        final JButton btnEditWheelOptions = new JButton("Edit Wheel Options");
        this.contentPane.add(btnEditWheelOptions, BorderLayout.NORTH);
    }

}
