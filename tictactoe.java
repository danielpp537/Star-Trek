import java.util.Scanner;

public class tictactoe {
    static char[][] board;
    static char playermark;
    public static void main(String []args){
        osemnast();
    }
    public static void osemnast(){
        tictactoe game = new tictactoe();
        Scanner sc = new Scanner(System.in);
        game.initializeBoard();
        System.out.println("piskvorky");
        do{
            System.out.println("Current board layout");
            game.printBoard();
            int row;
            int col;
            do{
                System.out.println("Player " + game.getplayermark() + " enter the empty row and column");
                row = (sc.nextInt() - 1) % 3;
                col = (sc.nextInt() - 1) % 3;
            }
            while(!game.placeMark(row, col));
            game.ChangePlayer();
        }
        while(!game.win() && !game.isBoardFull());
        if (game.isBoardFull() == true){
            if (game.win() == false){
                System.out.println("tie");
            }
        }
        else{
            System.out.println("Current board layout");
            game.printBoard();
            game.ChangePlayer();
            System.out.println("Player " + game.getplayermark() + " wins!");
        }
        System.out.println("Input one to continue, zero to exit");
        int stoinks = sc.nextInt();
        if (stoinks == 1){
            osemnast();
        }
        else{
            System.out.println("Thank you for playing");
            System.out.println("See you next time");
            sc.close();
        }
    }
    public tictactoe() {
        board = new char[3][3];
        playermark = 'x';
        initializeBoard();
    }
    public void initializeBoard(){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                board[i][j] = '-';
            }
        }
    }
    public void printBoard(){
        int a = 1;
        System.out.println("    1   2   3  ");
        System.out.println("  -------------");
        for (int i = 0; i < 3; i++){
            System.out.print(a + " ");
            System.out.print("| ");
            a++;
            for (int j = 0; j < 3; j++){
               System.out.print(board[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println("  -------------");
    }
    public boolean isBoardFull(){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (board[i][j] == '-'){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean placeMark(int row, int col) {
        if ((row > 2) & (row < 0)) {
            return false;
        }
        if ((col > 2) & (col < 0)) {
            return false;
        }
        if (board[row][col] == '-') {
            board[row][col] = playermark;
            return true;
        }
        return false;
    }
    private boolean checkRowswin(){
        for (int i = 0; i < 3; i++){
            if (((board[i][0]) & (board[i][1]) & (board[i][2])) == 'x'){
                return true;
            }
            if (((board[i][0]) & (board[i][1]) & (board[i][2])) == 'o'){
                return true;
            }
        }
        return false;
    }   
    private boolean checkColswin(){
        for(int i = 0; i < 3; i++){
            if (((board[0][i]) & (board[1][i]) & (board[2][i])) == 'x'){
                return true;
            }
            if (((board[0][i]) & (board[1][i]) & (board[2][i])) == 'o'){
                return true;
            }
        }
        return false;
    }
    private boolean checkDiagonwin(){
        if (((board[0][0]) & (board[1][1]) & (board[2][2])) == 'x'){
            return true;
        }
        if (((board[0][0]) & (board[1][1]) & (board[2][2])) == 'o'){
            return true;
        }
        if (((board[0][2]) & (board[1][1]) & (board[2][0])) == 'x'){
            return true;
        }
        if (((board[0][2]) & (board[1][1]) & (board[2][0])) == 'o'){
            return true;
        }
        else{
            return false;
        }
    }
    boolean win(){
        boolean winRow = checkRowswin();
        boolean winCol = checkColswin();
        boolean winDia = checkDiagonwin();
        if (((winRow) | (winCol) | (winDia)) == true){
            return true;
        }
        return false;
    }
    public void ChangePlayer(){
        if (playermark == 'x'){
            playermark = 'o';
        }
        else{
            playermark = 'x';
        }
    }
    public char getplayermark(){
        return playermark;
    }
}