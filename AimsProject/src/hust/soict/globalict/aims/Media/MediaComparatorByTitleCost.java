package AimsProject.src.hust.soict.globalict.aims.Media;

import AimsProject.src.hust.soict.globalict.aims.Media.Media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media o1, Media o2) {
        String o1Title = o1.getTitle();
        String o2Title = o2.getTitle();
        if (o1Title.compareTo(o2Title) < 0){
            return 1;
        }
        else if (o1Title.compareTo(o2Title) == 0){
            if (o1.getCost() <= o2.getCost()) return 1;
            else return 0;
        }
        else {
            return 0;
        }
    }
}
