public class Player
{
    String name;
    Colors color;
    int currSquare;


    public Player(String name , Colors color , int currSquare)
    {
        this.name = name;
        this.color = color;
        this.currSquare =0;
    }

    public void moveSquare(int roll)
    {
        this.currSquare += roll;
    }




}
