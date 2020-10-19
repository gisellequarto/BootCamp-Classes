package org.academiadecodigo.com;

public class ToDoList implements Comparable<ToDoList>{

    private Importance important;
    private int priority;
    
    public ToDoList(int priority, Importance important) {
        this.priority = priority;
        this.important = important;
    }


    @Override
    public int compareTo(ToDoList o) {
        if (this.important == o.important) {
            return priority - o.priority;
        }
        return o.important.compareTo(this.important);
    }


    public String toString() {
        return (important.toString() + " importance and priority: " + priority);
    }



}
