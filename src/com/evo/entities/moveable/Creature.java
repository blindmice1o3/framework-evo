package com.evo.entities.moveable;

import com.evo.Handler;
import com.evo.entities.Entity;

import java.awt.image.BufferedImage;

public abstract class Creature extends Entity {

    protected int xMove, yMove;

    public Creature(Handler handler, BufferedImage image, int x, int y, int width, int height) {
        super(handler, image, x, y, width, height);

        xMove = 1;
        yMove = 1;
    }

    public void move() {
        x += xMove;
        y += yMove;
    }

    // GETTERS AND SETTERS

    public int getxMove() {
        return xMove;
    }

    public void setxMove(int xMove) {
        this.xMove = xMove;
    }

    public int getyMove() {
        return yMove;
    }

    public void setyMove(int yMove) {
        this.yMove = yMove;
    }

}