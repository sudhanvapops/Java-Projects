public class Display {
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
}
