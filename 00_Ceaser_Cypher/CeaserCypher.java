import java.util.Scanner;

public class CeaserCypher {

    public static String Cypher() {
        StringBuilder result = new StringBuilder();

        Scanner sc = new Scanner(System.in);
        
        
        System.out.println("Enter the String To Cypher: ");
        String userString = sc.nextLine();
        
        System.out.print("Enter the number of shift want to Perform: ");
        int shift = sc.nextInt();
        shift = shift % 26;


        for (char c : userString.toCharArray()) {

            if (c >= 'a' && c<= 'z'){
                char shifted = (char)('a' + (c - 'a' + shift) % 26);
                result.append(shifted);
            } else if(c>='A' && c <= 'Z'){
                char shifted = (char)('A'+ (c - 'A' + shift) % 26);
                result.append(shifted);
            } else{
                result.append(c);
            }

        }

        sc.close();

        return result.toString();
    }

    public static void main(String[] args) {

        String cypherString = Cypher();

        System.out.println("Cyphered Text: " + cypherString);

    }

}