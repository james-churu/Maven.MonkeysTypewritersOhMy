package io.zipcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MonkeyTypewriter {

    public Integer[] bubbleSort(Integer[] list){


        for(int x =  0 ; x < list.length-1;  x++){

            for(int z =  0 ; z < list.length -1 - x;  z++){

                if(list[z] > list[z+1]){

                    Integer  temp =  list[z];
                    list[z] = list[z +1];
                    list[z + 1] = temp;
                }

            }
        }
        return list;
    }

    public static void main(String[] args) {
        String introduction = "It was the best of times,\n" +
                "it was the blurst of times,\n" +
                "it was the age of wisdom,\n" +
                "it was the age of foolishness,\n" +
                "it was the epoch of belief,\n" +
                "it was the epoch of incredulity,\n" +
                "it was the season of Light,\n" +
                "it was the season of Darkness,\n" +
                "it was the spring of hope,\n" +
                "it was the winter of despair,\n" +
                "we had everything before us,\n" +
                "we had nothing before us,\n" +
                "we were all going direct to Heaven,\n" +
                "we were all going direct the other way--\n" +
                "in short, the period was so far like the present period, that some of\n" +
                "its noisiest authorities insisted on its being received, for good or for\n" +
                "evil, in the superlative degree of comparison only.";

        // Do all of the Monkey / Thread building here
        // For each Copier(one safe and one unsafe), create and start 5 monkeys copying the introduction to
        // A Tale Of Two Cities.
        SafeCopier safeCopier = new SafeCopier(introduction);
        UnsafeCopier unsafeCopier = new UnsafeCopier(introduction);
        List<Thread> listOfThreads = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread safe = new Thread(safeCopier);
            safe.start();
            listOfThreads.add(safe);
            Thread unsafe = new Thread(unsafeCopier);
            unsafe.start();
            listOfThreads.add(unsafe);
        }

        // This wait is here because main is still a thread and we want the main method to print the finished copies
        // after enough time has passed.
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("MAIN INTERRUPTED");
        }
        // Print out the copied versions here.



        Logger.getGlobal().info("\nSafe Thread\n - - - - - - - - - - - - - - - - \n" + safeCopier.copied);
        Logger.getGlobal().info("\nUnsafe Thread\n - - - - - - - - - - - - - - - - \n" + unsafeCopier.copied);

    }
}