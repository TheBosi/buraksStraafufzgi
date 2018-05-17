/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.buraksstraafufzgi;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Iuri
 */
public class KeyboardListener implements KeyListener {
    
    private boolean[] keys = new boolean[256];
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
    
    public boolean isKeyPressed(int keyCode){
        return keys[keyCode];
    }
    
}
