package me.ssagan.jungleapp.model;

public class Leopard {
    private int health = 100;
    private int energy = 100;
    public final double COEFFICIENT = 2.5;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health > 100) health = 100;
        else if (health < 0) health = 0;
        this.health = health;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        if (energy > 100) energy = 100;
        else if (energy < 0) energy = 0;
        this.energy = energy;
    }
}
