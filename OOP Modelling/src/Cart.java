import java.util.List;

public class Cart {
    private List<Item> items;

    // Constructor
    public Cart(List<Item> items) {
        this.items = items;
    }

    // Getter and setter methods
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
