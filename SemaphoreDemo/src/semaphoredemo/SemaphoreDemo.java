/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaphoredemo;

import java.util.Stack;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Admin
 */
public class SemaphoreDemo {

    private static final int BUFFER_SIZE = 4;
    public static final Semaphore writePermits = new Semaphore(BUFFER_SIZE);
    public static final Semaphore readPermits = new Semaphore(0);
    public static final Stack<Integer> buffer = new Stack<>();
 
    public static void main(String[] args) throws InterruptedException {
        Producer producer = new Producer("Producer 1");
        new Thread(producer).start();
         
        for (int i = 1; i <= 3; i++) {
            Consumer consumer = new Consumer("Consumer " + i);
            new Thread(consumer).start();
        }
         
        Thread.sleep(5000); // After 5s have another comsumer
        Consumer consumer = new Consumer("Consumer " + 4);
        new Thread(consumer).start();
    }
    
}
