package AimsProject.src.hust.soict.globalict.aims.Media;

import java.util.Comparator;

public abstract class Media{
    public static final Comparator<Media> COMPARATOR_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARATOR_BY_COST_TITLE = new MediaComparatorByCostTitle();
    private int id;
    private String title;
    private String category;
    private float cost;
    public void setId(int id){this.id = id;}

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    public boolean isMatch(String InputTitle){
        return this.getTitle().equals(InputTitle);
    }
    @Override
    public boolean equals(Object o){
        if (!(o instanceof Media)) return false;
        String objTitle = ((Media)o).getTitle();
        return (objTitle.equals(this.title));
    }

    public int getId() { return id;
    }
}
