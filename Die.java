public class Die {
    private int max;
    private int min;


    public Die(int max, int min){
        this.max = max;
        this.min = min;
    }

    public Die() {
        this.max = 6;
        this.min = 1;
    }


    public int getMax(){
        return this.max;
    }


    public int getMin(){
        return this.min;
    }


    public void setMax(int max){
        this.max = max;
    }


    public void setMin(int min){
        this.min = min;
    }


    public int roll() {
        return Main.rnd.nextInt(max - min + 1) + min;
    }

}
