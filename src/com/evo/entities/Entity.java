package com.evo.entities;

import com.evo.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {

    protected Handler handler;

    protected int x, y, width, height;
    protected BufferedImage image;
    protected Rectangle bounds;

    public Entity(Handler handler, BufferedImage image, int x, int y, int width, int height) {
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;
        bounds = new Rectangle(0, 0, width, height);
    } // **** end Entity(Handler, BufferedImage, int, int, int, int) constructor ****

    public abstract void tick();
    public abstract void render(Graphics g);

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getX() { return x; }

    public int getY() { return y; }

    public int getWidth() { return width; }

    public int getHeight() { return height; }

    public Rectangle getBounds() { return bounds; }

} // **** end Entity abstract class ****