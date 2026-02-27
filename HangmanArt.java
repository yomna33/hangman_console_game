public class HangmanArt {
    public static String hangman_art(int wrong_attempts) {

        switch(wrong_attempts) {
            
            case 0 -> {
                return """
                         ---
                        |   |
                            |
                            |
                            |
                            |
                        =========
                        """;
            }
            case 1 -> {
                return """
                         ---
                        |   |
                        O   |
                            |
                            |
                            |
                        =========
                        """;
            }
            case 2 -> {
                return """
                         ---
                        |   |
                        O   |
                        |   |
                            |
                            |
                        =========
                        """;
            }
            case 3 -> {
                return """
                         ---
                        |   |
                        O   |
                       /|   |
                            |
                            |
                        =========
                        """;
            }
            case 4 -> {
                return """
                         ---
                        |   |
                        O   |
                       /|\\  |
                            |
                            |
                        =========
                        """;
            }
            case 5 -> {
                return """
                         ---
                        |   |
                        O   |
                       /|\\  |
                       /    |
                            |
                        =========
                        """;
            }
            case 6 -> {
                return """
                         ---
                        |   |
                        O   |
                       /|\\  |
                       / \\  |
                            |
                        =========
                        """;
            }
            default -> {
                return "";
            }
        }
    }

    
}
