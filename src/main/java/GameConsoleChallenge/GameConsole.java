package GameConsoleChallenge;

import java.util.Scanner;

public class GameConsole {
    private Game game;
    static Scanner scanner = new Scanner(System.in);

    GameConsole(Game game) {
        this.game = game;
    }

    public void addPlayer() {
        System.out.print("Please, provide a name: ");
        String name = scanner.nextLine();
        game.addPlayer(name);
    }

    public static void playGame() {

    }
}
