import java.util.Scanner;

public class CeaserCypher {

    public static String Cypher() {
        StringBuilder result = new StringBuilder();

        Scanner sc = new Scanner(System.in);

        System.out.println("\n\nEnter the String To Cypher: ");
        String userString = sc.nextLine();

        System.out.print("Enter the number of shift want to Perform: ");
        int shift = sc.nextInt();
        shift = shift % 26;

        for (char c : userString.toCharArray()) {

            if (c >= 'a' && c <= 'z') {
                char shifted = (char) ('a' + ((c - 'a' + shift) % 26));
                result.append(shifted);
            } else if (c >= 'A' && c <= 'Z') {
                char shifted = (char) ('A' + ((c - 'A' + shift) % 26));
                result.append(shifted);
            } else {
                result.append(c);
            }

        }

        sc.close();

        return result.toString();
    }

    public static String deCypher(){

        StringBuilder result = new StringBuilder();
        
        Scanner sc = new Scanner(System.in);

        System.out.println("\n\nEnter the String To DeCypher: ");
        String userString = sc.nextLine();

        System.out.print("Enter the number of shift want to Perform: ");
        int shift = sc.nextInt();
        shift = shift%26;

        for(char c : userString.toCharArray()){

            if (c >= 'a' && c <= 'z'){
                char shifted = (char)('a'+ ((c - 'a' - shift + 26)%26));
                result.append(shifted);
            }else if(c >= 'A' && c <= 'Z'){
                char shifted = (char)(('A' + (c - 'A' - shift + 26) % 26));
                result.append(shifted);
            }else{
                result.append(c);
            }
        }
        sc.close();
        return result.toString();
    }


    public static void display(){
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.out.println("Error clearing screen: " + e.getMessage());
        }

        System.out.println("\n=======================");
        System.out.println("Ceaser Cypher");
        System.out.println("""
                  _____
                 /     \\
                | () () |
                 \\  ^  /
                  |||||
                  |||||
                """);
        System.out.println("=======================");
        System.out.println("1. Cypher\n2. Decypher");
        System.out.println("=======================");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        display();

        System.out.print("Enter the Choice: ");
        int choice = sc.nextInt();

        if (choice == 1) {

            String cypherString = Cypher();
            System.out.println("\nCyphered Text: " + cypherString+"\n\n");

        } else if (choice == 2) {
            String decypherString = deCypher();
            System.out.println("\nDeCyphered Text: " + decypherString+"\n\n");

        } else {
            System.out.println("Invalid Choice");
            System.exit(1);
        }

        sc.close();
    }

}