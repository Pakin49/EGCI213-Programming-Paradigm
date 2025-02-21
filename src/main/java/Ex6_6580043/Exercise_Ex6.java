// Pakin Panawattanakul 6580043
package Ex6_6580043;

import java.io.*;
import java.util.*;

public class Exercise_Ex6 {
    static ArrayList<CardThread> thread_list = new ArrayList<>();

    public static void main(String[] args) {
        // Scan for numbers of threads
        Scanner key_scan = new Scanner(System.in);
        System.out.println("Number of threads = ");
        int num_threads = 0;

        // If the input is not valid ask for another int
        while (true) {
            try {
                num_threads = key_scan.nextInt();
                break;
            } catch (RuntimeException re) {

                System.err.println("Enter valid integer");
                key_scan.nextLine();
            }
        }
        for (int i = 0; i < num_threads; i++) {
            thread_list.add(new CardThread(i));
        }
    }
}