package org.academiadecodigo.bootcamp.concurrency;

import org.academiadecodigo.bootcamp.concurrency.bqueue.BQueue;

import java.util.Iterator;

/**
 * Produces and stores integers into a blocking queue
 */
public class Producer implements Runnable {

    private final BQueue<Integer> queue;
    private int elementNum;
    private Integer product;

    /**
     * @param queue      the blocking queue to add elements to
     * @param elementNum the number of elements to produce
     */
    public Producer(BQueue queue, int elementNum) {
        this.queue = queue;
        this.elementNum = elementNum;
        product = 1;
    }

    @Override
    public void run() {
        while (product <= elementNum) {
            queue.offer(product);
            if (queue.getSize() == queue.getLimit()) {
                System.out.println(">> QUEUE IS FULL<<");
            }
            product++;
        }
    }

}
