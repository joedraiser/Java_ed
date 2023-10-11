package TerminalOperations;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainChallenge {
    public static void main(String[] args) {
        Course pymc= new Course("PYMC", "Python Masterclass", 50);
        Course jmc= new Course("JMC", "Java Masterclass", 100);
        Course cgj= new Course("CGJ", "Creating Games in Java");
        Course test= new Course("test", "test");


        var studentList = Stream.generate(() -> Student.getRandomStudent(pymc, jmc, cgj))
                .limit(5000)
                .collect(Collectors.toList());

        var totalPercent = studentList.stream()
                .mapToDouble((s) -> s.getPercentComplete("JMC"))
                .boxed()
                .reduce((double)0, (r, v) -> r+v);

        var averagePercent =  totalPercent/studentList.size();
        Comparator<Student> comparatorPercentage = Comparator.comparing(s -> s.getPercentComplete("JMC"));

        studentList.stream()
                .filter(s -> s.getPercentComplete("JMC") > averagePercent*1.25)
                .sorted(comparatorPercentage)
                .limit(10)
                .peek(System.out::println)
                .forEach(s -> {
                    s.addCourse(pymc);
                    s.addCourse(test);
                });
        return;
    }
}
