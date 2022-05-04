public class Die {
    private final int max; // the max value the die can roll
    private final int min; // the min value the die can roll


    /**
     * constructor for  new die
     * @param max - the max value the die can roll
     * @param min - the min value the die can roll
     */
    public Die(int max, int min){
        this.max = max;
        this.min = min;
    }

    /**
     * default constructor- die with max value of 6 and min value of 1
     */
    public Die() {
        this(6,1);
    }

    /**
     * roll random number between min to max
     * @return the rolled value
     */
    public int roll() {
        return Main.rnd.nextInt(max - min + 1) + min;
        //rnd will roll a number between 0 to (max-min) , and then we add min to get him to the wanted range.
    }

}
