package Lab02;

public class Cart {
    private int qtyOrderded;
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if (this.qtyOrderded == MAX_NUMBERS_ORDERED){
            System.out.println("The cart is full and can not take in anymore order");
            return;
        }
        itemsOrdered[qtyOrderded] = disc;
        qtyOrderded++;
        System.out.println("The disc has been added");
    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        if (qtyOrderded == 0) {
            System.out.println("The list is empty and can not remove anymore item");
            return;
        }
        int has_item = 0;
        for (int i = 0; i < MAX_NUMBERS_ORDERED; i++){
            if (itemsOrdered[i] == disc){
                has_item = 1;
                for (int j = i; j < MAX_NUMBERS_ORDERED - 1;j++){
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[MAX_NUMBERS_ORDERED - 1] = null;
                qtyOrderded--;
                break;
            }
        }
        if (has_item == 1) {
            System.out.println("Item Removed Successfully");
        }
        else {
            System.out.println("There is no item with that description in the cart");
        }
    }
    public float totalCost(){
        float total = 0;
        for (DigitalVideoDisc disc : itemsOrdered){
            if (disc == null) continue;
            total += disc.getCost();
        }
        return total;
    }
}
