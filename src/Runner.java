import java.util.Scanner;
public class Runner {
    public static void main(String[] args) {
        String direction[] = {"down","right","left","up"};
        String directiontwo[] = {"down","left","right","up"};
        Player player = new Player();
        Computer computer = new Computer();
        Scanner sc = new Scanner(System.in);
        int axRandom = (int)(Math.random() * 4 + 0);
        int ayRandom = (int)(Math.random() * 4 + 0);
        int bxRandom = (int)(Math.random() * 4 + 5);
        int byRandom = (int)(Math.random() * 4 + 0);
        int cxRandom = (int)(Math.random() * 9 + 0);
        int cyRandom = (int)(Math.random() * 4 + 5);
        String Adirection;
        int DirectionSetterA = (int)(Math.random() *1  + 0);
         Adirection = direction[DirectionSetterA];
        String Bdirection;
         if(byRandom >  2){
             int DirectionSetterB = (int)(Math.random() *3  + 1);
             Bdirection = direction[DirectionSetterB];
         }else{
             int DirectionSetterB = (int)(Math.random() * 3 + 2);
             Bdirection = directiontwo[DirectionSetterB];
         }
        String Cdirection;
        if(cxRandom > 8 && cyRandom > 8){
            int DirectionSetterC = (int)(Math.random() *3  + 2);
            Cdirection =direction[DirectionSetterC];
        }else if(cyRandom > 8 && cxRandom < 7 && cxRandom > 1){
            int DirectionSetterC = (int)(Math.random() *3  + 1);
            Cdirection =direction[DirectionSetterC];
        }else if(cyRandom < 8 && cxRandom > 8){
            int DirectionSetterC = (int)(Math.random() *1  + 0);
            Cdirection =directiontwo[DirectionSetterC];
        }else {
            int DirectionSetterC = (int) (Math.random() * 3 + 1);
            Cdirection = direction[DirectionSetterC];
        }
        Battleships acomputer = new Battleships(ayRandom,axRandom,6,Adirection);
        Battleships bcomputer = new Battleships(byRandom,bxRandom,3,Bdirection);
        Battleships ccomputer = new Battleships(cyRandom,cxRandom,2,Cdirection);
        computer.getPlayingfield().placeships(acomputer);
        computer.getPlayingfield().placeships(bcomputer);
        computer.getPlayingfield().placeships(ccomputer);
        computer.getPlayingfield().printBoard();
        computer.getPlayingfield().attack(0,0);
        player.getPlayingfield().printBoard();
        System.out.println("Enter the x coordinate of your First Ship (size 5):");
        int alocationx = sc.nextInt();
        System.out.println("Enter the y coordinate of your (size 5):");
        int alocationy = sc.nextInt();
        System.out.println("Which direction should the body of your ship go?(size 5)");
        String adirection = sc.next();
        Battleships aplayer = new Battleships(alocationy,alocationx,6, adirection);
        player.getPlayingfield().placeships(aplayer);
        player.getPlayingfield().printBoard();
        System.out.println("Enter the x coordinate of your Ship(size 2):");
        int blocationx = sc.nextInt();
        System.out.println("Enter the y coordinate of your Ship(size 2):");
        int blocationy = sc.nextInt();
        System.out.println("Which direction should the body of your ship go(size 2)?");
        String bdirection = sc.next();
        Battleships bplayer = new Battleships(blocationy,blocationx,3, bdirection);
        player.getPlayingfield().placeships(bplayer);
        player.getPlayingfield().printBoard();
        System.out.println("Enter the x coordinate of your Ship(size 1):");
        int clocationx = sc.nextInt();
        System.out.println("Enter the y coordinate of your Ship(size 1):");
        int clocationy = sc.nextInt();
        System.out.println("Which direction should the body of your ship go(size 1)?");
        String cdirection = sc.next();
        Battleships cplayer = new Battleships(clocationy,clocationx,2, cdirection);
        player.getPlayingfield().placeships(cplayer);
        player.getPlayingfield().printBoard();
        computer.getPlayingfield().printBoard();
        while(true){
            System.out.println(computer.getPlayingfield().getAttacks());
            System.out.println("X coordinate of attack");
            int attacklX = sc.nextInt();
            System.out.println("Y coordinate of attack");
            int attackly = sc.nextInt();
            computer.getPlayingfield().attack(attacklX, attackly);
            System.out.println(computer.getPlayingfield().getAttacks());
            int attackComputerx = (int)(Math.random() * 9);
            int attackComputery = (int)(Math.random() * 9);
            player.getPlayingfield().attack(attackComputerx, attackComputery);
            player.getPlayingfield().printBoard();
            boolean x = player.getPlayingfield().checkWin();
            if(x == false){
                System.out.println("Congratulations You win");
                break;
            }
            boolean f = computer.getPlayingfield().checkWin();
            if(x == false){
                System.out.println("Oh no you lost the game");
                break;
            }
        }
    }
}
