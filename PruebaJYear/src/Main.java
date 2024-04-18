import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;
import java.awt.*;
import java.time.LocalDate;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        // Crear un nuevo marco (ventana)
        JFrame frame = new JFrame("Seleccionar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configurar el cierre del programa cuando se cierra la ventana
        frame.setSize(500, 500); // Establecer el tamaño del marco

        // Crear un nuevo panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2, 10, 10)); // Establecer el diseño del panel como una cuadrícula

        // Crear componentes JYEAR Y JMONTH para seleccionar año y mes
        JYearChooser yearChooser = new JYearChooser();
        JMonthChooser mes = new JMonthChooser();

        // Agregar componentes al panel
        panel.add(yearChooser);
        panel.add(mes);

        // Crear un botón para obtener el año y el mes seleccionados
        JButton button = new JButton("Obtener Año y mes");
        panel.add(button);

        // Agregar un listener al botón para manejar eventos de clic
        button.addActionListener(e -> {
            // Obtener el año y el mes seleccionados
            int year = yearChooser.getYear();
            LocalDate fecha = LocalDate.of(year, mes.getMonth(), 1); // Crear un objeto LocalDate con el año y el mes seleccionados

            // Mostrar un cuadro de diálogo con el año y el mes seleccionados
            JOptionPane.showMessageDialog(frame,
                    "\nAño: " + fecha.getYear()
                            +"\nMes: "+ fecha.getMonth(),
                    "Año y mes seleccionado",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        // Agregar el panel al marco, ajustar el tamaño del marco y hacer visible el marco
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
