class Board {
    private final int MAX_ATTEMPTS = 10;
    private int currentAttempt;
    private boolean isWinner;
    private String[] attempts;
    private final SecretCombination secret;

    public Board() {
        this.secret = new SecretCombination();
        this.attempts = new String[MAX_ATTEMPTS];
        this.currentAttempt = 0;
        this.isWinner = false;
    }

    public void play() {
        Combination proposed = new Combination();
        this.secret.generate();
        do {
            System.out.println(String.format("%d attempt(s)", this.currentAttempt));
            proposed.askCombination();
            if(this.secret.equals(proposed)){
                this.isWinner = true;
            }
            else{
                this.attempts[this.currentAttempt] = this.secret.feedback(proposed);
                this.showAttempts();
            }
        }while(this.hasAttempts() && !this.isWinner);
        this.result();
    }

    private boolean hasAttempts() {
        this.currentAttempt++;
        return this.currentAttempt < this.MAX_ATTEMPTS;
    }

    public void showAttempts(){
        for(int i = 0; i <= this.currentAttempt; i++){
            System.out.println(this.attempts[i]);
        }
    }

    public void result(){
        if(this.isWinner){
            System.out.println("You have Won!!!");
        }
        else{
            System.out.println("You have Lose!");
        }
    }
}
