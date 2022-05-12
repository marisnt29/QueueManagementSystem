package com.utcn.maris.BussinesLogic;

import com.utcn.maris.Model.Server;
import com.utcn.maris.Model.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Scheduler  {
    private static List<Server> servers = new ArrayList<>();
    private int maxNoServers;
    private int maxTasksPerServer;
    private Strategy strategy;

    public Scheduler(int maxNoServers, int maxTasksPerServer) {
        this.maxNoServers = maxNoServers;
        this.maxTasksPerServer = maxTasksPerServer;
        changeStrategy(Strategy.SelectionPolicy.SHORTEST_TIME);

        for(int i=0 ;i<maxNoServers;i++){
            Server s = new Server();
            servers.add(s);
            Thread t = new Thread(s);
            t.start();
        }

    }

    public void changeStrategy(Strategy.SelectionPolicy policy){
        if(policy == Strategy.SelectionPolicy.SHORTEST_QUEUE){
            strategy = new ConcreteStrategyQueue();
        }
        if(policy == Strategy.SelectionPolicy.SHORTEST_TIME){
            strategy = new ConcreteStrategyTime();
        }
    }

    public void dispatchTask(Task t){
       strategy.addTask(t);
    }

    public static List<Server> getServers() {
        return servers;
    }

    public void setServers(List<Server> servers) {
        this.servers = servers;
    }


    public String afisez() {
         int numar=0;
         String af = "";
        while(numar < maxNoServers){
            for(Server s : servers){
                if(s.getId()==numar)
                    af+=s.toString();

            }
            af+="\n";
            numar++;
        }
        return af;
    }

}
