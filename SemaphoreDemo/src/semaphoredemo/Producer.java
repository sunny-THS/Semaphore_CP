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
public class Producer implements Runnable {
        private String name;
 
        public Producer(String name) {
            this.name = name;
        }
 
        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println(name + ": acquiring lock...");
                    System.out.println(name + ": Producer available Semaphore permits now: " + writePermits.availablePermits());
                    writePermits.acquire();
                    System.out.println(name + ": got the permit!");
 
                    Thread.sleep(50); // simulate time to work
                    int data = ThreadLocalRandom.current().nextInt(100);
                    System.out.println(name + ": produced data " + buffer.push(data));
 
                    System.out.println(name + ": releasing lock...");
                    readPermits.release();
                    System.out.println(name + ": Consumer available Semaphore permits now: " + readPermits.availablePermits());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
