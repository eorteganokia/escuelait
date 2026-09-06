package views;

import models.Combination;
import utils.Console;

public class ProposedCombinationView extends BaseView{
    private Combination proposedCombination;

    public ProposedCombinationView(String prompt){
        super(prompt);
        this.proposedCombination = new Combination();
    }

    @Override
    public void show(){
        String combination;
        Console console = new Console();
        do{
            combination = console.readString("Propose a combination: ");
            this.proposedCombination.setFromString(combination);
        }while(!this.proposedCombination.isValid(combination));

    }

    public Combination getProposedCombination(){
        return this.proposedCombination;
    }
}
