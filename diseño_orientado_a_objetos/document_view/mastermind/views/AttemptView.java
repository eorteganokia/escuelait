package views;

import models.Board;

public class AttemptView extends BaseView{
    private ProposedCombinationView proposedCombinationView;
    private Board board;

    public AttemptView(String prompt, Board board){
        super(prompt);
        this.board = board;
        this.proposedCombinationView = new ProposedCombinationView("");
    }

    @Override
    public void show(){
        int currentAttempt = this.board.getCurrentAttempt();
        System.out.println(String.format("%d attempt(s)", currentAttempt));
        this.proposedCombinationView.show();
        this.board.attempt(this.proposedCombinationView.getProposedCombination())
        if(!this.board.isPlayerWinner()){
            this.showAttempts(currentAttempt);
        }
    }

    public void showAttempts(int currentAttempt){
        String[] attempts;
        attempts = this.board.getAttempts();
        for(int i = 0; i <= currentAttempt; i++){
            System.out.println(attempts[i]);
        }
    }
}
