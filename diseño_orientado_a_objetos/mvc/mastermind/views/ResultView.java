package views;

import controllers.BoardController;

public class ResultView extends BaseView{
    private BoardController boardController;

    public ResultView(String prompt, BoardController boardController){
        super(prompt);
        this.boardController = boardController;
    }

    @Override
    public void show(){
        if(this.boardController.isPlayerWinner()){
            System.out.println("You have Won!!!");
        }
        else{
            System.out.println("You have Lose!");
        }
    }
}
