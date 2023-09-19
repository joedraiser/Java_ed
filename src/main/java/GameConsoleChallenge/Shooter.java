package GameConsoleChallenge;

public class Shooter implements Player {
    private final String name;
    private int bullets = 6;

    Shooter(String name) {
        this.name=name;
    }
    @Override
    public String name() {
        return name;
    }

    public int getBullets() {
        return bullets;
    }

    public boolean shootAGun() {
        System.out.println("BANG");
        bullets--;
        return bullets == 0;
    }

    public boolean reload() {
        bullets = 6;
        System.out.println("RELOADED");
        return false;
    }

    public boolean checkAmmo() {
        System.out.printf("There are %d bullets in the gun%n", bullets);
        return false;
    }
}
