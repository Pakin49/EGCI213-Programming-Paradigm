package Ex6_6580043;

class OneCard {
    private int score; // 0-51
    private int suit; // clubs, diamonds, hearts, spades
    private int rank; // ace, 2-10, jack, queen, king

    public OneCard(int sc) {
        this.score = sc;
        // represent card suit by %4 result
        // 0 = club, 1 = diamonds, 2 = hearts, 3 = spades
        this.suit = sc / 13;
        // jack = 11, queen = 12, king =13
        this.rank = (sc%13)+1;
    }

    //Setter & Getter
    int get_score(){ return this.score;}
    String get_suit(){
        String s = "";
        if(this.suit==0){ s = "Clubs";}
        else if(this.suit==1){ s = "Diamonds";}
        else if(this.suit==2){ s = "Hearts";}
        else { s = "Spades";}
        return s;
    }
    String get_rank(){
        String r = "";
        if (this.rank == 1){r = "A";}
        else if (this.rank == 11){ r = "J";}
        else if (this.rank == 12){ r = "Q";}
        else if (this.rank == 13){ r = "K";}
        else { r = String.valueOf(this.rank);}
        return r;
    }
}