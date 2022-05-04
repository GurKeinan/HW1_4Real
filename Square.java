public class Square
{
    //each square contains a ladder and a snake in it.
    //the default length of each ladder and snake is 0.
    //in the instruction is says that it cant contains both, so if one of them isnt 0 the other one is.
    //its useful to do it this way because the transformation between squares will be more smooth- the subtraction of
    //them will tell us to which square the current one is "connected".
    Snake snake;
    Ladder ladder;

    /**
     * constructor of a new square
     * @param snake- the snake in the current square
     * @param ladder- the ladder in the current square
     */
    public Square(Snake snake , Ladder ladder)
    {
        this.snake= snake;
        this.ladder = ladder;
    }

    /**
     * default constructor- the lengths of the ladder and snake are 0
     */
    public Square()
    {
        this(new Snake(0 ),new Ladder(0));
    }

    /**
     *
     * @return the square's ladder's length
     */
    public int getLadderLength(){
        return this.ladder.getLength();
    }

    /**
     *
     * @return the square's snake's length
     */
    public int getSnakeLength(){
        return this.snake.getLength();
    }

    /**
     * changes the length of the ladder
     * @param length- the new length of the ladder
     */
    public void setLadderLength(int length){
        this.ladder.setLength(length);
    }

    /**
     * changes the length of the snake
     * @param length- the new length of the snake
     */
    public void setSnakeLength(int length){
        this.snake.setLength(length);
    }




}
