package StarTrek;

import java.util.Scanner;

//Star Trek: Frontier Defense
public class startrek {
    public static char[][] sector;

    startrek() {
        sector = new char[10][10];
        initializeBoard();
    }
    public void initializeBoard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                sector[i][j] = '*';
            }
        }
    }
    public static String getSectorName() {
        int a = (int) (Math.random() * 10);
        String[] sectornames = new String[] { "Alfa Centauri", "Kyana", "Vega", "Empersa", "Acamar", "Vulcan",
                "Coridan", "Andoria", "Rigel", "Betazed" };
        return sectornames[a];
    }
    public static String getEmpireName(){
        int a = (int) (Math.random()* 10);
        String[] empirenames = new String[] {"Klingon", "Romulan", "Borg", "Cardassian", "Dominion", 
                "Tzenkethi", "Iconian", "Krenim", "Breen", "Waadwaur"};
        return empirenames[a];
    }

    public void printBoard() {
        int a = 0;
        System.out.println("   0 1 2 3 4 5 6 7 8 9");
        System.out.println("   -------------------");
        for (int i = 0; i < 10; i++) {
            System.out.print(a + "|");
            for (int j = 0; j < 10; j++) {
                System.out.print(" " + sector[i][j]);
            }
            a++;
            System.out.println();
        }
    }

    public static void exposition(String a, String b) {
        System.out.println();
        System.out.println("Incoming transmission from Admiral Quinn");
        System.out.println();
        System.out.println("Greetings Captain,");
        System.out.println();
        System.out.println("There has been a battle in " + a + " sector");
        System.out.println("The first reports came and they are not good");
        System.out.println("The " + b + " fleet has breached our defenses and communications with the " + a + " sector have been lost");
        System.out.println("There is currently unknown amount of " + b + " ships present in the sector");
        System.out.println("Your orders are to investigate the " + a + " sector and eliminate hostiles if necessary");
        System.out.println("I can't stress enough how important your mission is");
        System.out.println("Countless lives depend on you");
        System.out.println("Good luck");
        System.out.println("Quinn out");    
        System.out.println();
    }
    public static void expositioniflost(String a, String b, int c){
        System.out.println();
        if (c > 2){
            System.out.println("The defenses of the " + a + " sector have been overrun");
            System.out.println("The remaining " + c + " ships have defeated the planetary defenses");
            System.out.println("The " + a + " sector is now in " + b + "hands");
            System.out.println(b + " Empire is now ready to strike at the core systems of the United Federation of PLanets");
            System.out.println();
        }
        if (c == 2){
            System.out.println("Federation's fleet in the " + a + " sector have been defeated");
            System.out.println("The remaining " + c + " ships have launched a planetary assault");
            System.out.println("However the defenses have endured at great cost");
            System.out.println("The " + a + " sector remains in Federation hands");
            System.out.println();
        }
        if (c == 1){
            System.out.println("Federation's fleet in the " + a + " sector have been defeated");
            System.out.println("The remaining ship had launched a planetary assault");
            System.out.println("However the defenses have endured at great cost");
            System.out.println("The " + a + " sector remains in Federation hands");
            System.out.println();
        }
    }
    public static void expositionifwon(String s, String y){
        System.out.println();
        System.out.println("Incoming transmission from Admiral Quinn");
        System.out.println();
        System.out.println("Congratulations Captain");
        System.out.println("The " + y + " invasion of " + s + " sector have been stopped");
        System.out.println("Your bravery have saved billion of lives");
        System.out.println("You are a true example of what the Federation stands for");
        System.out.println("Quinn out");
        System.out.println();
    }
    public void placeStars() {
        int a = 10 + (int) (Math.random() * 10);
        for (int i = 0; i < a; i++) {
            int b = (int) (Math.random() * 10);
            int c = (int) (Math.random() * 10);
            sector[b][c] = 'S';
        }
    }

    public void placeEnt(int a, int b) {
        sector[a][b] = 'E';
    }

    public static int[] FindE() {
        int[] position = new int[2];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (sector[i][j] == 'E') {
                    position[0] = i;
                    position[1] = j;
                }
            }
        }
        return position;
    }

    public static void EntMovev(int a, enterprise e) {
        int[] position = FindE();
        sector[position[0]][position[1]] = '*';
        if (a >= 0){
            for (int i = 0; i < a; i++) {
                if (sector[position[0] + i][position[1]] != '*') {
                    e.hull = 0.0;
                } else {
                    sector[position[0] + a][position[1]] = 'E';
                }
            }
        }
        if (a < 0){
            a = Math.abs(a);
            for (int i = 0; i < a; i++){
                if (sector[position[0] - i][position[1]] != '*'){
                    e.hull = 0.0;
                } else{
                    sector[position[0] - a][position[1]] = 'E';
                }
            }
        }
    }
    public static void EntMoveh(int a, enterprise e) {
        int[] position = FindE();
        sector[position[0]][position[1]] = '*';
        if (a >= 0){
            for (int i = 0; i < a; i++){
                if (sector[position[0]][position[1] + i] != '*'){
                    e.hull = 0.0;
                } else{
                    sector[position[0]][position[1] + a] = 'E';
                }
            }
        }
        if (a < 0){
            a = Math.abs(a);
            for(int i = 0; i < a; i++){
                if (sector[position[0]][position[1] - i] != '*'){
                    e.hull = 0.0;
                } else{
                    sector[position[0]][position[1] - a] = 'E';
                }
            }
        }
    }

    public static void Eshoot(int a, int b) {
        int accuracy = (int) (Math.random() * 10);
        if (accuracy > 2 & sector[a][b] == 'K') {
            kDestroyed(a, b);
            System.out.println("Enemy destroyed");
        } else {
            System.out.println("You missed");
        }
    }

    public static void kDestroyed(int a, int b) {
        sector[a][b] = '*';
    }

    public static void placeK(int a) {
        for (int i = 0; i < a; i++) {
            int b = (int) (Math.random() * 10);
            int c = (int) (Math.random() * 10);
            if (sector[b][c] == '*') {
                sector[b][c] = 'K';
            } else {
                i--;
            }
        }
    }

    public static int countK() {
        int count = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (sector[i][j] == 'K') {
                    count++;
                }
            }
        }
        return count;
    }

    public static void removeK(int d) {
        for (int i = 0; i < d; i++) {
            int a = (int) (Math.random() * 10);
            int b = (int) (Math.random() * 10);
            if (sector[a][b] == 'K') {
                int c = countK();
                if (c >= d) {
                    sector[a][b] = '*';
                }
            } else {
                i--;
            }
        }
    }

    public static void Kmove(int a) {
        placeK(a);
        removeK(a);
    }

    public static void Kshoot(enterprise e) {
        int accuracy = (int) (Math.random() * 10);
        if (accuracy > 6) {
            Ehit(e);
        }
    }

    public static void Ehit(enterprise e) {
        if (e.hull > 0) {
            if (e.shields == 0) {
                e.hull--;
            }
            if (e.shields >= 1) {
                e.shields--;
            }
            if ((e.shields < 1) & (e.shields > 0)){
                e.hull = e.hull - (1 - e.shields);
                e.shields = 0;
            }
        }
        System.out.println("You are hit!");
    }

    public static boolean win() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (sector[i][j] == 'K') {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean lose(enterprise e) {
        if (e.hull <= 0) {
            return true;
        }
        return false;
    }

    public static void regenerateShields(enterprise e) {
        int plus = (int) (Math.random() * 10);
        if (e.shields < 2.0) {
            if (plus <= 3) {
                e.shields = e.shields;
            }
            if (plus <= 7) {
                e.shields = e.shields + 0.5;
            } else {
                e.shields++;
            }
        }
        if (e.shields >= 2) {
            e.shields = 2.0;
        }
    }

    public static void frsnast() {
        String s = getSectorName();
        String y = getEmpireName();
        exposition(s, y);
        Scanner sc = new Scanner(System.in);
        startrek game = new startrek();
        enterprise e = new enterprise();
        game.initializeBoard();
        game.placeStars();
        System.out.println("Place Enterprise ");
        int e1 = sc.nextInt();
        int e2 = sc.nextInt();
        System.out.println("How many enemies would you like? (It will spawn one more) ");
        game.placeEnt(e1, e2);
        int d = sc.nextInt();
        placeK(d + 1);
        game.printBoard();
        System.out.println();
        do {
            System.out.println("Shields: " + e.shields);
            System.out.println("Hull: " + e.hull);
            System.out.println("Shoot");
            int a = sc.nextInt();
            int b = sc.nextInt();
            Eshoot(a, b);
            int count = countK();
            for (int i = 0; i < count; i++){
                Kshoot(e);
            }
            System.out.println("Shields: " + e.shields);
            System.out.println("Hull: " + e.hull);
            game.printBoard();
            System.out.println();
            if (count > 0){
                System.out.println("0 = horizontally, 1 = vertically");
            int m = sc.nextInt();
            if (m == 0){
                int x = sc.nextInt();
                EntMoveh(x, e);
            }
            else if (m == 1){
                int x = sc.nextInt();
                EntMovev(x, e);
            }
            int w = countK();
            Kmove(w);
            regenerateShields(e);
            System.out.println("Shields: " + e.shields);
            System.out.println("Hull: " + e.hull);
            game.printBoard();
            System.out.println();
            }
        } while (!lose(e) & !win());
        boolean l = lose(e);
        boolean w = win();
        if (l == true){
            System.out.println("You lost");
            int dva = countK();
            expositioniflost(s, y, dva);
        }
        if (w == true){
            System.out.println("You win");
            expositionifwon(s, y);
        }
        System.out.println("Input one to play again");
        int stonks = sc.nextInt();
        if(stonks == 1){
            frsnast();
        }
        else{
            sc.close();
            System.out.println("Thank you for playing");
            System.out.println("See you next time");
        }
    }
    
    public static void main(String[] Args){
        frsnast();
    }
}