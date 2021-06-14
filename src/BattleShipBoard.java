public class BattleShipBoard {
    //gameboard class to create gameboard also created gameboard in player class
        private char [][] board = new char [8][8];

        BattleShipBoard() {

        }

        public void reset() {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    board[i][j] = '-';
                }
            }
        }

        public void print() {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    System.out.print(board[i][j]);
                    System.out.print(' ');
                }
                System.out.println("");
                System.out.println("---------");
            }
        }

        public void boardHitOrMiss(int rowPos, int colPos, char posHitOrMiss) { //  [i][j] : 'H'/'M'
            if(board[rowPos][colPos] == posHitOrMiss)
                print();
        }

    }



