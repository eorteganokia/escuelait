package views;

import controllers.BoardController;

public class AttemptView extends BaseView{
    private ProposedCombinationView proposedCombinationView;
    private BoardController boardController;

    public AttemptView(String prompt, BoardController boardController){
        super(prompt);
        this.boardController = boardController;
        this.proposedCombinationView = new ProposedCombinationView("");
    }

    @Override
    public void show(){
        int currentAttempt = this.boardController.getCurrentAttempt();
        System.out.println(String.format("%d attempt(s)", currentAttempt));
        this.proposedCombinationView.show();
        this.boardController.attempt(this.proposedCombinationView.getProposedCombination());
        if(!this.boardController.isPlayerWinner()){
            this.showAttempts(currentAttempt);
        }
    }

    public void showAttempts(int currentAttempt){
        String[] attempts;
        attempts = this.boardController.getAllAttempts();
        for(int i = 0; i <= currentAttempt; i++){
            System.out.println(attempts[i]);
        }
    }
}
