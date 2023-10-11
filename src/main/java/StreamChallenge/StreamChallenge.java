package StreamChallenge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class StreamChallenge {
    public static void main(String[] args) {
        Stream<String> bStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
                .map(n -> "B: " + n);

        Stream<String> iStream = new HashSet<Integer>(Arrays.asList(new Integer[]{16, 17, 18, 19, 20, 21, 22, 23, 24 ,25, 26, 27, 28, 29, 30}))
                .stream()
                .map(n -> "I: " + n);

        Stream<String> nStream = Arrays.stream(new Integer[]{31, 32, 33, 34, 35, 36, 37, 38, 39 ,40, 41, 42, 43, 44, 45})
                .map(n -> "N: " + n);

        Stream<String> gStream = Stream.iterate(46, n -> n + 1)
                .limit(15)
                .map(n -> "G: " + n);

        AtomicInteger ordinal = new AtomicInteger(61);

        Stream<String> oStream = Stream.generate(() -> ordinal.getAndIncrement())
                .limit(15)
                .map(n -> "O: " + n);

        Stream.concat(Stream.concat(Stream.concat(Stream.concat(bStream, iStream), nStream), gStream), oStream)
                .forEach(System.out::println);
    }
}
