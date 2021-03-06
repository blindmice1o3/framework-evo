package com.evo.entities.moveable.player;

public interface IPlayable {
    void getInput();

    int getHealthMax();
    void setHealthMax(int healthMax);
    int getHealth();
    void setHealth(int health);
    int getExperiencePoints();
}