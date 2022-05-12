package com.utcn.maris.BussinesLogic;

import com.utcn.maris.GUI.Controller;
import com.utcn.maris.GUI.SimulationFrame;
import com.utcn.maris.Model.Server;
import com.utcn.maris.Model.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class SimulationManager implements Runnable{
     public int timeLimit =  10 ;
     public int maxProcessingTime = 7;
     public int minProcessingTime = 1;
     public int minArrivalTime = 2;
     public int maxArrivalTime =33;
     public int numberOfServers  = 4;
     public int numberOfClients = 40;
     public Strategy.SelectionPolicy selectionPolicy = Strategy.SelectionPolicy.SHORTEST_TIME;
     public Scheduler scheduler;
     private SimulationFrame frame;
    private List<Task> generatedTasks = new CopyOnWriteArrayList<>();
    private static int totalWaitingPeriod = 0;
    private static int totalProcessingTime = 0;





    public SimulationManager(SimulationFrame gui){
        this.frame = gui;
    }

    //for tests without graphical interface
    public SimulationManager(){
           scheduler = new Scheduler(numberOfServers,numberOfClients);
           generateNRandomTasks();
    }

    public void generateNRandomTasks(){

        for(int i=0;i<numberOfClients;i++){
            int serviceTime = ThreadLocalRandom.current().nextInt(minProcessingTime,maxProcessingTime);
            int arrivalTime = ThreadLocalRandom.current().nextInt(minArrivalTime,maxArrivalTime);
            Task t = new Task(i,arrivalTime,serviceTime);
            this.generatedTasks.add(i,t);
        }

        Collections.sort(generatedTasks);
    }

    @Override
    public void run() {
         int currentTime = 0;
         String afisaj = "";
         int peak = 0;
         int crtWP = 0;
         int maxInitWP =0 ;
         while(currentTime<timeLimit ){

             for(Task t : generatedTasks){

                 if(t.getArrivalTime()==currentTime){
                     this.scheduler.dispatchTask(t);
                      generatedTasks.remove(t);
                 }
             }
              afisaj+="\n -Time"+currentTime;
              afisaj+="\n Waiting Clients :"+generatedTasks.toString() +"\n";

             frame.updateTextArea(afisaj);

             afisaj+=scheduler.afisez();

             frame.updateTextArea(afisaj);

             crtWP = 0;
             for (Server server : Scheduler.getServers()) {
                 crtWP = crtWP + server.getWaitingPeriod();
             }

             if (crtWP > maxInitWP) {
                 maxInitWP = crtWP;
                 peak = currentTime;
             }


             currentTime++;

             try {
                 Thread.sleep(1000);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }

        float averageWP = (float)totalWaitingPeriod/(numberOfServers*numberOfClients);
         float averageST = (float)totalProcessingTime/numberOfClients;

         afisaj+="\n";

        afisaj += "\n" + "average Waiting Period = " + averageWP;
        afisaj+="\n" + "average Service Time = " + averageST;
        afisaj+="\n" + "peak Time = " + peak;
        frame.updateTextArea(afisaj);

    }


    public static void plusWaitingPeriod(int n) {
        totalWaitingPeriod = totalWaitingPeriod + n;
    }

    public static void pluserviceTime(int n) {
        totalProcessingTime = totalProcessingTime + n;
    }

    public void setNumberOfServers(int numberOfServers) {
        this.numberOfServers = numberOfServers;
    }

    public void setNumberOfTask(int numberOfTask) {
        this.numberOfClients = numberOfTask;
    }

    public void setMinServiceTime(int minServiceTime) {
        this.minProcessingTime = minServiceTime;
    }

    public void setMaxServiceTime(int maxServiceTime) {
        this.maxProcessingTime = maxServiceTime;
    }

    public void setMinArrivalTime(int minArrivalTime) {
        this.minArrivalTime = minArrivalTime;
    }

    public void setMaxArrivalTime(int maxArrivalTime) {
        this.maxArrivalTime = maxArrivalTime;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    @Override
    public String toString() {
        return "SimulationManager{" +
                "numberOfServers=" + numberOfServers +
                ", numberOfTask=" + numberOfClients +
                ", minServiceTime=" + minProcessingTime +
                ", maxServiceTime=" + maxProcessingTime +
                ", minArrivalTime=" + minArrivalTime +
                ", maxArrivalTime=" + maxArrivalTime +
                ", timeLimit=" + timeLimit +
                '}';
    }

    public static void main(String[] args) {
        SimulationFrame gui = new SimulationFrame();
        SimulationManager gen = new SimulationManager(gui);
        Thread t = new Thread(gen);
        Controller controller = new Controller(gui,gen,t);



    }
}
