public class Engine extends Component{

    //

    private boolean run;
    private double maxSpeed;
    private double actualSpeed;

    //CONSTRUCTOR



    public Engine(String name, double weight, double price, boolean run, double maxSpeed, double actualSpeed) {
        super(name, weight, price);
        this.run = run;
        this.maxSpeed = maxSpeed;
        this.actualSpeed = actualSpeed;
    }

    //"setters"

    public void Run(){
        run = true;
    }
    public void shutDown(){
        run = false;
    }
    public void incrSpeed(double x){
        actualSpeed += x;
    }

    public void dcrSpeed(double x){
        actualSpeed -= x;
    }
    public void setActualSpeed(int x){actualSpeed=x;}

    //getters

    public double getActualSpeed() {
        return actualSpeed;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }
}
