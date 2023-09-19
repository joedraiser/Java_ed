package GameConsoleChallenge;

import java.util.Scanner;

public class GameConsole<T extends Game<? extends Player>> {
    private T game;
    static Scanner scanner = new Scanner(System.in);

    GameConsole(T game) {
        this.game = game;
    }

    public int addPlayer() {
        System.out.print("Please, provide a name: ");
        String name = scanner.nextLine();
        return game.addPlayer(name);
    }

    public void playGame(int playerIndex) {
        boolean done = false;
        while(!done) {
            System.out.println("Available actions: ");
            for(var key : game.getGameActions().keySet()) {
                System.out.printf("%s : %s%n", key, game.getGameActions().get(key).prompt());
            }
            System.out.println("-------------------------------------");
            System.out.print("Your input: ");
            String input = scanner.nextLine().toUpperCase().substring(0, 1);
            try {
                done = game.executeGameAction(playerIndex, game.getGameActions().get(input));
            }
            catch (NullPointerException e) {
                System.out.println("Action not found");
            }
        }
    }
}
