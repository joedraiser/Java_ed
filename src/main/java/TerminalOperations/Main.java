package TerminalOperations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        Course pymc= new Course("PYMC", "Python Masterclass");
        Course jmc= new Course("JMC", "Java Masterclass");
        Course cmc= new Course("JMC", "C++ Masterclass");
        Course kmc= new Course("JMC", "Kotlin Masterclass");
//        Student tim = new Student("AU", 2019, 30, "M",
//                true, jmc, pymc);
//        System.out.println(tim);
//
//        tim.watchLecture("JMC", 10, 5, 2019);
//        tim.watchLecture("PYMC", 7, 7, 2020);
//        System.out.println(tim);

        List<Student> students = new ArrayList<>();
        Student.fillArrayWithStudents(students, Student::getRandomStudent, 100);

        long maleNFemaleCount = students.stream()
                .filter(s -> "MF".contains(s.getGender()))
                .peek(System.out::println)
                .count();

        System.out.println("male and female count: " + maleNFemaleCount);

        Predicate<Student> isLessThan30 = student -> student.getAge() < 30;
        Predicate<Student> isBetween30and60 = student -> 30 <= student.getAge() && student.getAge() <= 60;
        Predicate<Student> isMoreThan60 = student -> student.getAge() > 60;

        long lessThan30 = students.stream()
                .filter(isLessThan30)
                .count();

        long from30to60 = students.stream()
                .filter(isBetween30and60)
                .count();

        long moreThan60 = students.stream()
                .filter(isMoreThan60)
                .count();

        System.out.println("======================================");
        System.out.println("Ages:\n" +
                "Less than 30: " + lessThan30 +
                "\nFrom 30 til 60: " + from30to60 +
                "\nMore than 60: " + moreThan60);

        System.out.println("======================================");
        var it = students.listIterator();
        var ageStatistics = IntStream.iterate(it.next().getAge(), i -> it.hasNext(), i -> it.next().getAge())
//                .peek(System.out::println)
                .summaryStatistics();
        System.out.println("Age statistics: " + ageStatistics);

        System.out.println("======================================");
        Set<String> countries = new HashSet<>();
        students.stream()
                .forEach(student -> countries.add(student.getCountryCode()));
        countries.stream()
                .forEach(country -> System.out.print(country + " "));
        System.out.println();

        System.out.println("======================================");
        var stillActive = students.stream()
                .anyMatch(student -> student.getYearsSinceEnrolled() > 7);
        System.out.println("Are there still active students: " + stillActive);

        System.out.println("======================================");
        students.stream()
                .filter(student -> student.getYearsSinceEnrolled() > 7)
                .limit(5)
                .forEach(System.out::println);
    }
}
