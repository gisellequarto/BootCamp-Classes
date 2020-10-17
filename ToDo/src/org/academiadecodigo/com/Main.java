package org.academiadecodigo.com;

import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {

        PriorityQueue<ToDoList> toDoQueue = new PriorityQueue<>();

        toDoQueue.add(new ToDoList(1, Importance.LOW));
        toDoQueue.add(new ToDoList(2, Importance.MEDIUM));
        toDoQueue.add(new ToDoList(1, Importance.MEDIUM));
        toDoQueue.add(new ToDoList(3, Importance.HIGH));
        toDoQueue.add(new ToDoList(1, Importance.LOW));
        toDoQueue.add(new ToDoList(1, Importance.HIGH));
        toDoQueue.add(new ToDoList(2, Importance.LOW));
        toDoQueue.add(new ToDoList(2, Importance.MEDIUM));


        while (!toDoQueue.isEmpty()) {
            System.out.println(toDoQueue.remove());
        }



    }

}
