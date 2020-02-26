public class Component {

    private String Name;
    private double Weight;
    private double Price;

    public double getPrice() {
        return Price;
    }

    public double getWeight() {
        return Weight;
    }

    public String getName() {
        return Name;
    }

    public Component(String name, double weight, double price) {
        Name = name;
        Weight = weight;
        Price = price;
    }

    public Component() {
    }
}
