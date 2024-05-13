package GUIProject.hust.soict.globalict.aims.screen.manager;

import AimsProject.src.hust.soict.globalict.aims.Media.*;
import AimsProject.src.hust.soict.globalict.aims.store.Store;

import java.awt.*;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JScrollPane;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;

public class StoreManagerScreen extends JFrame implements ActionListener {
    private Store store;
    private JPanel north;
    private JPanel center;
    private JPanel header;
    private JMenuBar menuBar;
    private JPanel storeItem;
    private JScrollPane scrollPane;
    private Container cp;
    private JButton button;
    private Book bookToAdd;
    private CompactDisc cdToAdd;
    public StoreManagerScreen(Store store){
        this.store = store;
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        north = createNorth();
        cp.add(north, BorderLayout.NORTH);
        center = createCenter();
        cp.add(center, BorderLayout.CENTER);

        button = new JButton();
        button.addActionListener(this);

        setTitle("Store");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1024, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public JPanel createNorth(){
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        menuBar = createMenuBar();
        north.add(menuBar);
        header = createHeader();
        north.add(header);
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
        createItemHolder();
        center.add(scrollPane);
        return center;
    }
    public void createItemHolder(){
        storeItem = new JPanel();
        storeItem.setLayout(new GridLayout(0, 3, 3, 3));
        ArrayList<Media> mediaInStore = store.getItemsInStore();
        if (!mediaInStore.isEmpty()){
            for (int i = 0; i < mediaInStore.size(); i++){
                MediaStore cell = new MediaStore(mediaInStore.get(i));
                storeItem.add(cell);
            }
        }
        createScrollPane(storeItem);
    }
    public void addNewMedia(){
        storeItem.add(new MediaStore(store.getItemsInStore().get(store.getItemsInStore().size() - 1)));
    }
    public void createScrollPane(JPanel panel){
        scrollPane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(1010, 450));
    }
    public static void main(String[] args){
        Store store = new Store();
        initSetup(store);
        new StoreManagerScreen(store);
    }
    public static void initSetup(Store store) {

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);


        Book book = new Book("The Valley of Fear", "Detective", 20.00f);
        book.addAuthor("Arthur Conan Doyle");
        Book book1 = new Book("A Living Remedy: A Memoir", "Biography", 202.00f);
        book1.addAuthor("Nicole Chung");
        Book book2 = new Book("On the Origin of Time: Stephen Hawking's Final Theory", "Science", 120.00f);
        book2.addAuthor("Thomas Hertog");
        store.addMedia(book);
        store.addMedia(book1);
        store.addMedia(book2);

        CompactDisc cd1 = new CompactDisc("30", "Music","Adele", 1500.98f);
        Track track1CD1 = new Track("All Night Parking (interlude)", 161);
        Track track2CD1 = new Track("To Be Loved", 403);
        Track track3CD1 = new Track("Woman Like Me", 300);
        cd1.addTrack(track1CD1);
        cd1.addTrack(track2CD1);
        cd1.addTrack(track3CD1);

        CompactDisc cd2 = new CompactDisc("The Gods We Can Touch", "Music","Aurora", 2000.22f);
        Track track1CD2 = new Track("Everything Matters", 180+34);
        Track track2CD2 = new Track("Blood in the Wine", 180+30);
        Track track3CD2 = new Track("Artemis", 60*2+39);
        cd2.addTrack(track1CD2);
        cd2.addTrack(track2CD2);
        cd2.addTrack(track3CD2);

        CompactDisc cd3 = new CompactDisc("Purpose", "Music","Justin Bieber", 1000.98f);
        Track track1CD3 = new Track("The Feeling", 4*60+5);
        Track track2CD3 = new Track("No Sense", 4*60+35);
        cd3.addTrack(track1CD3);
        cd3.addTrack(track2CD3);

