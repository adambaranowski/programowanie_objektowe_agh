public class Clutch extends Component {
    private boolean Pulled = false;

    public void pull() {
        Pulled = true;
    }
    public void release(){
        Pulled = false;
    }

    public Clutch(String name, double weight, double price, boolean pulled) {
        super(name, weight, price);
        Pulled = pulled;
    }
}
