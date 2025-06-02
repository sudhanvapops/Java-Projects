import java.util.Scanner;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

public class CeaserCypher {

    private static final Scanner sc = new Scanner(System.in);

    private static void exitProgram() {
        sc.close();
        System.out.println("Exiting Program...");
        System.exit(0);
    }

    private static void copyToClipbord(String text) {
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    private static void handleEncryption() {
        String cypherString = Encrypt.Cypher(sc);
        System.out.println("\nCyphered Text: " + cypherString + "\n\n");
        copyToClipbord(cypherString);
    }

    private static void handleDecryption() {
        String decypherString = Decrypt.deCypher(sc);
        System.out.println("\nDeCyphered Text: " + decypherString + "\n\n");
        copyToClipbord(decypherString);
    }

    public static void main(String[] args) {

        while (true) {
            
            Display.display();
            System.out.print("Enter the Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                handleEncryption();
            } else if (choice == 2) {
                handleDecryption();
            } else if (choice == 3) {
                exitProgram();
            } else {
                System.out.println("Invalid Choice");
                System.exit(1);
            }

            System.out.println("Do You want to continue (y/n): ");
            sc.nextLine();
        }
    }

}