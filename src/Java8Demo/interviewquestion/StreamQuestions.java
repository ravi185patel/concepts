package Java8Demo.interviewquestion;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Department {
    String name;

    Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Doctor {
    String name;
    Department department;

    Doctor(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }
}

public class StreamQuestions {
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
    }

}
