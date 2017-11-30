import java.util.Scanner;

public class hw4 {

    public static void main( String args[] ) {
        Scanner in = new Scanner(System.in);
        int userChoice;
        String inputString;
        boolean runProgram = true;
        SqlFunction sqlObject = new SqlFunction();

        while (runProgram) {
            System.out.println("Select an option:\n" +
                "0. Exit\n" +
                "1. Obtain Album title by Artist name\n" +
                "3. Obtain purchase history of customer\n" +
                "4. Update track price by track ID\n");
            userChoice = in.nextInt();
            in.nextLine();

            switch (userChoice) {
                case (0) :
                    System.out.println("Goodbye\n");
                    runProgram = false;                
                    break;

                case (1) :
                    System.out.println("Enter Artist name: ");
                    inputString = in.nextLine();
                    sqlObject.sqlFunction(inputString);
                    break;

                case (3) :

                    break;

                case (4) :

                    break;

                default:
                    System.out.println("Error: Please make a valid selection.\n");
                    break;
            }
        }
    }
}
