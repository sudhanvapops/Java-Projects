import java.util.Scanner;

public class CeaserCypher {

    public static String Cypher(char[] alphabets) {

        Scanner sc = new Scanner(System.in);

        String cypherString = "";

        System.out.println("Enter the String To Cypher: ");
        String userString = sc.nextLine();

        System.out.print("Enter the number of shift want to Perform: ");
        int shift = sc.nextInt();

        userString = userString.toLowerCase();
        char[] userStringArray = userString.toCharArray();
        for (char c : userStringArray) {

            for (int i = 0; i <= alphabets.length - 1; i++) {
                if (c == alphabets[i]) {
                    cypherString += alphabets[i + shift];
                    break;
                }
            }

        }

        sc.close();

        return cypherString;
    }

    public static void main(String[] args) {

        char[] alphabets = {
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
        };

        String cypherString = Cypher(alphabets);

        System.out.println("Cyphered Text: " + cypherString);

    }

}