import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);

        System.out.println("Welcome!");
        System.out.println();
        while(true) {
            String input = scnr.nextLine();

            if (input.equals("exit")){
                break;
            }
        }
    }
}
