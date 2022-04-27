public class SnakesAndLaddersGame
{
    Die die;
    GameBoard board;
    int playersNum;
    Player[] players;
    final int BOARD_SIZE = 100;
    final int MAX_INPUT_LENGTH = 4;

    public SnakesAndLaddersGame(int min, int max){
        this.die = new Die(min, max);
    }

    public SnakesAndLaddersGame(){
        this.die = new Die();
    }

    public void initializeGame(){
        int squareNum;
        int length;
        this.players = new Player[5];
        this.playersNum = 0;
        boolean sameName = false;
        boolean sameColor = false;
        String [] input = new String[MAX_INPUT_LENGTH];
        while (true) {
            input = Main.scanner.nextLine().split(" ");
            if (input[0].equals("end"))
            {
                if(playersNum >= 2)
                {
                    break;
                }
                System.out.println("Cannot start the game, there are less then two players!");
            }
            if(input[1].equals("player")){
                if(playersNum >= 5) {
                    System.out.println("The maximal number of players is five!");
                    continue;
                }
                for(int i = 0; i < playersNum; i++){
                    if(input[2] == players[i].getName()){
                        sameName = true;
                    }
                    if(input[3].equals(players[i].getColor().name())){
                        sameColor = true;
                    }
                }
                if((sameName)&&(sameColor))
                {
                    System.out.println("The name and the color are already taken!");
                }
                else if (sameName)
                {
                    System.out.println("The name is already taken!");
                }
                else if(sameColor){
                    System.out.println("The color is already taken!");
                }
                else{
                    players[playersNum].setName(input[2]);
                    players[playersNum].setColor(Colors.valueOf(input[3]));
                    this.playersNum++;
                }
            }
            else if(input[1] == "ladder"){
                squareNum = Integer.parseInt(input[3]);
                length = Integer.parseInt(input[2]);
                if((squareNum >= 101) || (squareNum <= 0)){
                    System.out.println("The square is not within the board's boundaries!");
                }
                else if(squareNum + length >= 101)
                {
                    System.out.println("The ladder is too long!");
                }
                else if(board.getBoard()[squareNum].getLadderLength() != 0){
                    System.out.println("This square already contains a bottom of a ladder!");
                }
                else if(board.getBoard()[squareNum].getSnakeLength() != 0){
                    System.out.println("This square contains a head of a snake!");
                }
                else {
                    board.getBoard()[squareNum].setLadderLength(length);
                }
            }
            else if(input[1] == "snake"){
                squareNum = Integer.parseInt(input[3]);
                length = Integer.parseInt(input[2]);
                if((squareNum >= 101) || (squareNum <= 0)){
                    System.out.println("The square is not within the board's boundaries!");
                }
                if(squareNum == 100)
                {
                    System.out.println("You cannot add a snake in the last square!");
                }
                else if(squareNum - length <= 0)
                {
                    System.out.println("The snake is too long!");
                }
                else if(board.getBoard()[squareNum].getLadderLength() != 0){
                    System.out.println("This square contains a bottom of a ladder!");
                }
                else if(board.getBoard()[squareNum].getSnakeLength() != 0){
                    System.out.println("This square already contains a head of a snake!");
                }
                else {
                    board.getBoard()[squareNum].setSnakeLength(length);
                }
            }

        }
    }

}
