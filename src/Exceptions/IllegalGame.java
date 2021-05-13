package Exceptions;

public class IllegalGame extends Throwable {
    public IllegalGame(String str) {
        System.out.println(str);
    }
}
