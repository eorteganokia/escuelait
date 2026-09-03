import java.util.Scanner;

class Console {
    private final Scanner in;

    public Console(){
        this.in = new Scanner(System.in);
    }

    public String readString(String s) {
        System.out.printf(s);
        return this.in.nextLine();
    }
}
