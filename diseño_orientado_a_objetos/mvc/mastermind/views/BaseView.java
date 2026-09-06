package views;

public class BaseView {
    private String prompt;

    public BaseView(String prompt){
        this.prompt = prompt;
    }

    public String getPrompt(){
        return this.prompt;
    }

    public void show() {
        System.out.println(this.prompt);
    }
}
