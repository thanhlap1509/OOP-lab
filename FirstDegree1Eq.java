import javax.print.attribute.standard.JobMessageFromOperator;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

public class FirstDegree1Eq {
    public static void main(String[] args){
        String strA, strB;
        double a = 0;
        double b = 0;
        strA = JOptionPane.showInputDialog(null, "Please input a: ", "the value of a is: ", JOptionPane.INFORMATION_MESSAGE);
        strB = JOptionPane.showInputDialog(null, "Please input b: ", "the value of b is : ", JOptionPane.INFORMATION_MESSAGE);
        if (strA == null){
            JOptionPane.showMessageDialog(null, "number a is not define");
            System.exit(0);
        }
        try {
            a = Double.parseDouble(strA);
        } catch (NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "number a is not define");
            System.exit(0);
        }
        if (strB == null){
            JOptionPane.showMessageDialog(null, "number b is not define");
            System.exit(0);
        }
        try {
            b = Double.parseDouble(strB);
        }
        catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "number b is not define");
            System.exit(0);
        }
        String strNotification = "Your first-degree equation with one variable is ";
        strNotification += strA + "x + " + strB + " = 0\n";

        if (a == 0) {
            if (b == 0) {strNotification += "All x satisfies.";}
            else {strNotification += "No x satisfies.";}
        } else {
            double x = -b / a;
            strNotification += "Solution is " + x;
        }

        JOptionPane.showMessageDialog(null, strNotification,
                "First-degree one-variable solver", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
