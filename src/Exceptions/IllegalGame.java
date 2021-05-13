package Exceptions;

public class IllegalGame extends Exception {
    public IllegalGame(String str) {
        System.out.println(str);
    }
}
