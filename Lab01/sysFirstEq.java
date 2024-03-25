package Lab01;

import javax.swing.JOptionPane;

public class sysFirstEq {
    private double a1, b1, c1, a2, b2, c2;
    public sysFirstEq(double a, double b, double c, double d, double e, double f){
        a1 = a;
        b1 = b;
        c1 = c;
        a2 = d;
        b2 = e;
        c2 = f;
    }

    public void solve(){
        double D = a1*b2-a2*b1;
        double Dx = c1*b2-c2*b1;
        double Dy = a1*c2-a2*c1;
        if(D==0&&Dx==0&&Dy==0)
            JOptionPane.showMessageDialog(null, "Infinite Solution");
        else if(D==0&&Dx!=0&&Dy!=0)
            JOptionPane.showMessageDialog(null, "No Solution");
        else
            JOptionPane.showMessageDialog(null, "Solution:\nx ="+Dx/D+" y ="+Dy/D);
    }
}
