import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();

        try (BufferedReader buffer = new BufferedReader(new FileReader("src\\scores.csv"))) {
            String line;
            while ((line = buffer.readLine()) != null) {
                String[] data = line.split(",");
                players.add(new Player(data[0], Integer.parseInt(data[1])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Initial High Scores:");
        displayHighScores(players);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter initials for the new player: ");
        String new_initials = scanner.nextLine();
        Player newPlayer = new Player(new_initials, players.get(8).score + 50000);

        players.add(newPlayer);

        players.sort((p1, p2) -> Integer.compare(p2.score, p1.score));

        players.remove(players.size() - 1);

        System.out.println("\nUpdated High Scores:");
        displayHighScores(players);
    }

    private static void displayHighScores(List<Player> players) {
        for (int i = 0; i < players.size(); i++) {
            System.out.println((i + 1) + ". " + players.get(i));
        }
    }
}