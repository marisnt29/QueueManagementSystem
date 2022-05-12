package com.utcn.maris.Model;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable,Comparable{
    private BlockingQueue<Task> tasks;
    AtomicInteger waitingPeriod;
    private int id ;
    private static int count;

    @Override
    public String toString() {

        return "Queue " + id+ "{"+
                "Tasks=" + tasks.toString() +" Waiting period :" + waitingPeriod;
    }

    public Server() {
      this.id = count;
      this.tasks = new LinkedBlockingQueue<Task>();
      this.waitingPeriod = new AtomicInteger(0);
      count++;
    }

    public void addTask(Task newTask){
        this.tasks.add(newTask);
        waitingPeriod.addAndGet(newTask.getServiceTime());

    }

    public Server(BlockingQueue<Task> tasks, AtomicInteger waitingPeriod) {
        this.tasks = tasks;
        this.waitingPeriod = waitingPeriod;
    }


    public BlockingQueue<Task> getTasks() {
        return tasks;
    }

    public void setTasks(BlockingQueue<Task> tasks) {
        this.tasks = tasks;
    }

    public int getWaitingPeriod() {
        return waitingPeriod.intValue();
    }

    public void setWaitingPeriod(AtomicInteger waitingPeriod) {
        this.waitingPeriod = waitingPeriod;
    }

    public void decreaseWaitingPeriod(){
        waitingPeriod.decrementAndGet();
    }

    @Override
    public void run() {

        while(true){



            if(!tasks.isEmpty()){
                Task t = tasks.peek();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                t.decreaseServiceTime();

                decreaseWaitingPeriod();

                if(t.getServiceTime()==0){
                    tasks.remove(t);
                }



            }


        }

    }


    @Override
    public int compareTo(Object o) {
        Server s = (Server)o;
        int p1 = this.waitingPeriod.intValue();
        int p2 = s.waitingPeriod.intValue();
        if(p1>p2)
            return 1;
        if(p1<p2)
            return -1;

        return 0;
    }

    public int getId() {
        return id;
    }
}
