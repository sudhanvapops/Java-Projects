import java.util.Scanner;

public class CeaserCypher {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Display.display();

        System.out.print("Enter the Choice: ");
        int choice = sc.nextInt();

        if (choice == 1) {

            String cypherString = Encrypt.Cypher();
            System.out.println("\nCyphered Text: " + cypherString+"\n\n");

        } else if (choice == 2) {
            String decypherString = Decrypt.deCypher();
            System.out.println("\nDeCyphered Text: " + decypherString+"\n\n");

        } else {
            System.out.println("Invalid Choice");
            System.exit(1);
        }

        sc.close();
    }

}