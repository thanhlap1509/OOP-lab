package AimsProject.src.hust.soict.globalict.aims.screen.manager;

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
        this.setLayout(new FlowLayout());
        JPanel holder = new JPanel();
        holder.setLayout(new GridLayout(0, 2, 0, 3));
        jlId = new JLabel("Enter an id: ");
        tfId = new TextField(30);
        holder.add(jlId);
        holder.add(tfId);
        jlTitle = new JLabel("Enter an title: ");
        jlTitle.setPreferredSize(new Dimension(1010 / 2 , 30));
        jlTitle.setHorizontalAlignment(JLabel.LEFT);
        tfTitle = new TextField(30);
        tfTitle.setPreferredSize(new Dimension(1010 / 2, 30));
        holder.add(jlTitle);
        holder.add(tfTitle);
        jlCategory = new JLabel("Enter a category: ");
        tfCategory = new TextField(30);
        holder.add(jlCategory);
        holder.add(tfCategory);
        jlCost = new JLabel("Enter the cost: ");
        tfCost = new TextField(30);
        holder.add(jlCost);
        holder.add(tfCost);
        jlAuthor = new JLabel("Enter the number of authors: ");
        tfAuthor = new TextField(30);
        holder.add(jlAuthor);
        holder.add(tfAuthor);
        this.add(holder);
    }
    public AddBookToStoreScreen(int num){
        this.setLayout(new FlowLayout());
        JPanel holder = new JPanel();
        holder.setLayout(new GridLayout(num, 2, 0, 3));
        alAuthorLabel = new ArrayList<>();
        alAuthortf = new ArrayList<>();
        for (int i = 0; i < num;i++){
            JLabel label = new JLabel("Enter author " + (i + 1) + " : ");
            label.setPreferredSize(new Dimension(1010/2, 30));
            label.setHorizontalAlignment(JLabel.LEFT);
            TextField tf = new TextField(30);
            alAuthorLabel.add(label);
            alAuthortf.add(tf);
            holder.add(label);
            holder.add(tf);
        }
        this.add(holder);
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
