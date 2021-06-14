public class Player {
    //array for player board
    private char [][] playerBoard = new char [8][8];

    Player() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                playerBoard[i][j] = '-';
            }

        }
    }
    //function to place player
    public void placePlayerItem(int rowPos, int colPos, char itemToBePlaced) {
        playerBoard[rowPos][colPos] = itemToBePlaced;
        // logic to see if you are out of bounds or not; playerBoard[rowPos][colPos+1] = itemToBePlaced;
        //logic:
        if (rowPos >= 8 || colPos >= 8){
            System.out.println("You are out of bounds place your ship someone else");
            return;
        }
        else placePlayerItem(rowPos,colPos);

        //print();
        showGB('-','x');
    }
    //print player board
    public void print() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(playerBoard[i][j]);
                System.out.print(' ');
            }
            System.out.println("");
            System.out.println("---------");
        }
    }
    //showing the game board here
    public void showGB(char water, char ship) {
        int gameBoardLength = playerBoard.length;
        System.out.print("  ");
        for (int i = 0; i < gameBoardLength; i ++){
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        //double for loop to display gameboard
        for (int row = 0; row < gameBoardLength; row++){
            System.out.print(row + 1 + " ");
            for (int column = 0; column < gameBoardLength; column++){
                System.out.print(playerBoard[row][column] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    //function to get player item
    public char getPlayerItem(int rowPos, int colPos) {
        return playerBoard[rowPos][colPos];
    }
    //function to check if all ships are hit used to end the game in the main class
    public boolean CheckIfHitAllShips() {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(playerBoard[i][j] == '!') return false;
            }
        }
        return true;
    }
    //used to fund and replace grid with hit or miss symbols
    public char playerHitOrMiss(int rowPos, int colPos, Player player) { //player1 = J ; player2 = S    [0][2] : 'X'
        char hitOrMiss = player.getPlayerItem(rowPos, colPos);
        if (hitOrMiss == '!') {
            playerBoard[rowPos][colPos] = 'X';
            return 'H';
        }
        else {
            playerBoard[rowPos][colPos] = '0';
            return 'M';
        }
    }

    //other way to implement this
    public void placePlayerItem(int rowPos, int colPos) { //  [0][2] : 'X'
        playerBoard[rowPos][colPos] = '!';

        //print();
        showGB('-','X');
    }


}

