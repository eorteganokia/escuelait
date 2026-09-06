import models.Board;
import views.PlayView;

class Mastermind {
    private final Board board;

    public Mastermind(){
        this.board = new Board();
    }

    private void play(){
        new PlayView("----- Mastermind -----").show();
    }

    public static void main(String[] args){
        new Mastermind().play();
    }
}
