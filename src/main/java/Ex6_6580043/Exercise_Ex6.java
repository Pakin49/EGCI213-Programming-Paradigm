// Pakin Panawattanakul 6580043
package Ex6_6580043;

import java.io.*;
import java.util.*;

class OneCard {
    private int score; // 0-51
    private int suit; // clubs, diamonds, hearts, spades
    private int rank; // ace, 2-10, jack, queen, king

    public OneCard(int sc) {
        this.score = sc;
        // represent card suit by %4 result
        // 0 = club, 1 = diamonds, 2 = hearts, 3 = spades
        this.suit = sc % 4;
        // jack = 11, queen = 12, king =13
        this.rank = (sc/4)+1;
    }

    //Setter & Getter
    void set_score(int score){ this.score  = score;}
    int get_score(){ return this.score;}
    int get_suit(){ return this.suit;}
    int rank(){ return this.rank;}

    // methods
    String print_card(){
        String s_rank = "";
        if(rank)
    }
}

class CardThread extends Thread {
    private PrintWriter out;
    private ArrayList<OneCard> randomCards;

    private final int tid; // thread_id use for printing

    // Constructors
    public CardThread (int thread_num){
        this.tid  = thread_num;

    }

    //methods
    void print_cards(int round){
        out.printf("Round %3d  [ ",round);
    }
    void draw_cards(int number_card){
        for (int i = 0; i < number_card; i++) {
            Random random = new Random();
            int rand_int = random.nextInt(52); // random integer

            // Detect if card is duplicated?
            boolean duplicate_card = false;
            for (int j = 0; j < randomCards.size(); j++) {
                if (randomCards.get(j).get_score() == rand_int) {
                    duplicate_card = true;
                }
            }
            if (duplicate_card) {
                i--;
                continue;
            }
            // If the card is not duplicate then at the card to the list
            randomCards.add(new OneCard(rand_int));
        }
    }

    @Override
    public void run() {

        String directory = "src/main/java/";
        String path = directory+this.tid;
        File out_file = new File(path);

        int round = 0;
        boolean finish = false;
        while(!finish) {
            randomCards.removeAll(randomCards);
            draw_cards(4); // draw 4 cards
            print_cards(round);//print the card in the ArrayList


            // Create PrintWriter object to write result to a separate file
            // Execute steps 1-3 in loop:
            // 1. Draw 4 cards from the same deck. The cards must not duplicate.
            // 2. Print round number and these 4 cards to output file.
            // 3. If all cards are from the same suit or have equal rank, stop the loop.
            // Otherwise, clear randomCards & continue to the next round.
            // After the loop, print #rounds to the screen
        }

    }
}

public class Exercise_Ex6 {
    public static void main(String[] args) {
        CardThread T0 = new CardThread(0); T0.start();
        CardThread T1 = new CardThread(1); T1.start();
        CardThread T2 = new CardThread(2); T2.start();

    }

}