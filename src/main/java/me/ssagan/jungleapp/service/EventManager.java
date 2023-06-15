package me.ssagan.jungleapp.service;

import me.ssagan.jungleapp.model.Leopard;

public class EventManager {

    public void startSimulation(Leopard leopard){
        while(isAlive(leopard)){
            int randomNumber = (int) (Math.random() * 100);
            if(randomNumber >= 0 && randomNumber < 100){
                move(leopard);
            }
            try{
                Thread.sleep(500);
            } catch (InterruptedException e){
                throw new RuntimeException();
            }
        }
        System.out.println("Leopard goes to heaven...");
    }

    //пробежал
    private void move(Leopard leopard){
        System.out.println("leo move");
        leopard.setEnergy(leopard.getEnergy() - 5);
        correctHealth(leopard);
    }

    //поспал
    //съел
    //антилопами, - antelope
    //оленями, - deer
    //зебр - zebra
    //лошадей - horse
    //кабана - boar
    //обезьянами,  - monkey
    //волков, - wolf
    //лисиц - fox
    //овец - sheep
    //зайцев - hare
    //птицами, bird

    //а жив ли Леопард?
    private boolean isAlive(Leopard leopard){
        if(leopard.getHealth() <= 0){
            return false;
        }
        else{
            return true;
        }
    }

    private void correctHealth(Leopard leopard){
        if (leopard.getEnergy() <= 0){
            leopard.setHealth(leopard.getHealth() - 5);
            System.out.println("Health: " + leopard.getHealth());
        }
    }
}
