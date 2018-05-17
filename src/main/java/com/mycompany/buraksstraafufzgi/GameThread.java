/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.buraksstraafufzgi;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
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

    
    private KeyboardListener listener = new KeyboardListener();
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
        frame.addKeyListener(listener);
        initialize();
        startGame();

    }

    private void startGame() {
        ScheduledExecutorService executor = Executors
                .newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(new Runnable() {
            public void run() {
                listenKeys();
                repaint();
            }
        }, 0, 1000 / Commons.FPS, TimeUnit.MILLISECONDS);
    }
    
    private void listenKeys(){
        
        if(listener.isKeyPressed(KeyEvent.VK_SPACE)){
            System.out.println("Space");
        }
        
        if(listener.isKeyPressed(KeyEvent.VK_W)){
            System.out.println("W");
        }
    }
    
    private void initialize() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        //g2d.fillRect(630, 350, 20, 20);
        g2d.fillOval(630, 350, 100, 100);
        g2d.fillOval(540, 350, 100, 100);
        g2d.fillRoundRect(585, 100, 100, 300, 150, 150);
    }

}
