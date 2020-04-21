public class Attack {private int x;
    private int y;
    public Attack(int xv, int yv, Board bb){
        xv = x;
        yv = y;
    }

    public void attack(Board b){

        if(b.board[x][y] == "s"){
            b.board[x][y] = "x";

        }else{
            b.board[x][y] = "o";
        }

    }



    public boolean checkAttack(){
        if(x < 10 && x >= 0 && y < 10 && y >= 0 ) {
            return true;
        }else{
            return false;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
