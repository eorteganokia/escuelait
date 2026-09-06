package views;

import controllers.CombinationController;
import utils.Console;

public class ProposedCombinationView extends BaseView{
    private CombinationController combinationController;

    public ProposedCombinationView(String prompt){
        super(prompt);
        this.combinationController = new CombinationController();
    }

    @Override
    public void show(){
        String combination;
        Console console = new Console();
        do{
            combination = console.readString("Propose a combination: ");
            this.combinationController.setFromString(combination);
        }while(!this.combinationController.isValid(combination));

    }

    public CombinationController getProposedCombination(){
        return this.combinationController;
    }
}
