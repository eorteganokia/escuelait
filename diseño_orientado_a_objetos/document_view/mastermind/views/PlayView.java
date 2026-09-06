package views;


public class PlayView extends BaseView{
    public PlayView(String prompt){
        super(prompt);
    }

    @Override
    public void show() {
        YesNoView resumeView = new YesNoView("Do you want to continue (y/n)? ");
        super.show();
        do {
            new GameView("").show();
        }while(resumeView.answerYes());
    }
}
