// 672115011 Natthapoom Saengkaew
import java.io.*;
import java.util.*;

public class CSVSorter {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java CSVSorter -[n|f|l|s] [file path] [search name (optional)]");
            return;
        }

        Vector<Student> students = new Vector<>();

        try (Scanner scanner = new Scanner(new FileInputStream(args[1]))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("2115")) {
                    String[] tokens = line.split(",");
                    if (tokens.length >= 4) {
                        students.add(new Student(tokens[1].trim(), tokens[2].trim(), tokens[3].trim()));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
            return;
        }

        String command = args[0];
        switch (command) {
            case "-n":
                System.out.println("Sorting by Student ID:");
                quickSort(students, 0, students.size() - 1, "id");
                break;
            case "-f":
                System.out.println("Sorting by First Name:");
                quickSort(students, 0, students.size() - 1, "firstName");
                break;
            case "-l":
                System.out.println("Sorting by Last Name:");
                quickSort(students, 0, students.size() - 1, "lastName");
                break;
            case "-s":
                if (args.length < 3) {
                    System.out.println("Please provide a name to search for.");
                    return;
                }
                String searchName = args[2];
                searchByFirstName(students, searchName);
                return;
            default:
                System.out.println("Invalid command. Use -n, -f, -l, or -s.");
                return;
        }

        students.forEach(System.out::println);
    }

    private static void quickSort(Vector<Student> students, int low, int high, String sortBy) {
        if (low < high) {
            int pi = partition(students, low, high, sortBy);
            quickSort(students, low, pi - 1, sortBy);
            quickSort(students, pi + 1, high, sortBy);
        }
    }

    private static int partition(Vector<Student> students, int low, int high, String sortBy) {
        Student pivot = students.get(high);
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (compareStudents(students.get(j), pivot, sortBy) <= 0) {
                i++;
                swap(students, i, j);
            }
        }
        swap(students, i + 1, high);
        return i + 1;
    }

    private static void swap(Vector<Student> students, int i, int j) {
        Student temp = students.get(i);
        students.set(i, students.get(j));
        students.set(j, temp);
    }

    private static int compareStudents(Student s1, Student s2, String sortBy) {
        switch (sortBy) {
            case "id":
                return s1.getStudentID().compareTo(s2.getStudentID());
            case "firstName":
                return s1.getFirstName().compareTo(s2.getFirstName());
            case "lastName":
                return s1.getLastName().compareTo(s2.getLastName());
            default:
                return 0;
        }
    }

    private static void searchByFirstName(Vector<Student> students, String searchName) {
        boolean found = false;
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (searchName.equalsIgnoreCase(student.getFirstName().trim())) {
                System.out.println("Found at index " + i + ": " + student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No student found with the first name: " + searchName);
        }
    }
}

class Student {
    private String studentID;
    private String firstName;
    private String lastName;

    public Student(String studentID, String firstName, String lastName) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return studentID + " " + firstName + " " + lastName;
    }
}