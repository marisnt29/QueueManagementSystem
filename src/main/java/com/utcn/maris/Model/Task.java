package com.utcn.maris.Model;

public class Task implements Comparable{
    private int ID;
    private int arrivalTime;
    private int serviceTime;

    public Task(int ID, int arrivalTime, int serviceTime) {
        this.ID = ID;
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    public void decreaseServiceTime() {
        this.serviceTime -=1;
    }

    @Override
    public int compareTo(Object o) {
        Task t = (Task)o;
        if(this.arrivalTime>t.arrivalTime)
            return 1;
        if(this.arrivalTime<t.arrivalTime)
            return -1;
        return 0;
    }

    @Override
    public String toString() {
        return "Task(" +
                  ID +
                ", "+ arrivalTime +
                ", " + serviceTime +
                ')';
    }
}

