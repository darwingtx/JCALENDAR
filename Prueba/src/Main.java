import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.ZoneId;

public class Main {
    public static void main(String[] args) {

            JFrame frame = new JFrame("Seleccionar fecha");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 200);

            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new GridBagLayout());
            frame.add(mainPanel);

            GridBagConstraints constraints = new GridBagConstraints();

            JLabel label = new JLabel("Seleccione una fecha:");
            constraints.gridx = 0;
            constraints.gridy = 0;
            constraints.insets = new Insets(10, 10, 10, 10);
            mainPanel.add(label, constraints);

            JDateChooser fecha = new JDateChooser();
            constraints.gridx = 1;
            constraints.gridy = 0;
            constraints.insets = new Insets(10, 10, 10, 10);
            mainPanel.add(fecha, constraints);

            JButton button = new JButton("Guardar fecha");
            constraints.gridx = 1;
            constraints.gridy = 1;
            constraints.insets = new Insets(10, 10, 10, 10);
            mainPanel.add(button, constraints);

            button.addActionListener(e -> {
                java.util.Date fechaselect = fecha.getDate();
                if (fechaselect != null) {
                    System.out.println("Fecha seleccionada: " + fechaselect);
                    LocalDate localDate = LocalDate.ofInstant(fechaselect.toInstant(), ZoneId.systemDefault());
                    System.out.println("Fecha seleccionada como LocalDate: " + localDate);

                } else {
                    System.out.println("No se seleccionó ninguna fecha");
                }
            });

            frame.setVisible(true);

    }
}