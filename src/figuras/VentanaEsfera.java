package figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaEsfera extends JFrame implements ActionListener {

    private Container contenedor;

    private JLabel radio, volumen, superficie;
    private JTextField campoRadio; // Campo de texto a ingresar
    private JButton calcular;

    public VentanaEsfera() {
        inicio();
        setTitle("Esfera");
        setSize(280, 200);
        setLocationRelativeTo(null);

        setResizable(false);
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        radio = new JLabel();
        radio.setText("Radio (cms):");
        radio.setBounds(20, 20, 135, 23);

        campoRadio = new JTextField();
        campoRadio.setBounds(100, 20, 135, 23);

        calcular = new JButton();
        calcular.setText("Calcular");
        calcular.setBounds(100, 50, 135, 23);
        calcular.addActionListener(this);

        volumen = new JLabel();
        volumen.setText("Volumen (cm3):");
        volumen.setBounds(20, 90, 135, 23);
        superficie = new JLabel();
        superficie.setText("Superficie (cm2):");
// Establece la posición de la etiqueta de superficie de la esfera
        superficie.setBounds(20, 120, 135, 23);
// Se añade cada componente gráfico al contenedor de la ventana
        contenedor.add(radio);
        contenedor.add(campoRadio);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
    }

    /**
     * Método que gestiona los eventos generados en la ventana de la esfera
     * throws Exception Excepción al ingresar un campo nulo o error en formato
     * de número
     */
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == calcular) {
            /* Si se pulsa el botón
Calcular */
            boolean error = false;
            try {
// Se obtiene y convierte el valor numérico del radio
                double radio = Double.parseDouble(campoRadio.
                        getText());
                Esfera esfera = new Esfera(radio);
                /* Se crea un objeto
Esfera */
// Se muestra el volumen
                volumen.setText("Volumen (cm3): " + String.format("%.2f", esfera.calcularVolumen()));

                superficie.setText("Superficie (cm2): " + String.format("%.2f", esfera.calcularSuperficie()));
            } catch (Exception e) {
                error = true; // Si ocurre una excepción
            } finally {
                if (error) {
                    /* Si ocurre una excepción, se muestra un
mensaje de error */
                    JOptionPane.showMessageDialog(null, "Campo nulo o error en formato de número", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
