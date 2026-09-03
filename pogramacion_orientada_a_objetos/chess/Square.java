class Square {
    private Piece piece;

    public Square(){
        this.piece = null;
    }

    public String toString() {
        if(this.piece != null){
            return this.piece.toString();
        }
        return " ";
    }

    public boolean isEmpty() {
        return this.piece == null;
    }

    public Piece getPiece(){
        return this.piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean isColor(Color color) {
        return this.piece.getColor() == color;
    }
}
