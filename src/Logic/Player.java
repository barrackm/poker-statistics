package Logic;

public class Player {
    private String name;
    private Hole hole;
    private double blind = 0;
    private double money;

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

    public void setBlind(double blind) {
        this.blind = blind;
    }

    public void betMoney(double amount) {
        money -= amount;
    }

    public void winMoney(double amount) {
        money += amount;
    }

    @Override
    public String toString() {
        return this.name + " " + this.money + " " + this.hole;
    }
}
