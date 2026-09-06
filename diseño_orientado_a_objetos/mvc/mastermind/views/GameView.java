package views;

import controllers.BoardController;

public class GameView extends BaseView{
    private AttemptView attemptView;
    private BoardController boardController;

    public GameView(String prompt){
        super(prompt);
        this.boardController = new BoardController();
        this.attemptView = new AttemptView("", this.boardController);
    }

    @Override
    public void show(){
        do{
            this.attemptView.show();
        }while (this.boardController.hasAttempts());
        new ResultView("", this.boardController).show();
    }
}
