package GameConsoleChallenge;

import java.util.function.Predicate;

public record GameAction(char key, String promt, Predicate<Integer> action) {
}
