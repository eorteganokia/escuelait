import java.util.Random;

class SecretCombination extends Combination{
    public void generate() {
        Random r = new Random();
        String indexes = "";
        Color[] colors = Color.values();
        int index;
        int i = 0;
        do{
            index = r.nextInt(colors.length);
            if(!indexes.contains(String.valueOf(index))){
                indexes = indexes.concat(String.valueOf(index));
                this.code[i] = colors[index];
                i++;
            }
        }while (i < CODE_LENGTH);
    }

    public String feedback(Combination proposed) {
        int blacks = 0;
        int whites = 0;
        for(int i = 0; i < CODE_LENGTH; i++){
            for(int j = 0; j < CODE_LENGTH; j++){
                if(this.code[i] == proposed.code[j]){
                    if(i == j){
                        blacks++;
                    }
                    else{
                        whites++;
                    }
                }
            }
        }
        return String.format("%s --> %d Blacks and %d Whites", proposed.toString(), blacks, whites);
    }
}
