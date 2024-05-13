package GUIProject.hust.soict.globalict.aims.screen.manager;

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
        jlArtist = new JLabel("Enter the artist: ");
        tfArtist = new TextField(5);
        this.add(jlArtist);
        this.add(tfArtist);
        jlTrackNum = new JLabel("Enter the number of track: ");
        tfTrackNum = new TextField(5);
        this.add(jlTrackNum);
        this.add(tfTrackNum);
    }
    public AddCompactDiscToStoreScreen(int trackNum){
        this.setLayout(new GridLayout(0, 4, 0, 3));
        alTracktf = new ArrayList<>();
        for (int i = 0; i < trackNum; i++){
            JLabel Titlelabel = new JLabel("Enter title for track " + (i + 1) + " : ");
            Titlelabel.setPreferredSize(new Dimension(1010 / 4, 100));
            Titlelabel.setHorizontalAlignment(JLabel.LEFT);
            TextField Titletf = new TextField(5);
            JLabel Lengthlabel = new JLabel("Enter length for track " + (i + 1) + " : ");
            Lengthlabel.setHorizontalAlignment(JLabel.LEFT);
            TextField Lengthtf = new TextField(5);
            this.add(Titlelabel);
            this.add(Titletf);
            this.add(Lengthlabel);
            this.add(Lengthtf);
            alTracktf.add(Titletf);
            alTracktf.add(Lengthtf);
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
