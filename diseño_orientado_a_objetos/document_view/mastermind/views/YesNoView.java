package views;

import utils.Console;

public class YesNoView extends BaseView{
    public YesNoView(String prompt){
        super(prompt);
    }

    public boolean answerYes(){
        Console in = new Console();
        String answer;
        do {
            answer = in.readString(this.getPrompt());
        }while (!answer.equals("y") && !answer.equals("n"));

        return answer.equals("y");
    }
}
