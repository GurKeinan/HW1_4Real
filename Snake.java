
public class Snake
{
    int length;//we characterized each snake by its length only.

    /**
     * snake constructor
     * @param length- the length of the snake
     */
    public Snake(int length)
    {
        this.length = length;
    }

    /**
     * @return the snake's length
     */
    public int getLength(){
        return this.length;
    }

    /**
     * sets a new length to the snake
     * @param length - the new length
     */
    public void setLength(int length){
        this.length = length;
    }


}


