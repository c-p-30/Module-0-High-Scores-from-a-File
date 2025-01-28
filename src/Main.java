import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("scores.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                players.add(new Player(data[0], Integer.parseInt(data[1])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Display all 10 high scores
        System.out.println("Initial High Scores:");
        displayHighScores(players);

        // Create a new player with a high score higher than #8 but lower than #9
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter initials for the new player: ");
        String new_initials = scanner.nextLine();
        Player newPlayer = new Player(new_initials, players.get(8).score + 50000);

        // Add the new player to the list
        players.add(newPlayer);

        // Sort the list by score in descending order
        players.sort((p1, p2) -> Integer.compare(p2.score, p1.score));

        // Drop the lowest score (the new #11)
        players.remove(players.size() - 1);

        // Re-display all 10 high scores
        System.out.println("\nUpdated High Scores:");
        displayHighScores(players);
    }

    private static void displayHighScores(List<Player> players) {
        for (int i = 0; i < players.size(); i++) {
            System.out.println((i + 1) + ". " + players.get(i));
        }
    }
}