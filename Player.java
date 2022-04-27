public class Player
{
    String name;
    Colors color;
    int currSquare;


    public Player(String name , Colors color , int currSquare)
    {
        this.name = name;
        this.color = color;
        this.currSquare =1;
    }

    public String getName(){
        return this.name;
    }

    public Colors getColor(){
        return this.color;
    }

    public int getCurrSquare(){
        return this.currSquare;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setColor(Colors color){
        this.color = color;
    }

    public void setCurrSquare(int square){
        this.currSquare = square;
    }

    public void moveSquare(int roll)
    {
        this.currSquare += roll;
        if(currSquare < 1) currSquare = 1;
        if(currSquare > 100) currSquare = 200-currSquare;
    }




}
