package OtherProjects.Lab01;

import java.util.Scanner;
public class DayinMonth {
    public static int ValidateMonth(String month){
        return switch (month) {
            case "Jan.", "Jan", "1", "January" -> 1;
            case "Feb", "Feb.", "February", "2" -> 2;
            case "Mar", "Mar.", "March", "3" -> 3;
            case "Apr", "Apr.", "April", "4" -> 4;
            case "May.", "May", "5" -> 5;
            case "June", "June.", "Jun", "6" -> 6;
            case "July", "July.", "Jul", "7" -> 7;
            case "August", "Aug.", "Aug", "8" -> 8;
            case "September", "Sept.", "Sep", "9" -> 9;
            case "October", "Oct.", "Oct", "10" -> 10;
            case "November", "Nov.", "Nov", "11" -> 11;
            case "December", "Dec.", "Dec", "12" -> 12;
            default -> 0;
        };
    }
    public static int ValidateYear(String year){
        int y;
        try {
            y = Integer.parseInt(year);
        } catch (NumberFormatException nfe){
            return 0;
        }
        if (y < 1000) return 0;
        return y;
    }
    public static int Leap(int year){
        if (year % 4 == 0) {
            if (year % 100 == 0 && year % 400 != 0) return 0;
            return 1;
        }
        return 0;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String month;
        String year;
        int validmonth;
        int validyear;
        do {
            System.out.println("Enter a month: ");
            month = scanner.nextLine();
            validmonth = ValidateMonth(month);
            // i % 3 x 3 -> i % 3 x 3 + 3
        } while (validmonth == 0 );
        do {
            System.out.println("Enter a year: ");
            year = scanner.nextLine();
            validyear = ValidateYear(year);
        } while (validyear == 0);
        int leap = Leap(validyear);
        System.out.print("The number of day in the month is: ");
        switch (validmonth) {
            case 1, 3, 5, 7, 8, 10, 12:  System.out.println("31"); break;
            case 2: if (leap == 1) System.out.println("29"); else System.out.println("28"); break;
            default:
                System.out.println("30"); break;
        }
        scanner.close();
    }
}
