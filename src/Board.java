public class Board {
    private Battleships ship;
    public String[][] board = new String[10][10];
    public Battleships[] shipLength;
    public int[] attacks = new int[100];
    public Board() {
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {

                board[row][col] = "_";
            }
        }

    }

    public void setShipLength(Battleships[] shipLength) {
        this.shipLength = shipLength;
    }

    public void placeships(Battleships s) {
        int p = s.getLength();
        int x = s.getPositionx();
        int y = s.getPositiony();
        String c = s.getDirection();
        int[] position = new int[p * 2];
        board[x][y] = "s";
        int positionCounter = 0;
        position[positionCounter] = x;
        positionCounter++;
        position[positionCounter] = y;
        positionCounter++;
        if (c.equals("down")) {

            for (int i = 0; i < p - 1; i++) {
                board[x++][y] = "s";
                position[positionCounter] = x;
                positionCounter++;
                position[positionCounter] = y;
                positionCounter++;
            }
        }
        if (c.equals("right")) {

            for (int i = 0; i < p - 1; i++) {
                board[x][y++] = "s";
                position[positionCounter] = x;
                positionCounter++;
                position[positionCounter] = y;
                positionCounter++;
            }

        }

        if (c.equals("up")) {

            for (int i = 0; i < p - 1; i++) {
                board[x--][y] = "s";
                position[positionCounter] = x;
                positionCounter++;
                position[positionCounter] = y;
                positionCounter++;
            }

        }
        if (c.equals("left")) {

            for (int i = 0; i < p - 1; i++) {
                board[x][y--] = "s";
                position[positionCounter] = x;
                positionCounter++;
                position[positionCounter] = y;
                positionCounter++;
            }
        }
        s.setPosition(position);
        Battleships[] ships = new Battleships[5];
        int shipcounter = 0;
        ships[shipcounter] = s;
        shipcounter++;
        setShipLength(ships);
    }

    public void printBoard() {
        System.out.println("Updated board:");
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {

                System.out.print(board[row][col] + " ");

            }
            System.out.print("\n");
        }


    }
    public boolean checkWin(){
        int ha = shipLength[0].getHealth();
        int hb = shipLength[1].getHealth();
        int hc = shipLength[2].getHealth();
        if(ha == 0 && hb == 0 && hc == 0){
            return false;
        }else{
            return true;
        }
    }
    public void attack(int x, int y) {

        if (board[x][y] == "s") {
            int attackcounter = 0;
            attacks[attackcounter] = x;
            attackcounter++;
            attacks[attackcounter] = y;
            attackcounter++;
            board[x][y] = "x";
            for (int i = 0; i < shipLength.length; i++) {
                int[] v = shipLength[i].getPosition();
                boolean t = false;
                for (int z = 0; z < v.length-1; z++) {
                    if (v[z] == x && v[z+1] == y) {
                        shipLength[i].loseHealth();
                        t = true;
                        break;
                    }
                    z++;
                }
                if(t == true){
                    break;
                }
            }
        } else {
            board[x][y] = "o";
            int attackcounter = 0;
            attacks[attackcounter] = x;
            attackcounter++;
            attacks[attackcounter] = y;
            attackcounter++;

        }

    }

    public int[] getAttacks() {
        return attacks;
    }
}


