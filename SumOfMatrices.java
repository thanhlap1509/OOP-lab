import java.util.Scanner;
public class SumOfMatrices {
    public static void main(String[] args){
        System.out.print("Enter size of the first matrix (row column): ");
        int r1, c1;
        Scanner scanner = new Scanner(System.in);
        r1 = scanner.nextInt();
        c1 = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the first matrix: ");
        int[][] a1 = new int[r1][c1];
        for (int i = 0; i < r1; i++){
            for (int j = 0; j < c1;j++){
                a1[i][j] = scanner.nextInt();
            }
            scanner.nextLine();
        }
        System.out.print("Enter size of the second matrix (row column): ");
        int r2, c2;
        r2 = scanner.nextInt();
        c2 = scanner.nextInt();
        scanner.nextLine();
        if (r1 == r2 && c1 == c2){
            System.out.println("Enter the first matrix: ");
            for (int i = 0; i < r2; i++){
                for (int j = 0; j < c2;j++){
                    int v = scanner.nextInt();
                    a1[i][j] += v;
                }
                scanner.nextLine();
            }
            System.out.println("The sum of the two matrices is: ");
            for (int i = 0; i < r1; i++){
                for (int j = 0; j < c1; j++){
                    System.out.print(a1[i][j] + " ");
                }
                System.out.println();
            }
        }
        else {
            System.out.println("The size of two matrices are invalid to compute the sum");
        }

    }

}
