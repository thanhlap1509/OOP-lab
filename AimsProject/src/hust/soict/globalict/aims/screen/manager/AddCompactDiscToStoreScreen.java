package AimsProject.src.hust.soict.globalict.aims.screen.manager;

import OtherProjects.Lab01.Array;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AddCompactDiscToStoreScreen extends JPanel {
    private JLabel jlId;
    private JLabel jlTitle;
    private JLabel jlCategory;
    private JLabel jlDirector;
    private JLabel jlLength;
    private JLabel jlCost;
    private JLabel jlArtist;
    private JLabel jlTrackNum;
    private TextField tfId;
    private TextField tfCategory;
    private TextField tfTitle;
    private TextField tfDirector;
    private TextField tfLength;
    private TextField tfCost;
    private TextField tfArtist;
    private TextField tfTrackNum;
    private ArrayList<TextField> alTracktf;
    public AddCompactDiscToStoreScreen(){
        this.setLayout(new FlowLayout());
        JPanel holder = new JPanel();
        holder.setLayout(new GridLayout(0, 2, 0, 3));
        jlId = new JLabel("Enter an id: ");
        tfId = new TextField(30);
        holder.add(jlId);
        holder.add(tfId);
        jlTitle = new JLabel("Enter an title: ");
        jlTitle.setPreferredSize(new Dimension(1010 / 2 , 50));
        jlTitle.setHorizontalAlignment(JLabel.LEFT);
        tfTitle = new TextField(30);
        tfTitle.setPreferredSize(new Dimension(1010 / 2, 50));
        holder.add(jlTitle);
        holder.add(tfTitle);
        jlCategory = new JLabel("Enter a category: ");
        tfCategory = new TextField(30);
        holder.add(jlCategory);
        holder.add(tfCategory);
        jlCost = new JLabel("Enter the cost: ");
        tfCost = new TextField(30);
        jlDirector = new JLabel("Enter the Director: ");
        tfDirector = new TextField(30);
        holder.add(jlDirector);
        holder.add(tfDirector);
        jlLength = new JLabel("Enter the Length: ");
        tfLength = new TextField(30);
        holder.add(jlLength);
        holder.add(tfLength);
        jlCost = new JLabel("Enter the cost: ");
        tfCost = new TextField(30);
        holder.add(jlCost);
        holder.add(tfCost);
        jlArtist = new JLabel("Enter the artist: ");
        tfArtist = new TextField(5);
        holder.add(jlArtist);
        holder.add(tfArtist);
        jlTrackNum = new JLabel("Enter the number of track: ");
        tfTrackNum = new TextField(30);
        holder.add(jlTrackNum);
        holder.add(tfTrackNum);
        this.add(holder);
    }
    public AddCompactDiscToStoreScreen(int trackNum){
        this.setLayout(new FlowLayout());
        JPanel holder = new JPanel();
        holder.setLayout(new GridLayout(0, 4, 0, 3));
        alTracktf = new ArrayList<>();
        for (int i = 0; i < trackNum; i++){
            JLabel Titlelabel = new JLabel("Enter title for track " + (i + 1) + " : ");
            Titlelabel.setPreferredSize(new Dimension(1010 / 4, 50));
            Titlelabel.setHorizontalAlignment(JLabel.LEFT);
            TextField Titletf = new TextField(13);
            JLabel Lengthlabel = new JLabel("Enter length for track " + (i + 1) + " : ");
            Lengthlabel.setHorizontalAlignment(JLabel.LEFT);
            TextField Lengthtf = new TextField(13);
            holder.add(Titlelabel);
            holder.add(Titletf);
            holder.add(Lengthlabel);
            holder.add(Lengthtf);
            alTracktf.add(Titletf);
            alTracktf.add(Lengthtf);
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
    public String getDirector(){
        return tfDirector.getText();
    }
    public int getLength(){
        return Integer.parseInt(tfLength.getText());
    }
    public String getArtist(){return tfArtist.getText();}
    public int getTrackNum(){return Integer.parseInt(tfTrackNum.getText());}
    public ArrayList<TextField> getTrackList(){return alTracktf;}

}
