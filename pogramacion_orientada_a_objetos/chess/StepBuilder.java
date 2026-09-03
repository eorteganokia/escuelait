import java.util.ArrayList;

public class StepBuilder {
    private ArrayList<Step> steps;

    public StepBuilder(){
        this.steps = new ArrayList<Step>();
    }

    public BaseStep getStep(){
        if(this.steps.size() == 1){
            return this.steps.getFirst();
        }
        else{
            return new ComplexStep(this.steps);
        }
    }

    public void reset(){
        this.steps = new ArrayList<Step>();
    }

    public StepBuilder addLeft(){
        this.steps.add(new Step(Direction.LEFT));
        return this;
    }

    public StepBuilder addRight(){
        this.steps.add(new Step(Direction.RIGHT));
        return this;
    }

    public StepBuilder addUp(){
        this.steps.add(new Step(Direction.UP));
        return this;
    }

    public StepBuilder addDown(){
        this.steps.add(new Step(Direction.DOWN));
        return this;
    }

    public StepBuilder addUpperLeft(){
        this.steps.add(new Step(Direction.UPPER_LEFT));
        return this;
    }

    public StepBuilder addUpperRight(){
        this.steps.add(new Step(Direction.UPPER_RIGHT));
        return this;
    }

    public StepBuilder addDownRight(){
        this.steps.add(new Step(Direction.DOWN_RIGHT));
        return this;
    }

    public StepBuilder addDownLeft(){
        this.steps.add(new Step(Direction.DOWN_LEFT));
        return this;
    }
}

