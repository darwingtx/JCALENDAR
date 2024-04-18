import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.ZoneId;

public class Main {
    public static void main(String[] args) {
        // Crear un nuevo marco (ventana)
        JFrame frame = new JFrame("Seleccionar fecha");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configurar el cierre del programa cuando se cierra la ventana
        frame.setSize(300, 200); // Establecer el tamaño del marco

        // Crear un nuevo panel principal con disposición GridBagLayout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        frame.add(mainPanel);

        // Configurar restricciones para los componentes dentro del panel
        GridBagConstraints constraints = new GridBagConstraints();

        // Crear y agregar una etiqueta al panel
        JLabel label = new JLabel("Seleccione una fecha:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(10, 10, 10, 10);
        mainPanel.add(label, constraints);

        // Crear y agregar un JDateChooser (selector de fecha) al panel
        JDateChooser fecha = new JDateChooser();
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.insets = new Insets(10, 10, 10, 10);
        mainPanel.add(fecha, constraints);

        // Crear y agregar un botón al panel
        JButton button = new JButton("Guardar fecha");
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.insets = new Insets(10, 10, 10, 10);
        mainPanel.add(button, constraints);

        // Agregar un listener al botón para manejar eventos de clic
        button.addActionListener(e -> {
            java.util.Date fechaselect = fecha.getDate(); // Obtener la fecha seleccionada del JDateChooser
            if (fechaselect != null) {
                // Imprimir la fecha seleccionada
                System.out.println("Fecha seleccionada: " + fechaselect);
                // Convertir la fecha seleccionada a LocalDate
                LocalDate localDate = LocalDate.ofInstant(fechaselect.toInstant(), ZoneId.systemDefault());
                // Imprimir la fecha seleccionada como LocalDate
                System.out.println("Fecha seleccionada como LocalDate: " + localDate);
            } else {
                // Imprimir si no se seleccionó ninguna fecha
                System.out.println("No se seleccionó ninguna fecha");
            }
        });

        // Hacer visible el marco
        frame.setVisible(true);
    }
}
