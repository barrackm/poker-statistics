package Logic;

public class Player implements Comparable {
    public String name;
    private Hole hole;
    private double blind = 0;
    private double money;
    private double handScore;

    public Player(Game game, double money) {
        this.name = "Player " + (game.getPlayers().size() + 1);
        this.money = money;
    }

    public Player(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public void setHole(Hole hole) {
        this.hole = hole;
    }

    public Hole getHole() {
        return hole;
    }

    public void setBlind(double blind) {
        this.blind = blind;
    }

    public void betMoney(double amount) {
        money -= amount;
    }

    public void winMoney(double amount) {
        money += amount;
    }

    public void setHandScore(double handScore) {
        this.handScore = handScore;
    }

    public double getHandScore() {
        return handScore;
    }

    @Override
    public String toString() {
        return this.name + " " + this.money + " " + this.hole;
    }

    @Override
    public int compareTo(Object o) {
        Player player = (Player) o;
        return (int) (1000000000 * (player.getHandScore() - this.getHandScore()));
    }
}
