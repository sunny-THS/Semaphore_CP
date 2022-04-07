/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaphoredemo;

import java.util.concurrent.ThreadLocalRandom;
import static semaphoredemo.SemaphoreDemo.buffer;
import static semaphoredemo.SemaphoreDemo.readPermits;
import static semaphoredemo.SemaphoreDemo.writePermits;

/**
 *
 * @author Admin
 */
public class Consumer implements Runnable {
        private String name;
 
        public Consumer(String name) {
            this.name = name;
        }
 
        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println(name + ": acquiring lock...");
                    System.out.println(name + ": Consumer available Semaphore permits now: " + readPermits.availablePermits());
                    readPermits.acquire();
 
                    Thread.sleep(ThreadLocalRandom.current().nextInt(50, 300)); // simulate time to work
                    System.out.println(name + ": consumed data " + buffer.pop());
 
                    System.out.println(name + ": releasing lock...");
                    writePermits.release();
                    System.out.println(name + ": Producer available Semaphore permits now: " + writePermits.availablePermits());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
