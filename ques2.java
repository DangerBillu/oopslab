/*
2. To the already defined Employee class, add the following string processing methods:
  i. formatEmployeeName(): A method that formats the employee's name by capitalizing the first letter of each word and converting the remaining letters to lowercase. For example, if the employee's name is "JOHN DOE", this method would transform it to "John Doe".
  ii. generateEmail(): A method that generates an email address for the employee based on their name. For example, if the employee's name is "John Doe", this method would generate an email address like jdoe@example.com.
Illustrate the above methods upon creating an array of Employee objects. The details of each Employee object must be read from the user and initialized using the parameterised constructor.
*/

package lab6;
import java.util.*;

class Employee {
    private String name;

    Employee(String name) {
        this.name = name;
    }

    String formatName() {
        String[] words = name.toLowerCase().split(" ");
        String formatted = "";
        for (String w : words) {
            formatted += Character.toUpperCase(w.charAt(0)) + w.substring(1) + " ";
        }
        return formatted.trim();
    }

    String generateEmail() {
        String[] parts = name.toLowerCase().split(" ");
        return parts[0].charAt(0) + parts[1] + "@example.com";
    }
}

public class ques2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine();

        Employee[] employees = new Employee[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter employee name: ");
            String name = sc.nextLine();
            employees[i] = new Employee(name);
        }

        System.out.println("\nEmployee Details");
        for (int i = 0; i < n; i++) {
            System.out.println("Formatted Name : " + employees[i].formatName());
            System.out.println("Generated Email: " + employees[i].generateEmail());
            System.out.println();
        }

        sc.close();
    }
}
