// Pakin Panawattanakul 6580043
package Ex6_6580043;

import javax.smartcardio.Card;
import java.io.*;
import java.util.*;

class OneCard {
    private int score; // 0-51
    private int suit; // clubs, diamonds, hearts, spades
    private int rank; // ace, 2-10, jack, queen, king

    public OneCard(int sc) { score = sc; }

    //Setter & Getter
    void set_score(int score){ this.score  = score;}
    int get_score(){ return this.score;}
    int get_suit(){ return this.suit;}
    int rank(){ return this.rank;}
}

class CardThread extends Thread {
    private PrintWriter out;
    private ArrayList<OneCard> randomCards;

    CardThread(){
        for(int i=0;i<52;i++) {
            randomCards.add
        }
    }
    @Override
    public void run() {

        // Create PrintWriter object to write result to a separate file
        // Execute steps 1-3 in loop:
        // 1. Draw 4 cards from the same deck. The cards must not duplicate.
        // 2. Print round number and these 4 cards to output file.
        // 3. If all cards are from the same suit or have equal rank, stop the loop.
        // Otherwise, clear randomCards & continue to the next round.
        // After the loop, print #rounds to the screen
    }
}

public class Exercise_Ex6 {
    public static void main(String[] args) {
        CardThread T0 = new CardThread(); T0.run();
        CardThread T1 = new CardThread(); T1.run();
        CardThread T2 = new CardThread(); T2.run();

    }

}