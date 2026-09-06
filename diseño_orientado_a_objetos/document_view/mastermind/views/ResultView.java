package views;

import models.Board;

public class ResultView extends BaseView{
    private Board board;

    public ResultView(String prompt, Board board){
        super(prompt);
        this.board = board;
    }

    @Override
    public void show(){
        if(this.board.isPlayerWinner()){
            System.out.println("You have Won!!!");
        }
        else{
            System.out.println("You have Lose!");
        }
    }
}
