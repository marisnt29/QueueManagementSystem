package com.utcn.maris.BussinesLogic;

import com.utcn.maris.Model.Server;
import com.utcn.maris.Model.Task;

import java.util.List;

public interface Strategy {

    public enum SelectionPolicy{
        SHORTEST_QUEUE,SHORTEST_TIME
    }

    public void addTask(Task t);

}
