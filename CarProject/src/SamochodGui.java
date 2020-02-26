import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedList;

public class SamochodGui {
    private JPanel pan;
    private JTextField Modeltxt;
    private JTextField Geartxt;
    private JTextField Rejestrationtxt;
    private JTextField Speedtxt;
    private JTextField Rmptxt;
    private JTextField EngineNametxt;
    private JTextField GearboxNametxt;
    private JButton zwiekszObrotyButton;
    private JButton zmniejszObrotyButton;
    private JButton zwiększBiegButton;
    private JButton zmniejszBiegButton;
    private JButton jedzButton;
    private JButton stopButton;
    private JTextField textAktX;
    private JTextField textAktY;
    private JTextField textJedzdoX;
    private JTextField textJedzDoY;
    private JLabel carIcon;
    private JPanel mapaSamochodu;
    private JComboBox cb;
    private JButton addCarButton;
    private JButton Remove;

    Car car = new Car(true,"KR1234", "Volvo",
            125, 0, 0, 0, 110,110);
    Car car1 = new Car(true,"KR1784", "Subaru",
            125, 0, 0, 0, 50,130);

    public JComboBox getCb() {
        return cb;
    }

    public SamochodGui() {

        cb.addItem(car);
        cb.addItem(car1);




        Timer timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Refresh();
            }
        });


        zwiekszObrotyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(car.getEng().getActualSpeed()<100 ){
                    car.getEng().incrSpeed(10);
                }
                Refresh();
            }
        });
        zmniejszObrotyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(car.getEng().getActualSpeed()>0){
                    car.getEng().dcrSpeed(10);
                }

                Refresh();
            }
        });
        zwiększBiegButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(car.getGb().getActualGear()<5){
                    car.getGb().incrGear(1);
                }
                Refresh();
            }
        });
        zmniejszBiegButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(car.getGb().getActualGear()>-1){
                    car.getGb().dcrGear(1);
                }

                Refresh();
            }
        });

        Refresh();
        jedzButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                car.OnOff=true;
                car.getEng().setActualSpeed(20);
               // System.out.println(car.OnOff);
            }
        });
        //stopButton.addActionListener(new ActionListener() {
          //  @Override
            //public void actionPerformed(ActionEvent actionEvent) {

            //}
        //});
        mapaSamochodu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                car.setXd(e.getX());
                car.setYd(e.getY());
                //car.getPos().setY(e.getY());
            }
        });
        timer.setInitialDelay(500);
        timer.start();
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
               // car.suspend();

                car.getEng().setActualSpeed(0);
            }
        });
        SamochodGui samochodGui_this = this;
        addCarButton.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent actionEvent) {
                NewCarGui newCarGui = new NewCarGui(samochodGui_this);
                //String[] args = new String[2];
                //newCarGui.main(args);
            }
        });
        cb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                car = (Car) cb.getSelectedItem();
            }
        });

        Remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(cb.getItemCount()!=1){
                    cb.removeItem((Car)car);}

                else{
                    System.out.println("chcesz usunac ostatni samochod!!!");
                }
            }
        });
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
               // car.OnOff=false;
                car.getEng().setActualSpeed(0);
               // System.out.println(car.OnOff);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("SamochodGui");
        frame.setContentPane(new SamochodGui().pan);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }

    public void Refresh(){

        Speedtxt.setText(Double.toString(car.getActualV()));
        Modeltxt.setText(car.getModel());
        Rejestrationtxt.setText(car.getRejestration());
        Rmptxt.setText(Double.toString(car.getEng().getActualSpeed()));
        Geartxt.setText(Integer.toString(car.getGb().getActualGear()));
        GearboxNametxt.setText(car.getGb().getName());
        EngineNametxt.setText(car.getEng().getName());
        textJedzdoX.setText(String.valueOf(car.getXd()));
        textJedzDoY.setText(String.valueOf(car.getYd()));
        textAktX.setText(String.valueOf(car.getPos().getX()));
        textAktY.setText(String.valueOf(car.getPos().getY()));
        carIcon.setLocation((int)car.getPos().getX(), (int)car.getPos().getY());

    }
}
