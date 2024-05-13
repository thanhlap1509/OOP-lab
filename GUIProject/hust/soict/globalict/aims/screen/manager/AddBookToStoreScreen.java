package GUIProject.hust.soict.globalict.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AddBookToStoreScreen extends JPanel{
    private JLabel jlId;
    private JLabel jlTitle;
    private JLabel jlCategory;
    private JLabel jlCost;
    private JLabel jlAuthor;
    private TextField tfId;
    private TextField tfTitle;
    private TextField tfCategory;
    private TextField tfCost;
    private TextField tfAuthor;
    private ArrayList<JLabel> alAuthorLabel;
    private ArrayList<TextField> alAuthortf;
    public AddBookToStoreScreen(){
        this.setLayout(new GridLayout(0, 2, 0, 3));
        jlId = new JLabel("Enter an id: ");
        tfId = new TextField(5);
        this.add(jlId);
        this.add(tfId);
        jlTitle = new JLabel("Enter an title: ");
        jlTitle.setPreferredSize(new Dimension(1010 / 2 , 100));
        jlTitle.setHorizontalAlignment(JLabel.LEFT);
        tfTitle = new TextField(5);
        tfTitle.setPreferredSize(new Dimension(1010 / 2, 100));
        this.add(jlTitle);
        this.add(tfTitle);
        jlCategory = new JLabel("Enter a category: ");
        tfCategory = new TextField(5);
        this.add(jlCategory);
        this.add(tfCategory);
        jlCost = new JLabel("Enter the cost: ");
        tfCost = new TextField(5);
        this.add(jlCost);
        this.add(tfCost);
        jlAuthor = new JLabel("Enter the number of authors: ");
        tfAuthor = new TextField(5);
        this.add(jlAuthor);
        this.add(tfAuthor);
    }
    public AddBookToStoreScreen(int num){
        this.setLayout(new GridLayout(num, 2, 0, 3));
        alAuthorLabel = new ArrayList<>();
        alAuthortf = new ArrayList<>();
        for (int i = 0; i < num;i++){
            JLabel label = new JLabel("Enter author " + (i + 1) + " : ");
            label.setPreferredSize(new Dimension(1010/ 2, 100));
            label.setHorizontalAlignment(JLabel.LEFT);
            TextField tf = new TextField(5);
            alAuthorLabel.add(label);
            alAuthortf.add(tf);
            this.add(label);
            this.add(tf);
        }
    }
    public int getId() {return Integer.parseInt(tfId.getText());}
    public String getTitle(){
        return tfTitle.getText();
    }
    public String getCategory(){
        return tfCategory.getText();
    }
    public float getCost(){
        return Float.parseFloat(tfCost.getText());
    }
    public int getAuthorsNum(){return Integer.parseInt(tfAuthor.getText());}
    public ArrayList<TextField> getAuthorstf(){
        return alAuthortf;
    }

}
