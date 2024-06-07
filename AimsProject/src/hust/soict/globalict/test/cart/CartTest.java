package AimsProject.src.hust.soict.globalict.test.cart;
import AimsProject.src.hust.soict.globalict.aims.Media.Book;
import AimsProject.src.hust.soict.globalict.aims.cart.Cart;
import AimsProject.src.hust.soict.globalict.aims.Media.DigitalVideoDisc;
import AimsProject.src.hust.soict.globalict.aims.exception.PlayerException;

public class CartTest {
    public static void main(String[] args) throws PlayerException {
        Cart cart = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(2,"The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(3,"Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(1,"Aladin", "Animation", 18.99f);
        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3);
        Book book1 = new Book(10, "Lord of the Ring", "Fiction", 20.22f);
        book1.addAuthor("J.R.R Tolkien");
        cart.addMedia(book1);
        cart.printMedia();
    }
}
