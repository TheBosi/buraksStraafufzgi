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
import javax.swing.ImageIcon;
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
    private Player player;

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
        
        JFrame tmp = new JFrame();
        tmp.pack();
        
        
        
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

    private void listenKeys() {

        if (listener.isKeyPressed(KeyEvent.VK_W)) {
            player.setY(player.getY() - 10);
        }

        if (listener.isKeyPressed(KeyEvent.VK_A)) {
           player.setX(player.getX() - 10 );
        }
        
        if(listener.isKeyPressed(KeyEvent.VK_S)){
            player.setY(player.getY() + 10);
        }
        
        if(listener.isKeyPressed(KeyEvent.VK_D)){
            player.setX(player.getX() + 10);
        }
        
        
    }

    private void initialize() {
        player = new Player(0, 0);
        player.setImageIcon(new ImageIcon(this.getClass().getResource("/giratina.png")));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(player.getImageIcon().getImage(), player.getX(), player.getY(), null);
    }

}
