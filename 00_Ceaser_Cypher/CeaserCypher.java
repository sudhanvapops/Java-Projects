import java.util.Scanner;

public class CeaserCypher {

    public static void main(String[] args) {

        char[] alphabets = {
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
        };

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the String To Desphier: ");
        String userString = sc.nextLine();

        System.out.print("Enter the number of shift want to Perform: ");
        int shift = sc.nextInt();


        char[] userStringArray = userString.toCharArray();

        for (int i = 0; i <= userStringArray.length-1 ; i++) {
            System.out.print(userStringArray[i+shift]+" ");
        }



        sc.close();
    }

}