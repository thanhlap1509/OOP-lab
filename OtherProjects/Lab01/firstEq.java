package OtherProjects.Lab01;

import javax.swing.JOptionPane;
public class firstEq {
    private double a;
    private double b;

    //constructor
    public firstEq(double a, double b){
        this.a = a;
        this.b=b;
    }
    public void printSol(){
        if(a==0){
            if(b==0)
                JOptionPane.showMessageDialog(null, "Infinite Solution");
            else
                JOptionPane.showMessageDialog(null, "No solution");
        }
        else
             JOptionPane.showMessageDialog(null, "the value of x is : " + String.format("%.4g%n", -b / a));
    }
}
