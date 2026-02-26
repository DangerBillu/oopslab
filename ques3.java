/*
3. To the already defined Student class, add the following methods:

  i. extractInitials(): A method that extracts the initials from the student's name. For example, if the student's name is "John Doe", this method would return "JD".
  ii. removeWhitespace(): A method that removes any whitespace characters from the student's name. For example, if the student's name is "John Doe", this method would transform it to "JohnDoe".
  iii. List all the student names containing a particular substring.
  iv. Sort the students alphabetically.
  
In a separate class that contains main(), read the students details from console input. After displaying the details of all the students, illustrate the use of the above methods.
*/

package lab6;
import java.util.*;

class Student {
    private String name;
    private int id;
    private double gpa;

    Student(String name, int id, double gpa) {
        this.name = name;
        this.id = id;
        this.gpa = gpa;
    }

    String getName() { return name; }
    int getId()      { return id; }
    double getGpa()  { return gpa; }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("GPA: " + gpa);
    }
}

class StudentMethods {
    private Student[] students;

    StudentMethods(Student[] students) {
        this.students = students;
    }

    String extractInitials(Student s) {
        String[] words = s.getName().trim().split(" ");
        String initials = "";
        for (String w : words) {
            initials += Character.toUpperCase(w.charAt(0));
        }
        return initials;
    }

    String removeWhitespace(Student s) {
        return s.getName().replaceAll(" ", "");
    }

    void searchBySubstring(String sub) {
        System.out.println("\nStudents with \"" + sub + "\" in their name:");
        boolean found = false;
        for (Student s : students) {
            if (s.getName().toLowerCase().contains(sub.toLowerCase())) {
                System.out.println("  " + s.getName());
                found = true;
            }
        }
        if (!found) System.out.println("  No matches found.");
    }

    void sortAlphabetically() {
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = 0; j < students.length - 1 - i; j++) {
                if (students[j].getName().compareToIgnoreCase(students[j+1].getName()) > 0) {
                    Student temp = students[j];
                    students[j] = students[j+1];
                    students[j+1] = temp;
                }
            }
        }
        System.out.println("\nStudents sorted alphabetically:");
        for (Student s : students) {
            System.out.println("  " + s.getName());
        }
    }

    void displayAll() {
        System.out.println("\nAll Students");
        for (Student s : students) {
            s.displayDetails();
            System.out.println("Initials: " + extractInitials(s));
            System.out.println("No Whitespace Name: " + removeWhitespace(s));
            System.out.println();
        }
    }
}

public class ques3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\n Student " + (i + 1) + "");
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            System.out.print("Enter GPA: ");
            double gpa = sc.nextDouble();
            sc.nextLine();
            students[i] = new Student(name, id, gpa);
        }

        StudentMethods sm = new StudentMethods(students);

        sm.displayAll();

        System.out.print("Enter substring to search in names: ");
        String sub = sc.nextLine();
        sm.searchBySubstring(sub);
        sm.sortAlphabetically();
    }
}
