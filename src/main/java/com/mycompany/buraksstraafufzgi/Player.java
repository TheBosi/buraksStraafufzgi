/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.buraksstraafufzgi;

import sun.net.www.content.text.plain;

/**
 *
 * @author Iuri
 */
public class Player extends Sprite {

    public Player(int x, int y) {
        super(x, y);

    }

    @Override
    public void setY(int y) {
        if (y > Commons.height){
            y = Commons.height + getI_height();
        }
        
        if (y < 0){
            y = 0;
        }
        
        super.setY(y);

    }

    @Override
    public void setX(int x) {
        
        if(x > Commons.width){
            x = Commons.height + getI_width();
        }
        
        if(x < 0){
           x = 0;
        }
        
        super.setX(x);
    }

}
