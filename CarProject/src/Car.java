public class Car extends Thread {

    //ATRIBUTES//




    boolean OnOff;
    private String Rejestration;
    private String Model;
    private double VMax;
    private double ActualV;
    private double Weight;
    private double wheelSize;

    private double xd;
    private double yd;

    private Position Pos;
    private Gearbox Gb;
    private Engine Eng;

    public Gearbox getGb() {
        return Gb;
    }

    public Engine getEng() {
        return Eng;
    }

    private long delay;


    //CONSTRUCTOR//

    public Car(boolean onOff, String rejestration, String model,
               double VMax, double weight,
               double x, double y, double xd, double yd) {
        OnOff = onOff;
        Rejestration = rejestration;
        Model = model;
        this.VMax = VMax;
        wheelSize = 1;
        Weight = weight;
        Pos = new Position(x, y);
        Gb = new Gearbox("Skrzynia", 500, 3000, 1, 5);
        Eng = new Engine("Silnik", 800, 10000, true, 70, 20);
        ActualV = Gb.getActualPost()*Eng.getActualSpeed()*wheelSize;
        delay = 20;
        this.xd = xd;
        this.yd = yd;
        OnOff=true;
        start();

    }

    //GETTERS//

    public double getActualV() {
        return ActualV;
    }

    public double getVMax() {
        return VMax;
    }

    public Position getPos() {
        return Pos;
    }

    public String getRejestration() {
        return Rejestration;
    }

    public String getModel() {
        return Model;
    }

    public double getActualEngineSpeed(){
        return Eng.getActualSpeed();
    }

    public double getXd() {
        return xd;
    }

    public double getYd() {
        return yd;
    }

    //Setters

    public void setOnOff(boolean onOff) {
        OnOff = onOff;
    }

    public void setXd(double xd) {
        this.xd = xd;
    }

    public void setYd(double yd) {
        this.yd = yd;
    }



    //METHODS//

    public void UpdateActualV(){
        ActualV = Gb.getActualPost()*Eng.getActualSpeed()*wheelSize;
    }

    public void On() {
        OnOff = true;
    }
    public void Off() {
        OnOff = false;
    }

    public void SetTarget(double a, double b){
        xd = a;
        yd = b;
    }

    public void GoTo(double x_cordinate, double y_cordinate){
        Pos.setX(x_cordinate);
        Pos.setY(y_cordinate);

    }

    public String toString(){
        return this.getModel();
    }

    public void UpdatePosition(){

        //przesuwam samochód o deltaX deltaY
        if(Math.abs(Pos.getX()-xd)<1 && OnOff || Math.abs(Pos.getY()-yd)<1 && OnOff){
            Pos.setX(xd);
            Pos.setY(yd);
        }else {
            GoTo(
                    Pos.getX() + ActualV * delay * 0.001 * ((xd - Pos.getX()) / (Math.sqrt(Math.pow(xd - Pos.getX(), 2) + Math.pow(yd - Pos.getY(), 2)))),
                    Pos.getY() + ActualV * delay * 0.001 * ((yd - Pos.getY()) / (Math.sqrt(Math.pow(xd - Pos.getX(), 2) + Math.pow(yd - Pos.getY(), 2)))
                    ));

        }

    }

    //WATEK
    public void run() {
        while (true) {
            try {
                    UpdatePosition();
                    UpdateActualV();
                    Thread.sleep(delay);
                  //  System.out.println(OnOff);

            } catch (InterruptedException ex) {

            }
        }
    }
}
