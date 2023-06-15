package me.ssagan.jungleapp._main;

import me.ssagan.jungleapp.model.Leopard;
import me.ssagan.jungleapp.service.EventManager;

public class _Main {
    public static void main(String[] args) {
        Leopard leopard = new Leopard();
        EventManager eventManager = new EventManager();
        eventManager.startSimulation(leopard);

    }
}
