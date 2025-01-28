public class Player {
    String initials;
    int score;

     Player(String initials, int score) {
        this.initials = initials;
        this.score = score;
    }

    @Override
    public String toString() {
         return initials + "\t" + score;
    }
}
