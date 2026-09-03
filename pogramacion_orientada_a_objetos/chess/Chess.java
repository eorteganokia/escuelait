class Chess {
    private final Board board;
    private final Player[] players;
    private final Turn turn;

    public Chess(){
        this.board = new Board();
        this.players = new Player[2];
        this.players[0] = new Player(Color.WHITE);
        this.players[1] = new Player(Color.BLACK);
        this.turn = new Turn();
    }

    public void play(){
        this.board.setUp();
        do{
            this.board.show();
            this.players[this.turn.current()].move(this.board);
            turn.shift();
        }while(!this.board.isCheckMate());
        System.out.println("The winner is: " + this.players[this.turn.opposite()].color());
    }

    public static void main(String[] args){
        new Chess().play();
    }
}
