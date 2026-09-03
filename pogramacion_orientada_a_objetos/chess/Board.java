import java.util.ArrayList;
import java.util.HashMap;


public class Board {
    private final int SIZE = 8;
    private Square[][] matrix;
    private int util = 0;

    public Board(){
        this.matrix = new Square[SIZE][SIZE];
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                this.matrix[i][j] = new Square();
            }
        }
    }

    public void show() {
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                System.out.printf("| %s ", this.matrix[i][j].toString());
            }
            System.out.print("|");
            System.out.println();
        }
    }

    public boolean isCheckMate() {
        if(this.util == 3){
            return true;
        }
        this.util = 1;
        return false;
    }

    public void place(int row, int col, Piece piece) {
        this.matrix[row][col].setPiece(piece);
    }

    public void setUp() {
        this.setUpPiecesBy(Color.WHITE);
        this.setUpPiecesBy(Color.BLACK);
    }

    private void setUpPiecesBy(Color color) {
        int PIECES_PER_COLOR = 16;
        int row = this.getStartRow(color);
        int next = this.getMovementUnit(color);
        int col = 0;
        for(; col < PIECES_PER_COLOR / 2; col++){
            this.place(row, col, new Pawn(color));
        }
        col = 0;
        row = row + next;
        this.place(row, col++, new Rook(color));
        this.place(row, col++, new Knight(color));
        this.place(row, col++, new Bishop(color));
        this.place(row, col++, new Queen(color));
        this.place(row, col++, new King(color));
        this.place(row, col++, new Bishop(color));
        this.place(row, col++, new Knight(color));
        this.place(row, col, new Rook(color));
    }

    private int getStartRow(Color color){
        if(color == Color.WHITE){
            return 1;
        }
        return 6;
    }

    private int getMovementUnit(Color color){
        if(color == Color.WHITE){
            return -1;
        }
        return 1;
    }

    public boolean isPieceOf(Coordinate coordinate, Color color) {
        return !this.matrix[coordinate.getRow()][coordinate.getColumn()].isEmpty() &&
                this.matrix[coordinate.getRow()][coordinate.getColumn()].isColor(color);
    }

    public boolean isValidMovement(Coordinate start, Coordinate end) {
        MovementRule movementRule = this.matrix[start.getRow()][start.getColumn()].getPiece().getMovementRule();
        return movementRule.is_valid_end(this, start, end);
    }

    private ArrayList<Coordinate> getPiecePositionList(Coordinate start, HashMap movement){
        /*
        import java.util.HashMap;
        enum Country {
                England,
                Germany,
                Norway,
                USA
            }

        public class Main {
          public static void main(String[] args) {
            HashMap<Country, String> capitalCities = new HashMap<Country, String>();
            capitalCities.put(Country.England, "London");
            for (Country i : capitalCities.keySet()) {
              System.out.println("" + i + " = " + capitalCities.get(i));
            }
          }
        }
         */
        ArrayList<Coordinate> positions = new ArrayList<Coordinate>();
        return positions;
    }

    public void move(Coordinate start, Coordinate end) {
        Piece piece = this.matrix[start.getRow()][start.getColumn()].getPiece();
        MovementRule movementRule = piece.getMovementRule();
        if(movementRule.is_valid_end(this, start, end)) {
            this.matrix[start.getRow()][start.getColumn()].setPiece(null);
            this.matrix[end.getRow()][end.getColumn()].setPiece(piece);
        }
    }
}
