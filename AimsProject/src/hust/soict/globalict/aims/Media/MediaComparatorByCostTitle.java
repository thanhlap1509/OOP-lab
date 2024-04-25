package AimsProject.src.hust.soict.globalict.aims.Media;

import AimsProject.src.hust.soict.globalict.aims.Media.Media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media o1, Media o2) {
        float o1Cost = o1.getCost();
        float o2Cost = o2.getCost();
        String o1Title = o1.getTitle();
        String o2Title = o2.getTitle();
        if (o1Cost < o2Cost) return 1;
        else if (o1Cost == o2Cost){
            if (o1Title.compareTo(o2Title) <= 0) return 1;
            else return 0;
        }
        return 0;
    }
}
