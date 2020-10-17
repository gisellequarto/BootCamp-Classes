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
        boolean bigger = (this.important == Importance.HIGH && (o.important == Importance.MEDIUM || o.important == Importance.LOW)) ||
                (this.important == Importance.MEDIUM && o.important == Importance.LOW);

    boolean lower = (o.important == Importance.HIGH && (this.important == Importance.MEDIUM || this.important == Importance.LOW)) ||
                (o.important == Importance.MEDIUM && this.important == Importance.LOW);


        if (this.important == o.important) {
            if (this.priority > o.priority) {
                return 1;
            } else if(this.priority < o.priority) {
                return -1;
            }
            return 0;
        }
        if(bigger) {
            return -1;
        } else if (lower) {
            return 1;
        }

        return 0;
    }

    public String toString() {
        return (important.toString() + " importance and priority: " + priority);
    }



}
