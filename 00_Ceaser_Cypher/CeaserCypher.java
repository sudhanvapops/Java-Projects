import java.util.Scanner;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
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

    private static String handleEncryption() {
        String cypherString = Encrypt.Cypher(sc);
        System.out.println("\nCyphered Text: " + cypherString + "\n\n");
        copyToClipbord(cypherString);
        return cypherString;
    }

    private static String handleDecryption() {
        String decypherString = Decrypt.deCypher(sc);
        System.out.println("\nDeCyphered Text: " + decypherString + "\n\n");
        copyToClipbord(decypherString);
        return decypherString;
    }

    public static void main(String[] args) {

        while (true) {

            Display.display();
            System.out.print("Enter the Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            String copiedText = "";

            if (choice == 1) {
                copiedText = handleEncryption();
                System.out.println("\nText Copied: " + "( " + copiedText + " )");
            } else if (choice == 2) {
                copiedText = handleDecryption();
                System.out.println("\nText Copied: " + "( " + copiedText + " )");

            } else if (choice == 3) {
                Display.clearScreen();
                exitProgram();
            } else {
                System.out.println("Invalid Choice");
                System.exit(1);
            }

            System.out.println("Press Any Key To Continue....  ");

            try {
                System.in.read();
            } catch (IOException e) {
                System.out.println("IOException: " + e);
            }

        }
    }

}