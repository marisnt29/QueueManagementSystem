package com.utcn.maris.GUI;

import com.utcn.maris.BussinesLogic.Scheduler;
import com.utcn.maris.BussinesLogic.SimulationManager;

public class Controller {

    public Controller(SimulationFrame gui ,SimulationManager simulationManager,Thread t) {

        gui.addSimulationButtonListener(e -> {

            simulationManager.setMinArrivalTime(Integer.parseInt(gui.getminAT()));
            simulationManager.setMaxArrivalTime(Integer.parseInt(gui.getmaxAT()));
            simulationManager.setMinServiceTime(Integer.parseInt(gui.getminST()));
            simulationManager.setMaxServiceTime(Integer.parseInt(gui.getmaxST()));
            simulationManager.setNumberOfServers(Integer.parseInt(gui.getNoOfServers()));
            simulationManager.setNumberOfTask(Integer.parseInt(gui.getNoOfTasks()));
            simulationManager.setTimeLimit(Integer.parseInt(gui.getTimeLimit()));

            simulationManager.scheduler = new Scheduler(simulationManager.numberOfServers,simulationManager.numberOfClients);
            simulationManager.generateNRandomTasks();
            System.out.println(simulationManager.toString());
            t.start();

        });


    }

}