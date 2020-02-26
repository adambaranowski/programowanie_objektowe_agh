import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class NewCarGui extends JFrame {
    private JPanel panel1;
    private JButton dodaj;
    private JButton anuluj;
    private JTextField carModel;
    private JTextField carRejestration;


   NewCarGui(SamochodGui samochodGui){

        setContentPane(panel1);
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       Random random = new Random();

       dodaj.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent actionEvent) {
               Car car = new Car(true,carRejestration.getText(), carModel.getText(),
                       125, 0, random.nextDouble()*100, random.nextDouble()*100, random.nextDouble()*100,random.nextDouble()*100);
               samochodGui.getCb().addItem(car);
               dispose();


           }
       });
       anuluj.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent actionEvent) {
            dispose();
           }
       });
   }
}
