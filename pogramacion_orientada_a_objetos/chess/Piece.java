class Piece {
    protected String id;
    private final Color color;
    protected MovementRule movementRule;

    public Piece(Color color, String id){
        this.color = color;
        if(this.color == Color.WHITE){
            this.id = id.toLowerCase();
        }
        else{
            this.id = id.toUpperCase();
        }
    }

    public String toString() {
        return this.id;
    }

    public Color getColor() {
        return this.color;
    }

    public MovementRule getMovementRule(){
        return this.movementRule;
    }

    public void buildMovementRule(){

    }
}
