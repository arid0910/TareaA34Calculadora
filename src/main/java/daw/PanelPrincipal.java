/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * @author adam
 */
public class PanelPrincipal extends JPanel implements ActionListener {

    // Atributos de la clase (privados)
    private PanelBotones botonera;
    private JTextArea areaTexto;
    private int tipoOperacion;
    private int num1;
    private int num2;
    private int resultado;

    // Constructor
    public PanelPrincipal() {
        initComponents();
        tipoOperacion = -1; // No hay operaciones en la calculadora
    }

    // Se inicializan los componentes gráficos y se colocan en el panel
    private void initComponents() {
        // Creamos el panel de botones
        botonera = new PanelBotones();
        // Creamos el área de texto
        areaTexto = new JTextArea(10, 50);
        areaTexto.setEditable(true);
        areaTexto.setBackground(Color.white);
        //Establecemos layout del panel principal
        this.setLayout(new BorderLayout());
        // Colocamos la botonera y el área texto
        this.add(areaTexto, BorderLayout.NORTH);
        this.add(botonera, BorderLayout.SOUTH);

        for (JButton boton : this.botonera.getgrupoBotones()) {
            boton.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // Se obtiene el objeto que desencadena el evento
        Object o = ae.getSource();
        // Si es un botón
        if (o instanceof JButton) {
            System.out.println(((JButton) o).getText());
            areaTexto.setText(((JButton) o).getText());

        }

        // RESTO DEL CÓDIGO DE LA LÓGICA DE LA CALCULADORA
        //Limpiar
        num1 = Integer.parseInt(areaTexto.getText());

        if (o == botonera.grupoBotones[15]) {
            areaTexto.setText("");
        }

        //Igual
        if (o == botonera.grupoBotones[14]) {

        }
    }

    public int operacion(ActionEvent ae) {
        
        Object o = ae.getSource();
        final String regex = "(\\ds*[+*/-]s*\\d)";
        final String string = "2/2";
        
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        
        
        // Resto de las operaciones
        if (o == botonera.grupoBotones[10]) {
            tipoOperacion = 1;

        }

        //Resta
        if (o == botonera.grupoBotones[11]) {
            tipoOperacion = 2;
        }

        //Multiplicar
        if (o == botonera.grupoBotones[12]) {
            tipoOperacion = 3;
        }

        //Dividir
        if (o == botonera.grupoBotones[13]) {
            tipoOperacion = 4;
        }
        
        return 0;
    }
}
