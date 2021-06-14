import java.util.Scanner;
import java.util.*;
public class BattleshipMain {
//Main class with all the logic
    //prompting players too place ships on a grid
    private static int[] getUserLocation(int gameBoardLength) {
        int row;
        int column;
        do {
            System.out.print("Row: ");
            row = new Scanner(System.in).nextInt();
        } while (row < 0 || row > gameBoardLength + 1);
        do {
            System.out.print("Column: ");
            column = new Scanner(System.in).nextInt();
        } while (column < 0 || column > gameBoardLength + 1);
        return new int[]{row - 1, column - 1};
    }

    public static void main(String[] args) {

        System.out.println("Please place your ships player 1");

//        public void Main () {
            Player player1 = new Player();
            Player player2 = new Player();

            int row;
            int col;
            int[] pos;
        List<int[]> places = new ArrayList<int[]>();
        List<Boolean> goodRow = new ArrayList<Boolean>();
        List<Boolean> goodCol = new ArrayList<Boolean>();
        for (int i = 0; i < 3; i++) {
            // ask player1 to set their ship; ask for row, col and ship symbol (optional) : 02 - !
            pos = getUserLocation(8);
            row = pos[0];
            col = pos[1];
            places.add(pos);
            //begin check to make sure ships are not diagonal
            //check places of the ship
            //checking the row and columns
            int rowCheck = places.get(0)[0];
            int colCheck = places.get(0)[1];
            for(int iPlace = 0; iPlace < places.size(); iPlace++) {
                if(places.get(iPlace)[0] == rowCheck) goodRow.add(true);
                else goodRow.add(false);
            }
            for(int iPlace = 0; iPlace < places.size(); iPlace++) {
                if(places.get(iPlace)[1] == rowCheck) goodCol.add(true);
                else goodCol.add(false);
            }
            if(!goodRow.contains(false) || !goodCol.contains(false)) {
                player1.placePlayerItem(row, col);
            }
            else {
                //removes the bad location and repeats till done correctly
                System.out.println("bad spot, please choose another location");
                places.remove(pos);
                goodRow.clear();
                goodCol.clear();
                i--;
            }
            //end check
        }
        goodRow.clear();
        System.out.println("Please place your ships player 2");

        goodCol.clear();
        places.clear();
        for (int i = 0; i < 3; i++) {
            // ask player2 to set their ship; ask for row, col and ship symbol (optional) : 11 - !
            pos = getUserLocation(8);
            row = pos[0];
            col = pos[1];
            places.add(pos);
            //begin check to make sure ships are not diagonal
            //check places of the ship
            int rowCheck = places.get(0)[0];
            int colCheck = places.get(0)[1];
            //checking the row
            for(int iPlace = 0; iPlace < places.size(); iPlace++) {
                if(places.get(iPlace)[0] == rowCheck) goodRow.add(true);
                else goodRow.add(false);
            }
            // checking the columns
            for(int iPlace = 0; iPlace < places.size(); iPlace++) {
                if(places.get(iPlace)[1] == rowCheck) goodCol.add(true);
                else goodCol.add(false);
            }
            if(!goodRow.contains(false) || !goodCol.contains(false)) {
                player2.placePlayerItem(row, col);
            }
            else {
                //removes the bad location and repeats till done correctly
                System.out.println("bad spot, please choose another location");
                places.remove(pos);
                goodRow.clear();
                goodCol.clear();
                i--;
            }
            //end check
        }
        boolean gameOver = false;
            Player currentPlayer = new Player();
            Player opponentPlayer = new Player();
            currentPlayer = player1;
            opponentPlayer = player2;

            while (gameOver != true) { //


                //ask current player for hit position (row, col)
                System.out.println("Player 1 please select attack");
                pos = getUserLocation(8);
                row = pos[0];
                col = pos[1];
                player1.showGB('-', 'x');

                // get the other player's item at their own board
                char item = opponentPlayer.getPlayerItem(row, col);
                char hom = currentPlayer.playerHitOrMiss(row, col, opponentPlayer);

                if (hom == 'H') {
                    opponentPlayer.playerHitOrMiss(row, col, opponentPlayer);
                    System.out.println("Hit, go again!");
                    player1.showGB('-', '!');

                    if(opponentPlayer.CheckIfHitAllShips()){
                        gameOver = true;
                    }
                    continue;


                    // logic to check who the current player (currentPlayer) is; print out playerX wins
                } else if (hom == 'M') {
                    opponentPlayer.playerHitOrMiss(row, col, opponentPlayer);
                    System.out.println("Miss, next player!");
                    Player temp = currentPlayer;
                    currentPlayer = opponentPlayer;
                    opponentPlayer = temp;
                }
                player1.showGB('-', '!');
            }
        }
    }
//}

