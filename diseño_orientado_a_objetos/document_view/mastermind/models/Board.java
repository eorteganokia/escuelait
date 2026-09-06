package models;

public class Board {
    private final int MAX_ATTEMPTS = 10;
    private int currentAttempt;
    private boolean isWinner;
    private String[] attempts;
    private final SecretCombination secret;

    public Board() {
        this.secret = new SecretCombination();
        this.attempts = new String[MAX_ATTEMPTS];
        this.start();
    }

    public void start(){
        this.currentAttempt = 0;
        this.secret.generate();
        this.isWinner = false;
    }

    public int getCurrentAttempt(){
        return this.currentAttempt;
    }

    public boolean isPlayerWinner(){
        return this.isWinner;
    }

    public String[] getAttempts(){
        return this.attempts;
    }

    public void attempt(Combination proposed) {
        if(this.secret.equals(proposed)){
            this.isWinner = true;
        }
        else{
            this.attempts[this.currentAttempt] = this.secret.feedback(proposed);
        }
    }

    public boolean hasAttempts() {
        this.currentAttempt++;
        return this.currentAttempt < this.MAX_ATTEMPTS;
    }

}
