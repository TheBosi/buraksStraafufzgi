/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.buraksstraafufzgi;

import javax.swing.ImageIcon;

/**
 *
 * @author Iuri
 */
public abstract class Sprite {
    
    protected int x, y;
    protected int i_width, i_height;
    protected ImageIcon imageIcon;
    
    public Sprite(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getI_width() {
        return i_width;
    }

    public void setI_width(int i_width) {
        this.i_width = i_width;
    }

    public int getI_height() {
        return i_height;
    }

    public void setI_height(int i_height) {
        this.i_height = i_height;
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
        setI_height(imageIcon.getIconHeight());
        setI_width(imageIcon.getIconWidth());
    }
    
    
}
