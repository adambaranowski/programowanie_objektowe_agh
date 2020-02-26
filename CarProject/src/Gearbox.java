public class Gearbox extends Component {
    int actualGear;
    int gearNum;
    double actualPost;
    Clutch Cl;

    public Gearbox(String name, double weight, double price, int actualGear, int gearNum) {
        super(name, weight, price);
        this.actualGear = actualGear;
        this.gearNum = gearNum;
        switch (actualGear){
            case 0:
                actualPost = 0;
                break;
            case 1:
                actualPost = 1.0;
                break;
            case 2:
                actualPost = 1.3;
                break;
            case 3:
                actualPost = 1.7;
                break;
            case 4:
                actualPost = 2;
                break;
            case 5:
                actualPost = 4;
                break;
            case -1:
                actualPost = -1.5;
                break;
            default:
                actualPost = 1.0;
        }
        Cl = new Clutch("Sprzeglo", 10, 1000,false);
    }

    public double getActualPost() {
        return actualPost;
    }

    public void ChangePost(int gear){

        switch (gear){
            case 0:
                actualPost = 0;
                break;
            case 1:
                actualPost = 1.0;
                break;
            case 2:
                actualPost = 1.3;
                break;
            case 3:
                actualPost = 1.7;
                break;
            case 4:
                actualPost = 2;
                break;
            case 5:
                actualPost = 4;
                break;
            case -1:
                actualPost = -1.5;
                break;
            default:
               actualPost = 1.0;

    }
    }

    public int getActualGear(){
        return actualGear;
    }

    public void incrGear(int x){
        actualGear += x;
        ChangePost(actualGear);

    }
    public void dcrGear(int x){
        actualGear -= x;
        ChangePost(actualGear);
    }
}
