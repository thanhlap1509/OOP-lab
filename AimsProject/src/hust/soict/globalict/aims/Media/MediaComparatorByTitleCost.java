package AimsProject.src.hust.soict.globalict.aims.Media;

import AimsProject.src.hust.soict.globalict.aims.Media.Media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    //o1 sau, o2 truoc
    @Override
    public int compare(Media o1, Media o2) {
        if (o1 == null || o2 == null) return -1;
        String o1Title = o1.getTitle();
        String o2Title = o2.getTitle();
        int titleCompare = o1Title.compareTo(o2Title);
        if (titleCompare != 0){
            return titleCompare;
        }
        // check xem truoc co lon hon sau
        return Double.compare(o2.getCost(), o1.getCost());
    }
}
