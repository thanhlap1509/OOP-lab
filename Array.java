import java.util.Scanner;
public class Array {
    public static void main(String[] args){
        System.out.print("Enter n: ");
        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        System.out.print("Enter the array: ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < n - 1; i++){
            for (int j = 0; j < n - i - 1;j++){
                if (a[j] > a[j + 1]){
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1]= temp;
                }
            }
        }
        int sum = 0;
        System.out.print("The array after sorting is: ");
        for (int i = 0; i < n; i++){
            sum += a[i];
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println("The sum of the array is : " + sum);
        System.out.println("The average value of the array is: " + (double)sum / n);
    }
}
