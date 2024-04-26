package AimsProject.src.hust.soict.globalict.aims.Media;

import AimsProject.src.hust.soict.globalict.aims.Media.Media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    //o1 sau, o2 truoc
    @Override
    public int compare(Media o1, Media o2) {
        float o1Cost = o1.getCost();
        float o2Cost = o2.getCost();
        String o1Title = o1.getTitle();
        String o2Title = o2.getTitle();
        // check xem trc co > sau
        int costCompare = Double.compare(o2Cost, o1Cost);
        if (costCompare != 0){
            return costCompare;
        }
        return o1Title.compareTo(o2Title);
    }
}
