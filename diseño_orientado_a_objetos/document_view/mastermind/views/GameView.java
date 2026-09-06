package views;

import models.Board;

public class GameView extends BaseView{
    private AttemptView attemptView;
    private Board board;

    public GameView(String prompt){
        super(prompt);
        this.board = new Board();
        this.attemptView = new AttemptView("", this.board);
    }

    @Override
    public void show(){
        do{
            this.attemptView.show();
        }while (this.board.hasAttempts());
        new ResultView("", this.board).show();
    }
}
