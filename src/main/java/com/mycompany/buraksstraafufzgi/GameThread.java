/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.buraksstraafufzgi;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import sun.io.Win32ErrorMode;

/**
 *
 * @author Iuri
 */
public class GameThread extends JPanel implements Commons {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameThread();
            }
        });

    }

    public GameThread() {
        JFrame frame = new JFrame();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setFocusable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(width, height);

        frame.add(this);

        initialize();
        startGame();

    }

    private void startGame() {
        ScheduledExecutorService executor = Executors
                .newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(new Runnable() {
            public void run() {
                repaint();
            }
        }, 0, 1000 / Commons.FPS, TimeUnit.MILLISECONDS);
    }

    private void initialize() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.fillRect(0, 0, 20, 20);
    }

}
