public class Player
{
    String name;
    Colors color;
    int currSquare;

    /**
     * constructor of a new player
     * @param name - the name of the player
     * @param color - the color of the player
     *              all the players start from square number 1
     */
    public Player(String name , Colors color)
    {
        this.name = name;
        this.color = color;
        this.currSquare =1;
    }

    /**
     *
     * @return the player's name
     */
    public String getName(){
        return this.name;
    }

    /**
     *
     * @return the color (in enum) of the player
     */
    public Colors getColor(){
        return this.color;
    }

    /**
     *
     * @return the number of the current square
     */
    public int getCurrSquare(){
        return this.currSquare;
    }

    /**
     * changes the current square according to the roll
     * takes care of the cases when the current square is below 1 or above 100
     * @param roll- the number of steps
     */
    public void moveSquare(int roll)
    {
        this.currSquare += roll;
        if(currSquare < 1) currSquare = 1;
        if(currSquare > 100) currSquare = 200-currSquare;
    }

    /**
     * prints the position of the player in the wanted format
     */
    public void printPosition()
    {
        System.out.println(name+ " is in square number " + currSquare);
    }




}
