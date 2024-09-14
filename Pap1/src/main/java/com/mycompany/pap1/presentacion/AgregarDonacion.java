package com.mycompany.pap1.presentacion;

import com.mycompany.pap1.datatypes.dtAlimento;
import com.mycompany.pap1.datatypes.dtArticulo;
import com.mycompany.pap1.datatypes.dtDonacion;
import com.mycompany.pap1.interfaces.IControladorDonacion;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Date;

public class AgregarDonacion extends JInternalFrame {
    
    private IControladorDonacion controlador;
    private JTextField txtDescripcion;
    private JTextField txtCantidad;
    private JTextField txtPeso;
    private JTextField txtDimensiones;
    private JComboBox<String> cmbTipoDonacion;
    private JButton btnAgregar;
    private JButton btnLimpiar;

    public AgregarDonacion(IControladorDonacion controlador) {
        this.controlador = controlador;
        initComponents();
    }

    private void initComponents() {
        setTitle("Agregar Donación");
        setSize(400, 300);
        setLayout(null);
        setClosable(true);
        setIconifiable(true);
        setResizable(true);

        JLabel lblTipoDonacion = new JLabel("Tipo de Donación:");
        lblTipoDonacion.setBounds(10, 10, 150, 25);
        add(lblTipoDonacion);

        cmbTipoDonacion = new JComboBox<>(new String[]{"Alimento", "Articulo"});
        cmbTipoDonacion.setBounds(160, 10, 200, 25);
        add(cmbTipoDonacion);

        JLabel lblDescripcion = new JLabel("Descripción:");
        lblDescripcion.setBounds(10, 50, 150, 25);
        add(lblDescripcion);

        txtDescripcion = new JTextField();
        txtDescripcion.setBounds(160, 50, 200, 25);
        add(txtDescripcion);

        JLabel lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setBounds(10, 90, 150, 25);
        add(lblCantidad);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(160, 90, 200, 25);
        add(txtCantidad);

        JLabel lblPeso = new JLabel("Peso:");
        lblPeso.setBounds(10, 130, 150, 25);
        add(lblPeso);

        txtPeso = new JTextField();
        txtPeso.setBounds(160, 130, 200, 25);
        add(txtPeso);

        JLabel lblDimensiones = new JLabel("Dimensiones:");
        lblDimensiones.setBounds(10, 170, 150, 25);
        add(lblDimensiones);

        txtDimensiones = new JTextField();
        txtDimensiones.setBounds(160, 170, 200, 25);
        add(txtDimensiones);

        btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(160, 210, 100, 25);
        add(btnAgregar);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(270, 210, 100, 25);
        add(btnLimpiar);
        
        //esto no se ve al principio
        txtPeso.setVisible(false);
        txtDimensiones.setVisible(false);

        // EVENTOS
        cmbTipoDonacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarCampos();
            }
        });
        
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarDonacion();
            }
        });

        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });
    }
    private void actualizarCampos() {
        String tipoDonacion = (String) cmbTipoDonacion.getSelectedItem();
        if ("Alimento".equals(tipoDonacion)) {
            txtCantidad.setVisible(true);
            txtPeso.setVisible(false);
            txtDimensiones.setVisible(false);
        } else if ("Articulo".equals(tipoDonacion)) {
            txtCantidad.setVisible(false);
            txtPeso.setVisible(true);
            txtDimensiones.setVisible(true);
        }
        // Redibuja el frame para aplicar cambios
        repaint();
    }
    private void agregarDonacion() {
        String tipoDonacion = (String) cmbTipoDonacion.getSelectedItem();
        String descripcion = txtDescripcion.getText();
        LocalDate fecha = LocalDate.now();
        dtDonacion donacion = null;

    try {
        if ("Alimento".equals(tipoDonacion)) {
            // Validación y conversión para Alimento
            String cantidadText = txtCantidad.getText();
            int cantidad = Integer.parseInt(cantidadText);

            // Crear la donación de tipo Alimento
            int id = dtDonacion.generarID();
            donacion = new dtAlimento(id, fecha, descripcion, cantidad);

        } else if ("Articulo".equals(tipoDonacion)) {
            // Validación y conversión para Articulo
            String pesoText = txtPeso.getText();
            String dimensiones = txtDimensiones.getText();
            double peso = Double.parseDouble(pesoText);

            // Crear la donación de tipo Articulo
            int id = dtDonacion.generarID();
            donacion = new dtArticulo(id, fecha, descripcion, (float) peso, dimensiones);
        }

        // Si la donación se creó correctamente, agregarla
        if (donacion != null) {
            controlador.agregarDonacion(donacion);
            JOptionPane.showMessageDialog(this, "Donación agregada con éxito.");
            limpiarCampos();
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Error en los datos numéricos (cantidad o peso).", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Ocurrió un error al agregar la donación.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    private void limpiarCampos() {
        txtDescripcion.setText("");
        txtCantidad.setText("");
        txtPeso.setText("");
        txtDimensiones.setText("");
        cmbTipoDonacion.setSelectedIndex(0);
    }
}
