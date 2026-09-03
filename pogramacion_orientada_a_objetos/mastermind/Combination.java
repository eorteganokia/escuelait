enum Color{
    RED("r"),
    BLUE("b"),
    GREEN("g"),
    YELLOW("y"),
    PINK("p"),
    MAGENTA("m"),
    ORANGE("o"),
    SILVER("s");

    private String key;

    private Color(String key)
    {
        this.key = key;
    }

    public String getKey(){
        return this.key;
    }

    public static Color fromString(String key)
    {
        for (Color c : Color.values()) {
            if (c.key.equalsIgnoreCase(key)) {
                return c;
            }
        }
        return null;
    }
}

class Combination {
    protected final int CODE_LENGTH = 4;
    protected Color[] code;

    public Combination(){
        this.code = new Color[CODE_LENGTH];
    }

    private boolean isValidLength(String combination){
        if(combination.length() != CODE_LENGTH){
            System.out.println("Wrong proposed combination length");
            return false;
        }
        return true;
    }

    private boolean hasValidColors(String combination){
        for(char c: combination.toCharArray()){
            if(Color.fromString("" + c) == null){
                System.out.println("Wrong colors, they must be: rbgypmos");
                return false;
            }
        }
        return true;
    }

    private boolean isValid(String combination){
        return this.isValidLength(combination) && this.hasValidColors(combination);
    }

    private Color[] fromString(String combination){
        Color[] newCode = new Color[CODE_LENGTH];
        char[] charArrayCode = combination.toCharArray();

        for(int i = 0; i < charArrayCode.length; i++){
            newCode[i] = Color.fromString("" + charArrayCode[i]);
        }
        return newCode;
    }

    public void askCombination() {
        String proposeCombination;
        Console console = new Console();
        proposeCombination = console.readString("Propose a combination: ");
        if(this.isValid(proposeCombination)){
            this.code = this.fromString(proposeCombination);
        }
    }

    public boolean equals(Combination combination){
        for(int i = 0; i < this.CODE_LENGTH; i++){
            if(this.code[i] != combination.code[i]){
                return false;
            }
        }
        return true;
    }

    public String toString(){
        String stringCode = "";
        for(int i = 0; i < this.CODE_LENGTH; i++){
            stringCode = stringCode.concat(this.code[i].getKey());
        }
        return stringCode;
    }
}
