package GameConsoleChallenge;

import java.util.Map;

public class ShooterGame extends Game<Shooter>{
    public ShooterGame(String gameName) {
        super(gameName);

        standardActions.put("S", new GameAction('S', "Shoot a gun", this::shootAGun));
        standardActions.put("R", new GameAction('R', "Reload", this::reload));
        standardActions.put("C", new GameAction('C', "Check ammo", this::checkAmmo));
    }

    @Override
    public Shooter createNewPlayer(String name) {
        return new Shooter(name);
    }

    @Override
    public boolean printPlayer(int player) {
        super.printPlayer(player);
        System.out.printf(" , ammo: %1d%n", players.get(player).getBullets());
        return false;
    }

    @Override
    public Map<String, GameAction> getGameActions() {
        return standardActions;
    }

    public boolean shootAGun(int playerIndex) {
        return players.get(playerIndex).shootAGun();
    }

    public boolean reload(int playerIndex) {
        return players.get(playerIndex).reload();
    }

    public boolean checkAmmo(int playerIndex) {
        return players.get(playerIndex).checkAmmo();
    }
}
