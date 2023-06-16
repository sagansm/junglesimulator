package me.ssagan.jungleapp.service;

import me.ssagan.jungleapp.model.Leopard;

public class EventManager {

    public void startSimulation(Leopard leopard) {
        while (isAlive(leopard)) {
            int randomNumber = (int) (Math.random() * 100);

            if (randomNumber >= 0 && randomNumber < 10) {
                move(leopard);
            } else if (randomNumber >= 10 && randomNumber < 20) {
                sleep(leopard);
            } else if (randomNumber >= 20 && randomNumber < 30) {
                eatAntelope(leopard);
            } else if (randomNumber >= 30 && randomNumber < 40) {
                eatZebra(leopard);
            } else if (randomNumber >= 40 && randomNumber < 50) {
                eatMonkey(leopard);
            } else if (randomNumber >= 50 && randomNumber < 60) {
                eatWolf(leopard);
            } else if (randomNumber >= 60 && randomNumber < 70) {
                eatSheep(leopard);
            } else if (randomNumber >= 70 && randomNumber < 80) {
                eatHare(leopard);
            } else if (randomNumber >= 80 && randomNumber < 90) {
                eatBird(leopard);
            } else if (randomNumber >= 90 && randomNumber < 100) {
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
        System.out.print("leo moved. ");
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
        leopard.setEnergy(leopard.getEnergy() - 20);
        leopard.setHealth(leopard.getHealth() + (int) (leopard.COEFFICIENT * 7));
        System.out.print("leo ate Antelope. ");
        correctHealth(leopard);
    }

    //съел зебру - zebra
    private void eatZebra(Leopard leopard) {
        leopard.setEnergy(leopard.getEnergy() - 18);
        leopard.setHealth(leopard.getHealth() + (int) (leopard.COEFFICIENT * 6));
        System.out.print("leo ate Zebra. ");
        correctHealth(leopard);
    }

    //съел обезьяну - monkey
    private void eatMonkey(Leopard leopard) {
        leopard.setEnergy(leopard.getEnergy() - 15);
        leopard.setHealth(leopard.getHealth() + (int) (leopard.COEFFICIENT * 5));
        System.out.print("leo ate Monkey. ");
        correctHealth(leopard);
    }

    //съел волка - wolf
    private void eatWolf(Leopard leopard) {
        leopard.setEnergy(leopard.getEnergy() - 13);
        leopard.setHealth(leopard.getHealth() + (int) (leopard.COEFFICIENT * 4));
        System.out.print("leo ate Wolf. ");
        correctHealth(leopard);
    }

    //съел овцу- sheep
    private void eatSheep(Leopard leopard) {
        leopard.setEnergy(leopard.getEnergy() - 10);
        leopard.setHealth(leopard.getHealth() + (int) (leopard.COEFFICIENT * 3));
        System.out.print("leo ate Sheep. ");
        correctHealth(leopard);
    }

    //съел зайца - hare
    private void eatHare(Leopard leopard) {
        leopard.setEnergy(leopard.getEnergy() - 8);
        leopard.setHealth(leopard.getHealth() + (int) (leopard.COEFFICIENT * 2));
        System.out.print("leo ate Hare. ");
        correctHealth(leopard);
    }

    //съел птицу, bird
    private void eatBird(Leopard leopard) {
        leopard.setEnergy(leopard.getEnergy() - 6);
        leopard.setHealth(leopard.getHealth() + (int) (leopard.COEFFICIENT * 1));
        System.out.print("leo ate Bird. ");
        correctHealth(leopard);
    }

    private void attackedByHunter(Leopard leopard) {
        leopard.setHealth(leopard.getHealth() - 20);
        System.out.print("leo was attacked by hunter. ");
        correctHealth(leopard);
    }

    //а жив ли Леопард?
    private boolean isAlive(Leopard leopard) {
        if (leopard.getHealth() <= 0) {
            System.out.println("leo has gone to heaven...");
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
