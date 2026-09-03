import java.util.ArrayList;

class Pawn extends Piece {
    public Pawn(Color color){
        super(color, "p");
    }

    @Override
    public void buildMovementRule(){
        ArrayList<BaseStep> step_options = new ArrayList<BaseStep>();
        StepBuilder stepBuilder = new StepBuilder();
        stepBuilder.addUp();
        step_options.add(stepBuilder.getStep());
        this.movementRule = new MovementRule(step_options);
    }

}
