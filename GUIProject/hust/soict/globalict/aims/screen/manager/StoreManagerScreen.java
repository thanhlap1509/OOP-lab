package GUIProject.hust.soict.globalict.aims.screen.manager;

import AimsProject.src.hust.soict.globalict.aims.Media.Media;
import AimsProject.src.hust.soict.globalict.aims.store.Store;

import java.awt.*;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;

public class StoreManagerScreen extends JFrame implements ActionListener {
    private Store store;
    public StoreManagerScreen(Store store){
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Store");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public JPanel createNorth(){
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }
    public JMenuBar createMenuBar(){
        JMenuItem view = new JMenuItem("View store");
        JMenuItem addBook = new JMenuItem("Add Book");
        JMenuItem addCD = new JMenuItem("Add CD");
        JMenuItem addDVD = new JMenuItem("Add DVD");
        view.addActionListener(this);
        addBook.addActionListener(this);
        addCD.addActionListener(this);
        addDVD.addActionListener(this);

        JMenu menu = new JMenu("Options");
        menu.add(view);

        JMenu smUpdateStore = new JMenu("Update Store");
        smUpdateStore.add(addBook);
        smUpdateStore.add(addCD);
        smUpdateStore.add(addDVD);

        menu.add(smUpdateStore);
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }
    public JPanel createHeader(){
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }
    public JPanel createCenter(){
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 2, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        if (!mediaInStore.isEmpty()){
            for (int i = 0; i < 9; i++){
                MediaStore cell = new MediaStore(mediaInStore.get(i));
                center.add(cell);
            }
        }
        return center;
    }
    public static void main(String[] args){
        new StoreManagerScreen(new Store());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = ((JMenuItem)e.getSource()).getText();
        switch(text){
            case "View store":
                System.out.println("viewing store");break;
            case "Add Book":
                System.out.println("Adding book");break;
            case "Add CD":
                System.out.println("Adding CD");break;
            case "Add DVD":
                System.out.println("Adding DVD");break;
        }
    }
}
