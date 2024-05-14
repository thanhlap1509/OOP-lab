package AimsProject.src.hust.soict.globalict.aims.screen.manager;

import AimsProject.src.hust.soict.globalict.aims.Media.CompactDisc;
import AimsProject.src.hust.soict.globalict.aims.Media.DigitalVideoDisc;
import AimsProject.src.hust.soict.globalict.aims.Media.Media;
import AimsProject.src.hust.soict.globalict.aims.Media.Track;
import AimsProject.src.hust.soict.globalict.aims.Playable.Playable;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class MediaStore extends JPanel implements MouseListener {
    private Media media;
    private JButton playButton;
    public MediaStore(Media media){
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + "$");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        if (media instanceof Playable){
            playButton = new JButton("Play");
            container.add(playButton);
            playButton.addMouseListener(this);
        }
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);
        this.setPreferredSize(new Dimension(985 / 3, 590 / 3));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == playButton){
            String title = null;
            if (media instanceof CompactDisc) {
                title = "CD";
                JDialog dialog = new JDialog(new JFrame(), "Playing " + title, true);
                dialog.setLayout(new FlowLayout());
                JPanel motherPanel = new JPanel();
                motherPanel.setLayout(new FlowLayout());

                JPanel holder = new JPanel();
                holder.setLayout(new GridLayout(0, 1, 0, 0));

                JLabel label = new JLabel("Play CD " + media.getTitle() + " by " + ((CompactDisc)media).getArtist());
                label.setHorizontalAlignment(JLabel.LEFT);
                label.setVerticalAlignment(JLabel.TOP);
                holder.add(label);

                ArrayList<Track> trackList = ((CompactDisc) media).getTracks();
                for (int i = 0; i < trackList.size(); i++){
                    JLabel titleLabel = new JLabel("<html>Playing track: " + trackList.get(i).getTitle() + "<br>" + "Track Length: " + trackList.get(i).getLength() + "</html>");
                    titleLabel.setPreferredSize(new Dimension(370, 40));
                    titleLabel.setHorizontalAlignment(JLabel.LEFT);
                    titleLabel.setVerticalAlignment(JLabel.TOP);
                    holder.add(titleLabel);
                }
                motherPanel.add(holder);
                JScrollPane scrollpane = new JScrollPane(motherPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                scrollpane.setPreferredSize(new Dimension(360, 300));
                dialog.add(scrollpane);
                dialog.setSize(400, 400);
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            }
            else if (media instanceof DigitalVideoDisc) {
                title = "DVD";
                JDialog dialog = new JDialog(new JFrame(), "Playing " + title, true);
                dialog.setLayout(new FlowLayout());

                JLabel panel = new JLabel();
                if (((DigitalVideoDisc) media).getLength() > 0){
                    panel.setText("<html>Playing DVD: " + media.getTitle() + "<br>" + "DVD Length: " + ((DigitalVideoDisc) media).getLength() + "</html>");
                }
                else panel.setText("DVD " + media.getTitle() + " can not be play");
                panel.setPreferredSize(new Dimension(370, 50));
                panel.setHorizontalAlignment(JLabel.LEFT);
                dialog.add(panel);
                dialog.setSize(400, 400);
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
