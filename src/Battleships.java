public class Battleships {
    private int length;
    private int positionx;
    private int positiony;
    static int Health;
    private String direction;
    private int[] position = new int[length * 2];
    public Battleships(int x, int y, int length, String direction){
        this.positionx = x;
        this.positiony = y;
        this.length = length;
        this.direction = direction;
        this.Health = length;
    }

    public int getLength() {
        return length;
    }

    public int getPositionx() {
        return positionx;
    }

    public int getPositiony() {
        return positiony;
    }

    public static int getHealth() {
        return Health;
    }
    public String getDirection() {
        return direction;
    }

    public int[] getPosition() {
        return this.position;
    }
    public void loseHealth(){
        Health--;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }
}

