package AimsProject.src.hust.soict.globalict.aims.screen.manager;

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
        this.setLayout(new FlowLayout());
        JPanel holder = new JPanel();
        holder.setLayout(new GridLayout(0, 2, 3, 3));
        jlTitle = new JLabel("Enter an title: ");
        jlTitle.setPreferredSize(new Dimension(1010 / 2 , 30));
        jlTitle.setHorizontalAlignment(JLabel.LEFT);
        tfTitle = new TextField(5);
        tfTitle.setPreferredSize(new Dimension(1010 / 2, 30));
        holder.add(jlTitle);
        holder.add(tfTitle);
        jlCategory = new JLabel("Enter a category: ");
        tfCategory = new TextField(5);
        holder.add(jlCategory);
        holder.add(tfCategory);
        jlDirector = new JLabel("Enter the Director: ");
        tfDirector = new TextField(5);
        holder.add(jlDirector);
        holder.add(tfDirector);
        jlLength = new JLabel("Enter the Length: ");
        tfLength = new TextField(5);
        holder.add(jlLength);
        holder.add(tfLength);
        jlCost = new JLabel("Enter the cost: ");
        tfCost = new TextField(5);
        holder.add(jlCost);
        holder.add(tfCost);
        this.add(holder);
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
