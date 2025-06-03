import java.util.Scanner;

public class Decrypt {

    
    public static String deCypher(Scanner sc) {

        StringBuilder result = new StringBuilder();

        System.out.println("\n\nEnter the String To DeCypher: ");
        String userString = sc.nextLine();

        System.out.print("Enter the number of shift want to Perform With Sign: ");
        int shift = sc.nextInt();
        sc.nextLine();
        
        shift = shift % 26;

        for (char c : userString.toCharArray()) {

            if (c >= 'a' && c <= 'z') {
                char shifted = (char) ('a' + ((c - 'a' + shift + 26) % 26));
                result.append(shifted);
            } else if (c >= 'A' && c <= 'Z') {
                char shifted = (char) (('A' + (c - 'A' + shift + 26) % 26));
                result.append(shifted);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

}
