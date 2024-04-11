import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;
import java.awt.*;
import java.time.LocalDate;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Seleccionar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2, 10, 10));

        JYearChooser yearChooser = new JYearChooser();
        JMonthChooser mes = new JMonthChooser();

        panel.add(yearChooser);
        panel.add(mes);

        JButton button = new JButton("Obtener Año y mes");
        panel.add(button);

        button.addActionListener(e -> {
            int year = yearChooser.getYear();
            LocalDate fecha = LocalDate.of(year, mes.getMonth(), 1);


            JOptionPane.showMessageDialog(frame,
                    "\nAño: " + fecha.getYear()
                            +"\nMes: "+ fecha.getMonth(),
                    "Año y mes seleccionado",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}