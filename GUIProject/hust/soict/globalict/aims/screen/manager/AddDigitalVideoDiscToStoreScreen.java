package GUIProject.hust.soict.globalict.aims.screen.manager;

import javax.swing.*;
import java.awt.*;

public class AddDigitalVideoDiscToStoreScreen extends JPanel {
    private JLabel jlTitle;
    private JLabel jlCategory;
    private JLabel jlCost;
    private JLabel jlDirector;
    private JLabel jlLength;
    private TextField tfTitle;
    private TextField tfCategory;
    private TextField tfCost;
    private TextField tfDirector;
    private TextField tfLength;
    public AddDigitalVideoDiscToStoreScreen(){
        this.setLayout(new GridLayout(0, 2, 0, 3));
        jlTitle = new JLabel("Enter an title: ");
        jlTitle.setPreferredSize(new Dimension(1010 / 2 , 200));
        jlTitle.setHorizontalAlignment(JLabel.LEFT);
        tfTitle = new TextField(5);
        tfTitle.setPreferredSize(new Dimension(1010 / 2, 200));
        this.add(jlTitle);
        this.add(tfTitle);
        jlCategory = new JLabel("Enter a category: ");
        tfCategory = new TextField(5);
        this.add(jlCategory);
        this.add(tfCategory);
        jlDirector = new JLabel("Enter the Director: ");
        tfDirector = new TextField(5);
        this.add(jlDirector);
        this.add(tfDirector);
        jlLength = new JLabel("Enter the Length: ");
        tfLength = new TextField(5);
        this.add(jlLength);
        this.add(tfLength);
        jlCost = new JLabel("Enter the cost: ");
        tfCost = new TextField(5);
        this.add(jlCost);
        this.add(tfCost);
    }
    public String getTitle(){
        return tfTitle.getText();
    }
    public String getCategory(){
        return tfCategory.getText();
    }
    public String getDirector(){
        return tfDirector.getText();
    }
    public int getLength(){
        return Integer.parseInt(tfLength.getText());
    }
    public float getCost(){return Float.parseFloat(tfCost.getText());}
}
