package share;

import java.util.Scanner;

public class Share {
    public static int inputNumber(Scanner sc,String msgEnter,String msgError){
        while(true){
            try{
                System.out.print(msgEnter);
                 int number= sc.nextInt();
                 sc.nextLine();
                 return number;
            }catch(Exception e){
                System.err.println(msgError);
                sc.nextLine();
            }
        }
    }
}
