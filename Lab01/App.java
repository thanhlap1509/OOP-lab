package Lab01;

import java.util.Scanner;
import javax.swing.JOptionPane;
public class App {
    public static void main(String[] args) {
        double a, b, c;
        firstEq p1;
        sysFirstEq p2;
        secEq p3;
        while(true){
            String choice = JOptionPane.showInputDialog(null, "Which problem you want to solve:\n1.First degree Equation\n2.System of first degree Equation\n3.Second degree equation\n4.Exit");
        switch(choice){
            case "1":
                try{
                    String p11 =JOptionPane.showInputDialog(null, "Enter a: ");
                    a = Double.parseDouble(p11);
                    String p12 =JOptionPane.showInputDialog(null, "Enter b: ");
                    b = Double.parseDouble(p12);
                    p1 = new firstEq(a, b);
                    p1.printSol();
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Please enter a number!");
                }
            break;
            case "2":
                try{String p21 =JOptionPane.showInputDialog(null, "Enter a1: ");
                double a1 = Double.parseDouble(p21);
                String p22 =JOptionPane.showInputDialog(null, "Enter b1: ");
                double b1 = Double.parseDouble(p22);
                String p23 =JOptionPane.showInputDialog(null, "Enter c1: ");
                double c1 = Double.parseDouble(p23);
                String p24 =JOptionPane.showInputDialog(null, "Enter a2: ");
                double a2 = Double.parseDouble(p24);
                String p25 =JOptionPane.showInputDialog(null, "Enter b2: ");
                double b2 = Double.parseDouble(p25);
                String p26 =JOptionPane.showInputDialog(null, "Enter c2: ");
                double c2 = Double.parseDouble(p26);
                p2 = new sysFirstEq(a1, b1, c1, a2, b2, c2);
                p2.solve();
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Please enter a number!");
            }
                
            break;
            case "3":
                try{String p31 =JOptionPane.showInputDialog(null, "Enter a: ");
                a = Double.parseDouble(p31);
                String p32 =JOptionPane.showInputDialog(null, "Enter b: ");
                b = Double.parseDouble(p32);
                String p33 =JOptionPane.showInputDialog(null, "Enter c: ");
                c = Double.parseDouble(p33);
                if(a==0){
                    p1 = new firstEq(b,c);
                    p1.printSol();
                }
                else{
                    p3 = new secEq(a,b,c);
                    p3.deltaSolve();
                }
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Please enter a number!");
            }
                break;
            case "4":
            return;
            default:
                JOptionPane.showMessageDialog(null,"Invalid Input! Please enter a value from 1 to 4.");

        }
        }
        
    }
}
