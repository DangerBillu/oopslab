/*
1. Write a menu driven program to do the following
  i. To check whether a string is palindrome or not
  ii. Write the string in an alphabetical order
  iii. Reverse the string
  iv. Concatenate the original string and the reversed string
*/
package lab6;
import java.util.*;

class Methods {
    private String rev = "";

    void checkPalindrome(String str) {
        rev = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            rev += str.charAt(i);
        }
        if (str.toLowerCase().equals(rev.toLowerCase())) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is NOT a palindrome.");
        }
    }

    void sortAlpha(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        System.out.println("Sorted string: " + new String(chars));
    }

    void reverse(String str) {
        rev = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            rev += str.charAt(i);
        }
        System.out.println("Reversed string: " + rev);
    }

    void concatenate(String str) {
    	reverse(str);
        System.out.println("Concatenated string: " + str.concat(rev));
    }
}

public class ques1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        Methods m = new Methods();
        int ch = 0;


        while (ch != 5) {
            System.out.println("\n1. Check palindrome");
            System.out.println("2. Sort alphabetically");
            System.out.println("3. Reverse string");
            System.out.println("4. Concatenate original and reversed string");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    m.checkPalindrome(str);
                    break;
                case 2:
                    m.sortAlpha(str);
                    break;
                case 3:
                    m.reverse(str);
                    break;
                case 4:
                    m.concatenate(str);
                    break;
                case 5:
                    System.out.println("Exited");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1-5.");
                    break;
            }
        }
        sc.close();
    }
}
