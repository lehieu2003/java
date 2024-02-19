import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of student: ");
        n = sc.nextInt();

        Student[] students = new Student[n];
        for (int i = 0; i < n; i++){
            System.out.println("Enter the information of the " + (i + 1) + " student:");
            sc.nextLine();
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter score: ");
            double score = sc.nextInt();
            students[i] = new Student(name,score);
        }

        for (int i = 0; i < n; i++){
            System.out.println(students[i].toString());
        }

        int countExcellent = 0;
        int countOk = 0;
        int countFailure = 0;
        int excellentTotal = 0;
        int okeTotal = 0;
        int failureTotal = 0;

        for (int i = 0; i < n; i++){
            if (students[i].getScore() > 89){
                countExcellent ++;
                excellentTotal += students[i].getScore();
            }else if (students[i].getScore() <= 89 && students[i].getScore() >= 60){
                countOk++;
                okeTotal += students[i].getScore();
            }else {
                countFailure++;
                failureTotal += students[i].getScore();
            }
        }
        System.out.println("The number of excellent students: " + countExcellent);
        System.out.println("The average score of excellent students: " + (double)(excellentTotal / countExcellent));

        System.out.println("The number of oke students: " + countOk);
        System.out.println("The average score of oke students: " + (double)(okeTotal / countOk));

        System.out.println("The number of failure students: " + countFailure);
        System.out.println("The average score of failure students: " + (double)(failureTotal / countFailure));
    }
}