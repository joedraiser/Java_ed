package GameConsoleChallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Game<T extends Player> {
    public Game(String gameName) {
        this.gameName = gameName;
        standardActions.put("Q", new GameAction('Q', "Quit Game", this::quitGame));
        standardActions.put("P", new GameAction('P', "Print player data", this::printPlayer));
    }

    protected String gameName;
    protected List<T> players = new ArrayList<>();
    protected Map<String, GameAction> standardActions = new HashMap<>();

    public abstract T createNewPlayer(String name);
    public abstract Map<String, GameAction> getGameActions();

    public int addPlayer(String name) {
        players.add(createNewPlayer(name));
        return players.size()-1;
    }

    public boolean executeGameAction(int player, GameAction action) {
        return action.action().test(player);
    }

    public boolean printPlayer(int player) {

        System.out.printf("Player name: %s", players.get(player).name());
        return false;
    }

    public boolean quitGame(int player) {
        System.out.println("See ya");
        return true;
    }
}
