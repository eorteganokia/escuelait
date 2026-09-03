class Turn {
    private int index;

    public Turn(){
        this.index = 0;
    }
    public int current() {
        return this.index;
    }

    public void shift() {
        this.index = (this.index + 1) % 2;
    }

    public int opposite() {
        return (this.index + 1) % 2;
    }
}
