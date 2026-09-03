class Player {
    private final Color color;

    public Player(Color color){
        this.color = color;
    }

    public String color() {
        return this.color.toString();
    }

    public void move(Board board) {
        Coordinate start = new Coordinate();
        Coordinate end = new Coordinate();
        System.out.printf("%s's playing...", this.color);
        System.out.println();
        do {
            System.out.print("Pick up a piece...");
            start.read();
        }while(!board.isPieceOf(start, this.color));
        end.read();
        board.isValidMovement(start, end);
        board.move(start, end);
    }
}
