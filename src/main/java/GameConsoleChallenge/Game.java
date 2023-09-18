package GameConsoleChallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Game<T extends Player> {
    private String gameName;
    private List<T> playerList = new ArrayList<>();
    private Map<String, GameAction> standardActions = new HashMap<>();

    public abstract T createNewPlayer(String name);
    public abstract Map<String, GameAction> getGameActions(int playerIndex);

    public int addPlayer(String name) {
        playerList.add(createNewPlayer(name));
        return playerList.size();
    }

    
}
