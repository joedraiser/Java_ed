package StreamsChallenge;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainStreamsChallenge {
    public static void main(String[] args) {
        Course pymc= new Course("PYMC", "Python Masterclass", 61);
        Course jmc= new Course("JMC", "Java Masterclass");
        Course cpmc= new Course("CPMC", "C++ Masterclass", 45);
        Course kmc= new Course("KMC", "Kotlin Masterclass");

        var students = Stream.generate(() -> {
                    Student student;
                    do {
                        student = Student.getRandomStudent(pymc, jmc, cpmc, kmc);
                    }
                    while (student.getYearsSinceEnrolled() < 4);
                    return student;
                })
                .limit(10000)
                .toList();

        var engagements = students.stream()
                .flatMap(s -> s.getEngagementMap().values().stream())
                .collect(Collectors.groupingBy(CourseEngagement::getCourseCode, Collectors.counting()));

        var perStudentCourses= students.stream()
                .collect(Collectors.groupingBy(ы -> ы.getEngagementMap().size(), Collectors.counting()));

    }
}
