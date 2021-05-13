package Logic;

public class Player {
    private String name;

    public Player(Game game) {
        this.name = "Player " + game.getPlayers().size();
    }

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
