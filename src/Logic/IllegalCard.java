package Logic;

public class IllegalCard extends Exception{
    public IllegalCard(String str) {
        System.out.println(str);
    }

    public static void validValue(int value) throws IllegalCard {
        if (value < 1 || value > 13) throw new IllegalCard("Invalid Value");
    }
}
