package Lab01;
import javax.swing.JOptionPane;

public class CalculateNumber {
    public static void main(String[] args){
        String strnum1, strnum2;
        double num1 = 0, num2 = 0;
        do {
            try{
                strnum1 = JOptionPane.showInputDialog(null, "Please input the first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
                num1 = Double.parseDouble(strnum1);
            }
            catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Please enter a number!");
                continue;
            }
            break;
        } while (true);

        do {
            try{
                strnum2 = JOptionPane.showInputDialog(null, "Please input the second number : ", "Input the second number ", JOptionPane.INFORMATION_MESSAGE);
                num2 = Double.parseDouble(strnum2);
            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Please enter a number!");
                continue;
            }
            break;
        }while (true);
        double sum = num1 + num2;
        double different = num1 - num2;
        double product = num1 * num2;
        JOptionPane.showMessageDialog(null, sum, "Sum of two number is ", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, different, "Difference of two number is ", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, product, "Product of two number is ", JOptionPane.INFORMATION_MESSAGE);
        if (num2 == 0){
            JOptionPane.showMessageDialog(null, "The quotient reach infinity since num2 = 0", "Quotient of two number is ", JOptionPane.INFORMATION_MESSAGE);
        }
        else JOptionPane.showMessageDialog(null, num1 / num2, "Quotient of two number is ", JOptionPane.INFORMATION_MESSAGE);
    }

}
