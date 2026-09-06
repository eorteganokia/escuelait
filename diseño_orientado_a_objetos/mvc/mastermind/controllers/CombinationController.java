package controllers;

import models.Combination;

public class CombinationController {
    private Combination proposedCombination;

    public CombinationController(){
        this.proposedCombination = new Combination();
    }

    public boolean isValid(String combination){
        return this.proposedCombination.isValidLength(combination) && this.proposedCombination.hasValidColors(combination);
    }

    public void setFromString(String combination){
        if(this.isValid(combination)){
            this.proposedCombination.setFromString(combination);
        }
    }

    public Combination getProposed(){
        return this.proposedCombination;
    }
}
