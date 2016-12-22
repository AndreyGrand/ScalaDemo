package org.home.demo;

import static java.lang.Thread.sleep;

/**
 * Created by andrey on 22.12.16.
 */
public class Infinity {
    public static void  main(String [] args) throws InterruptedException {
        int i = 0;
        while(true){
            System.out.println("hope " + i++);
            sleep(1000);
        }

    }
}
