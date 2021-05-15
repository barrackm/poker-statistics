package Logic;

public class Player implements Comparable {
    public String name;
    private Hole hole;
    private double blind = 0;
    private double money;
    private double atRiskMoney = 0;
    private double roundBet = 0;
    private double handScore;
    private boolean sittingOut = false;

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
        atRiskMoney += amount;
        roundBet += amount;
    }

    public double winMoney(double amount) {
        money += amount;
        atRiskMoney = 0;
        return amount;
    }

    public double getRoundBet() {
        return roundBet;
    }

    public void setRoundBet(double roundBet) {
        this.roundBet = roundBet;
    }

    public void setHandScore(double handScore) {
        this.handScore = handScore;
    }

    public double getHandScore() {
        return handScore;
    }

    public double getAtRiskMoney() {
        return atRiskMoney;
    }

    public void setAtRiskMoney(double atRiskMoney) {
        this.atRiskMoney = atRiskMoney;
    }

    public void setSittingOut(boolean sittingOut) {
        this.sittingOut = sittingOut;
    }

    public boolean isSittingOut() {
        return sittingOut;
    }

    public double determineAction(double pot, double highestBet) {
        double bet = 0;
        System.out.println(this.name);
        double toCall = highestBet - roundBet;
        System.out.println(toCall + " to call");
        if (toCall == 0) {
            bet = 5;
        } else {
            bet = toCall;
        }
        betMoney(bet);
        return bet;
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
