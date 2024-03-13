import javax.swing.JOptionPane;

public class secEq {
    private double a, b, c;
    public double test;
    
    public secEq(double a, double b, double c){
        this.a=a;
        this.b=b;
        this.c=c;
    }
    
    public void deltaSolve(){
        double delta=b*b-4*a*c;
        if(delta<0) 
            JOptionPane.showMessageDialog(null, "No solution");
        else if(delta==0)
            JOptionPane.showMessageDialog(null, "One solution x =" + -b/(2*a));
        else
            JOptionPane.showMessageDialog(null, "Two solution:\nx1 ="+ (-b+Math.sqrt(delta))/(2*a)+"\nx2 ="+ (-b+Math.sqrt(delta))/(2*a));

    }
}
