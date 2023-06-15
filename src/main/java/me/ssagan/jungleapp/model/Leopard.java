package me.ssagan.jungleapp.model;

public class Leopard {
    private int health = 100;
    private int energy = 100;
    private final double COEFFICIENT = 2.5;

    public int getHealth(){
        return health;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public int getEnergy(){
        return energy;
    }

    public void setEnergy(int energy){
        this.energy = energy;
    }
}
