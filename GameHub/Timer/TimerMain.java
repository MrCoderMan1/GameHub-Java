package Timer;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TimerMain{
    public void startTimer(){
        Timer timer = new Timer("Clock");
        Scanner scanner = new Scanner(System.in);
        boolean leave=false;
        timer.t.start();

        do {
            System.out.print("\n\nType 1 to display date or 2 to leave: ");
            try{
                byte input = scanner.nextByte();
                if(input!=1&&input!=2){throw new InputMismatchException();}

                if(input==2){leave=true;}

                if(input==1){
                    clearConsole();
                    System.out.println(timer.myDate);
                    try{
                        Thread.sleep(1000);
                    } catch(InterruptedException w){
                        return;
                    }
                }

            } catch(InputMismatchException e){scanner.close();return;}
        } while(leave==false);
        scanner.close();
        timer.t.interrupt();
    }
    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}   