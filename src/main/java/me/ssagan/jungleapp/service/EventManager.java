package me.ssagan.jungleapp.service;

import me.ssagan.jungleapp.model.Leopard;

public class EventManager {

    public void startSimulation(Leopard leopard) {
        while (isAlive(leopard)) {
            int randomNumber = (int) (Math.random() * 100);

            if (randomNumber >= 0 && randomNumber < 40) {
                move(leopard);
            } else if (randomNumber >= 40 && randomNumber < 60) {
                sleep(leopard);
            } else if (randomNumber >= 60 && randomNumber < 80) {
                eatAntelope(leopard);
            } else if (randomNumber >= 80 && randomNumber < 100) {
                attackedByHunter(leopard);
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }
    }

    //пробежал
    private void move(Leopard leopard) {
        leopard.setEnergy(leopard.getEnergy() - 5);
        System.out.print("leo move. ");
        correctHealth(leopard);
    }

    //поспал
    private void sleep(Leopard leopard) {
        leopard.setEnergy(leopard.getEnergy() + 20);
        System.out.print("leo sleep. ");
        correctHealth(leopard);
    }

    //съел Антилопу
    private void eatAntelope(Leopard leopard) {
        leopard.setEnergy(leopard.getEnergy() - 10);
        leopard.setHealth(leopard.getHealth() + (int) (leopard.COEFFICIENT * 4));
        System.out.print("leo ate Antelope. ");
        correctHealth(leopard);
    }

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

    private void attackedByHunter(Leopard leopard) {
        leopard.setHealth(leopard.getHealth() - 20);
        System.out.print("leo is attacked by hunter. ");
        correctHealth(leopard);
    }

    //а жив ли Леопард?
    private boolean isAlive(Leopard leopard) {
        if (leopard.getHealth() <= 0) {
            System.out.println("Leopard goes to heaven...");
            return false;
        } else {
            return true;
        }
    }

    private void correctHealth(Leopard leopard) {
        if (leopard.getEnergy() <= 0) {
            leopard.setHealth(leopard.getHealth() - 5);
        }
        System.out.println("Energy: " + leopard.getEnergy() + ". Health: " + leopard.getHealth());
    }
}
