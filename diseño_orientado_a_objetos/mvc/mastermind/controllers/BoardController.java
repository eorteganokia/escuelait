package controllers;

import models.Board;

public class BoardController {
    private Board board;

    public BoardController(){
        this.board = new Board();
    }

    public boolean hasAttempts() {
        return this.board.hasAttempts();
    }

    public boolean isPlayerWinner(){
        return this.board.isPlayerWinner();
    }

    public int getCurrentAttempt(){
        return this.board.getCurrentAttempt();
    }

    public String[] getAllAttempts(){
        return this.board.getAttempts();
    }

    public void attempt(CombinationController combinationController) {
        this.board.attempt(combinationController.getProposed());
    }
}
