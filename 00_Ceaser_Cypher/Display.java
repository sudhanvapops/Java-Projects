public class Display {
    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.out.println("Error clearing screen: " + e.getMessage());
        }
    }

    public static void display() {

        clearScreen();

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
        System.out.println("1. Cypher\n2. Decypher\n3. Exit Program");
        System.out.println("=======================");
    }
}
