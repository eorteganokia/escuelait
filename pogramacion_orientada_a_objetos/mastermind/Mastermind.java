class Mastermind {
    private final Board board;

    public Mastermind(){
        this.board = new Board();
    }

    private void play(){
        do {
            System.out.println("----- MASTERMIND -----");
            this.board.play();
        }while(this.isResumed());
    }

    private boolean isResumed() {
        String answer;
        Console console = new Console();
        do {
            answer = console.readString("Resume? (y/n): ");
        }while(!answer.equals("y") && !answer.equals("n"));
        return answer.equals("y");
    }

    public static void main(String[] args){
        new Mastermind().play();
    }
}
