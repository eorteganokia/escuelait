import java.util.ArrayList;

public class MovementRule {
    private int allow_peace_in_path;
    private ArrayList<BaseStep> step_options;

    public MovementRule(ArrayList<BaseStep> step_options){
        this.step_options = step_options;
    }

    public boolean is_valid_end(Board board, Coordinate start, Coordinate end){
        return false;
    }

    public void move(Coordinate end){

    }
}