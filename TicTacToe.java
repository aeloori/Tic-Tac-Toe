import java.util.Scanner;
public class TicTacToe
{
    static char board[][]=new char[3][3];
    static boolean exchange=true;
    static byte count=0;
    static int row=0;
    static int col=0;
    static boolean S=true;
    static boolean win=false;
    // static char winner=' ';

    public static void main(String [] args)
    {
        game();
    }    

    //game code starts
    public static void game()
    {
        char opt='Y';
        while(opt=='Y' || opt =='y')
        {
            Scanner sc=new Scanner(System.in);
            clearBoard();
            startPlay();
            System.out.println();
            System.out.println("Enter Y for Rematch or Press any key for exit");
            opt=sc.next().charAt(0);
        }
    }

    //game board gets resets here
    public static void clearBoard()
    {
        for(byte i=0;i<3;i++)
        {
            for(byte y=0;y<3;y++)
            board[i][y]=' ';
        }
            exchange=true;
            count=0;
            row=0;
            col=0;
            S=true;
            win=false;
            System.out.println();
            System.out.println("----------------------------------------------------");
            System.out.println("Game started");
    }

    //game starts here
    public static void startPlay()
    {
        Scanner sc=new Scanner(System.in);
        while (count<=9 && win==false )
        {
            if(exchange==true)
            {
                while(S==true && win ==false)
                {
                    System.out.println("Enter row number for Player 1");
                    row=sc.nextInt()-1;
                    System.out.println("Enter col number for Player 1");
                    col=sc.nextInt()-1;
                    if(board[row][col]==' ')
                    {
                        board[row][col]='X';  
                        count++;
                        exchange=false;
                        printBoard();
                        S=false;        
                        winChecker();      
                    }
                }
            }
            else if(win==false)
            {   
                while(S==false)
                {
                    System.out.println("Enter row number for player 2");
                    row=sc.nextInt()-1;
                    System.out.println("Enter col number for Player 2");
                    col=sc.nextInt()-1;
                    if(board[row][col]==' ')
                    {
                        S=true;
                        board[row][col]='O';
                        count++;
                        exchange=true;
                        printBoard();
                        winChecker();      
                    }

                }
            }
        }
    }
    public static void printBoard()
    {
        for(byte i=0;i<3;i++)
        {
            for(byte y=0;y<3;y++)
            {
                System.out.print("| "+board[i][y]+" |");
            }
            System.out.println();
        }
    }
    public static void winChecker()
    {

         if(board[0][0]==board[0][1] &&board[0][1] ==board[0][2] && board[0][2]!=' ')
         {
            win=true;
            System.out.println("Winner is player "+board[0][0]);
         }
         else if((board[1][0]==board[1][1] &&board[1][1] ==board[1][2] && board[1][2]!=' '))
         {
            win=true;
            System.out.println("Winner is player "+board[1][0]);
         }
        else if((board[2][0]==board[2][1] &&board[2][1] ==board[2][2] && board[2][2]!=' '))
         {
            win=true;
            System.out.println("Winner is player "+board[2][0]);
         }

         //vertical check
        else if((board[0][0]==board[1][0] &&board[1][0] ==board[2][0] && board[2][0]!=' '))
         {
            win=true;
            System.out.println("Winner is player "+board[0][0]);
         }
        else if((board[0][1]==board[1][1] &&board[1][1] ==board[2][1] && board[2][1]!=' '))
         {
            win=true;
            System.out.println("Winner is player "+board[0][1]);
         }
        else if((board[0][2]==board[1][2] &&board[1][2] ==board[2][2] && board[2][2]!=' '))
         {
            win=true;
            System.out.println("Winner is player "+board[0][2]);
         }

         //diagonal check
         else if((board[0][0]==board[1][1] &&board[1][1] ==board[2][2] && board[2][2]!=' '))
         {
            win=true;
            System.out.println("Winner is player "+board[0][0]);
         }
         else if((board[1][2]==board[1][1] &&board[1][1] ==board[2][1] && board[2][1]!=' '))
         {
            win=true;
            System.out.println("Winner is player "+board[2][2]);
         }
         else if(count==9)
         {
            win=true;
            System.out.println();
            System.out.println("Match is drawed");
         }
    }      
}