package Ex6_6580043;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

class CardThread extends Thread {
    private PrintWriter out;
    private ArrayList<OneCard> randomCards;

    private final int tid; // thread_id use for printing

    // Constructors
    public CardThread (int thread_num){ this.tid  = thread_num; randomCards = new ArrayList<>(); this.start();}

    //methods
    boolean check_rank(){
        String suit = randomCards.get(0).get_rank();
        boolean result = true;
        for(int i=1; i < 4; i++){
            if(!suit.equals(randomCards.get(i).get_rank())){
                result = false;
            }
        }
        return result;
    }
    boolean check_suit(){
        String suit = randomCards.get(0).get_suit();
        boolean result = true;
        for(int i=1; i < 4; i++){
            if(!suit.equals(randomCards.get(i).get_suit())){
                result = false;
            }
        }
        return result;
    }

    void print_cards(int round){
        out.printf("Round %3d  [",round);
        for(int i = 0; i < 4; i++){
            out.printf(" %2s of %-8s ",randomCards.get(i).get_rank(),randomCards.get(i).get_suit());
            if(i<3){
                out.printf(",");
            }
        }
        out.println("]\n");
    }
    void draw_cards(){
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            int rand_int = random.nextInt(52); // random integer

            // Detect if card is duplicated?
            boolean duplicate_card = false;
            for (OneCard randomCard : randomCards) {
                if (randomCard.get_score() == rand_int) {
                    duplicate_card = true;
                    break;
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

        String directory = "src/main/java/Ex6_6580043/T";
        String path = directory+this.tid+".txt";
        try {
            File out_file = new File(path);
            out = new PrintWriter(out_file);
        }catch (Exception e) {
            System.err.println(e.getClass().getName());
        }
        int round = 0;
        boolean finish = false;
        while (!finish) {
            draw_cards(); // draw 4 cards
            print_cards(round);//print the card in the ArrayList
            round += 1;
            if (check_suit() || check_rank()) {
                finish = true;
            }
            randomCards.clear();
        }
        out.close();
        System.out.printf("Thread T%d finishes in %3d rounds\n", this.tid, round);
    }
}