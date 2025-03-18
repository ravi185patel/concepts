package Java8Demo.interviewquestions;


import javax.print.Doc;
import java.util.*;
import java.util.stream.Collectors;

class Course {
    String name;

    Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Override equals and hashCode for proper grouping by Course object
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Course course = (Course) obj;
        return name.equals(course.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Student {
    String name;
    List<Course> courses;

    Student(String name, List<Course> courses) {
        this.name = name;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", courses=" + courses +
                '}';
    }
}

class Department {
    String name;

    Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Doctor {
    String name;
    Department department;

    Doctor(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                ", department=" + department +
                '}';
    }
}

public class StreamInterviewQ {
    public static void main(String[] args) {
        Department cardiology = new Department("Cardiology");
        Department neurology = new Department("Neurology");
        Department orthopedics = new Department("Orthopedics");

        // Sample list of doctors
        List<Doctor> doctors = Arrays.asList(
                new Doctor("Dr. Alice", cardiology),
                new Doctor("Dr. Bob", neurology),
                new Doctor("Dr. Charlie", cardiology),
                new Doctor("Dr. David", orthopedics),
                new Doctor("Dr. Eve", neurology),
                new Doctor("Dr. Frank", cardiology)
        );

        // Count number of doctors per department using Streams
        Map<String, Long> doctorCountByDepartment = doctors.stream()
                .collect(Collectors.groupingBy(
                        doctor -> doctor.getDepartment().getName(),
                        Collectors.counting()
                ));

        // Output the result
        doctorCountByDepartment.forEach((department, count) ->
                System.out.println(department + ": " + count + " doctor(s)")
        );

        // Group doctors by department (using the entire Department object)
        Map<Department, List<Doctor>> doctorsByDepartment = doctors.stream()
                .collect(Collectors.groupingBy(Doctor::getDepartment));

        // Output the result
        doctorsByDepartment.forEach((department, doctorsList) -> {
            System.out.println(department.getName() + ": ");
            doctorsList.forEach(doctor -> System.out.println("  " + doctor.getName()));
        });

        Map<Department,List<Doctor>> departmentListMap = doctors.stream()
                .map(doctor -> new AbstractMap.SimpleEntry<>(doctor.getDepartment(),doctor))
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toList())
                ));

        departmentListMap.forEach((Department, doctorList) -> {
            System.out.println(Department.getName() + ":- ");
            doctorList.forEach(doctor -> System.out.println(" -> " + doctor.getName()));
        });

        /*
          List of course list of students
         */

        Course math = new Course("Math");
        Course science = new Course("Science");
        Course history = new Course("History");

        // Sample students
        Student student1 = new Student("Alice", Arrays.asList(math, science));
        Student student2 = new Student("Bob", Arrays.asList(science, history));
        Student student3 = new Student("Charlie", Arrays.asList(math, history));

        List<Student> students = Arrays.asList(student1, student2, student3);

        // Group students by the courses they are enrolled in
        Map<Course, List<Student>> courseStudentsMap = students.stream()
                .flatMap(student -> student.getCourses().stream()
                        .map(course -> new AbstractMap.SimpleEntry<>(course, student)))
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toList())
                ));

        // Output the result
        courseStudentsMap.forEach((course, studentList) -> {
            System.out.println(course.getName() + ": ");
            studentList.forEach(student -> System.out.println("  " + student.getName()));
        });

        students.stream()
                .flatMap(student -> student.getCourses().stream()
                        .map(course -> new AbstractMap.SimpleEntry<>(course, student)))
                // convert single hashmap into multiple value->key map
                // List(map(math-> ravi),map(math->harsh))
                .forEach(obj -> System.out.println(obj.getKey()+" <> "+obj
                        .getValue().toString()));
    }
}
