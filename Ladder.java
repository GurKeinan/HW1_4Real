public class Ladder
{
    private int length;//we characterized each ladder by its length only.
    /**
     * ladder constructor
     * @param length- the length of the ladder
     */
    public Ladder(int length)
    {
        this.length = length;
    }

    /**
     * @return the ladder's length
     */
    public int getLength(){
        return this.length;
    }

    /**
     * sets a new length to the ladder
     * @param length - the new length
     */
    public void setLength(int length){
        this.length = length;
    }
}