        store.addMedia(cd1);
        store.addMedia(cd2);
        store.addMedia(cd3);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton){
            switch(((JButton) e.getSource()).getText()){
                case "Add DVD":
                    AddDigitalVideoDiscToStoreScreen dvd = (AddDigitalVideoDiscToStoreScreen) (scrollPane.getViewport().getComponents()[0]);
                    store.addMedia(new DigitalVideoDisc(dvd.getTitle(), dvd.getCategory(), dvd.getDirector(), dvd.getLength(), dvd.getCost()));
                    addNewMedia();
                    returnToViewStore();
                    break;
                case "Create Book":
                    AddBookToStoreScreen book = (AddBookToStoreScreen) (scrollPane.getViewport().getComponents()[0]);
                    bookToAdd = new Book(book.getId(), book.getTitle(), book.getCategory(), book.getCost());
                    center.removeAll();
                    createScrollPane(new AddBookToStoreScreen(book.getAuthorsNum()));
                    center.add(scrollPane);
                    button.setText("Add Book");
                    center.add(button);
                    center.revalidate();
                    center.repaint();
                    System.out.println("Book created");
                    break;
                case "Add Book":
                    AddBookToStoreScreen book_author = (AddBookToStoreScreen) (scrollPane.getViewport().getComponents()[0]);
                    ArrayList<TextField> authorName = book_author.getAuthorstf();
                    for (TextField tf : authorName){
                        bookToAdd.addAuthor(tf.getText());
                    }
                    store.addMedia(bookToAdd);
                    addNewMedia();
                    System.out.println("Authors added in book");
                    returnToViewStore();
                    break;
                case "Create CD":
                    AddCompactDiscToStoreScreen cd = (AddCompactDiscToStoreScreen) (scrollPane.getViewport().getComponents()[0]);
                    cdToAdd = new CompactDisc(cd.getId(), cd.getTitle(), cd.getCategory(), cd.getDirector(), cd.getLength(), cd.getCost(), cd.getArtist());
                    center.removeAll();
                    createScrollPane(new AddCompactDiscToStoreScreen(cd.getTrackNum()));
                    center.add(scrollPane);
                    button.setText("Add Tracks");
                    center.add(button);
                    center.revalidate();
                    center.repaint();
                    System.out.println("CD created");
                    break;
                case "Add Tracks":
                    AddCompactDiscToStoreScreen tracks = (AddCompactDiscToStoreScreen) (scrollPane.getViewport().getComponents()[0]);
                    ArrayList<TextField> tracksList = tracks.getTrackList();
                    for (int i = 0; i < tracksList.size();){
                        Track track = new Track(tracksList.get(i).getText(), Integer.parseInt(tracksList.get(i + 1).getText()));
                        cdToAdd.addTrack(track);
                        i += 2;
                    }
                    store.addMedia(cdToAdd);
                    addNewMedia();
                    System.out.println("Tracks added in cd");
                    returnToViewStore();
                    break;
            }
        }
        else{
            String text = ((JMenuItem) e.getSource()).getText();
            switch (text) {
                case "View store":
                    returnToViewStore();
                    break;
                case "Add Book":
                    center.removeAll();
                    //TODO: implement new center to add book
                    createScrollPane(new AddBookToStoreScreen());
                    center.add(scrollPane);
                    button.setText("Create Book");
                    center.add(button);
                    center.revalidate();
                    center.repaint();
                    System.out.println("Adding book");
                    break;
                case "Add CD":
                    center.removeAll();
                    //TODO: implement new center to add CD
                    createScrollPane(new AddCompactDiscToStoreScreen());
                    center.add(scrollPane);
                    button.setText("Create CD");
                    center.add(button);
                    center.revalidate();
                    center.repaint();
                    System.out.println("Adding CD");
                    break;
                case "Add DVD":
                    center.removeAll();
                    //TODO: implement new center to add DVD
                    createScrollPane(new AddDigitalVideoDiscToStoreScreen());
                    center.add(scrollPane);
                    button.setText("Add DVD");
                    center.add(button);
                    center.revalidate();
                    center.repaint();
                    System.out.println("Adding DVD");
                    break;
            }
        }
    }

    private void returnToViewStore() {
        center.removeAll();
        //remove all component and add view store screen
        createScrollPane(storeItem);
        center.add(scrollPane);
        center.revalidate();
        center.repaint();
        System.out.println("View store");
    }
}
