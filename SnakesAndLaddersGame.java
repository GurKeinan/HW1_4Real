public class SnakesAndLaddersGame
{

    Die die;

    int playersNum;
    Player[] players;
    final int BOARD_SIZE = 100;
    GameBoard board;
    final int MAX_INPUT_LENGTH = 4;

    public SnakesAndLaddersGame(int min, int max){
        board = new GameBoard(BOARD_SIZE);
        this.die = new Die(max, min);
    }

    public SnakesAndLaddersGame(){
        this.die = new Die();
        board = new GameBoard(BOARD_SIZE);

    }



    public void sortByName(Player [] p) {
        Player tmp;
        Player p2 [] = new Player[playersNum];
        for(int i = 0; i < playersNum; i++) {
            int max = i;
            for(int j = i + 1; j < playersNum; j++) {
                if(p[i].getName().compareToIgnoreCase(p[j].getName()) >= 0){
                    max = j;
                }
                tmp = p[0];
                p[0] = p[max];
                p[max] = tmp;
            }
        }
    }




    public void initializeGame() {
        int squareNum;
        int length;
        this.players = new Player[5];
        this.playersNum = 0;
        boolean sameName = false;
        boolean sameColor = false;
        System.out.println("Initializing the game...");
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
                continue;
            }
            if(input[1].equals("player")){
                if(playersNum >= 5) {
                    System.out.println("The maximal number of players is five!");
                    continue;
                }
                for(int i = 0; i < playersNum; i++){
                    if(input[2].equals(players[i].getName())){
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
                    players[playersNum] = new Player(input[2], Colors.valueOf(input[3]), 1);
                    this.playersNum++;
                }
            }
            else if(input[1].equals("ladder")){
                squareNum = Integer.parseInt(input[3]);
                length = Integer.parseInt(input[2]);
                if((squareNum >= 101) || (squareNum <= 0)){
                    System.out.println("The square is not within the board's boundaries!");
                }
                else if(squareNum + length >= 101)
                {
                    System.out.println("The ladder is too long!");
                }
                else if(board.getBoard()[squareNum-1].getLadderLength() != 0){
                    System.out.println("This square already contains a bottom of a ladder!");
                }
                else if(board.getBoard()[squareNum-1].getSnakeLength() != 0){
                    System.out.println("This square contains a head of a snake!");
                }
                else {
                    board.getBoard()[squareNum-1].setLadderLength(length);
                }
            }
            else if(input[1].equals("snake")){
                squareNum = Integer.parseInt(input[3]);
                length = Integer.parseInt(input[2]);
                if((squareNum >= 101) || (squareNum <= 0)){
                    System.out.println("The square is not within the board's boundaries!");
                }
                else if(squareNum == 100)
                {
                    System.out.println("You cannot add a snake in the last square!");
                }
                else if(squareNum - length <= 0)
                {
                    System.out.println("The snake is too long!");
                }
                else if(board.getBoard()[squareNum-1].getLadderLength() != 0){
                    System.out.println("This square contains a bottom of a ladder!");
                }
                else if(board.getBoard()[squareNum-1].getSnakeLength() != 0){
                    System.out.println("This square already contains a head of a snake!");
                }
                else {
                    board.getBoard()[squareNum-1].setSnakeLength(length);
                }
            }

        }
        sortByName(players);
    }

    public String start(){
        Square curSquare;
        int round = 1;
        int winner = -1;
        while(winner == -1){
            System.out.println("------------------------- Round number " + round++ + " -------------------------");
            for(int i = 0; i < playersNum && winner == -1; i++){
                int roll = die.roll();
                System.out.print(players[i].getName() + " rolled " + roll + ". The path to the next square: "
                        + players[i].getCurrSquare() + " -> ");
                players[i].moveSquare(roll);
                System.out.print(players[i].getCurrSquare());
                curSquare = board.boardSquares[players[i].getCurrSquare() - 1];
                while (curSquare.getLadderLength() + curSquare.getSnakeLength() != 0) {
                    players[i].moveSquare(curSquare.getLadderLength() - curSquare.getSnakeLength());
                    curSquare = board.boardSquares[players[i].getCurrSquare() - 1];
                    System.out.print(" -> " + players[i].getCurrSquare());
                }
                System.out.println("");


                if(players[i].getCurrSquare() == 100)
                {
                    winner = i;
                }
            }
            System.out.println("");
            System.out.println("Players positions on the board:");
            for(int i = 0; i < playersNum; i++) players[i].printPosition();
        }
        return (players[winner].getName());
    }

}
