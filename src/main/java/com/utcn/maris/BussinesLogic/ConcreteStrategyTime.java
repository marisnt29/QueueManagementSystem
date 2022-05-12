package com.utcn.maris.BussinesLogic;

import com.utcn.maris.Model.Server;
import com.utcn.maris.Model.Task;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConcreteStrategyTime implements Strategy{

    @Override
    public void addTask(Task t) {

        List<Server> serversCopy = new ArrayList<Server>();
        serversCopy = Scheduler.getServers();
        Collections.sort(serversCopy);

        Server potrivit = serversCopy.get(0);

        for(Server s : Scheduler.getServers()){

            if(s.equals(potrivit)){
                Scheduler.getServers().get(Scheduler.getServers().indexOf(s)).addTask(t);
            }

        }

         SimulationManager.plusWaitingPeriod(Scheduler.getServers().get(0).getWaitingPeriod());
         SimulationManager.pluserviceTime(t.getServiceTime());

    }
}
