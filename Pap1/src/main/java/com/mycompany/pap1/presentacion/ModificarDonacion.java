package com.mycompany.pap1.presentacion;

import com.mycompany.pap1.datatypes.dtAlimento;
import com.mycompany.pap1.datatypes.dtArticulo;
import com.mycompany.pap1.datatypes.dtDonacion;
import com.mycompany.pap1.interfaces.IControladorDonacion;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class ModificarDonacion extends JInternalFrame {
    private IControladorDonacion controlador;
    private JTextField txtId;
    private JTextField txtDescripcion;
    private JTextField txtCantidad;
    private JTextField txtPeso;
    private JTextField txtDimensiones;
    private JComboBox<String> cmbTipoDonacion;
    private JButton btnGuardar;
    private JButton btnCancelar;
    private int donacionId;

    public ModificarDonacion(IControladorDonacion controlador) {
        super("Modificar Donación", true, true, true, true);
        this.controlador = controlador;
        initialize();
    }

    private void initialize() {
        setLayout(null);
        setSize(400, 300);
        
        // Crear y agregar componentes
        JLabel lblId = new JLabel("ID:");
        lblId.setBounds(10, 10, 100, 25);
        add(lblId);

        txtId = new JTextField();
        txtId.setBounds(120, 10, 150, 25);
        txtId.setEditable(false);
        add(txtId);

        JLabel lblTipoDonacion = new JLabel("Tipo de Donación:");
        lblTipoDonacion.setBounds(10, 45, 100, 25);
        add(lblTipoDonacion);

        cmbTipoDonacion = new JComboBox<>(new String[]{"Alimento", "Articulo"});
        cmbTipoDonacion.setBounds(120, 45, 150, 25);
        add(cmbTipoDonacion);

        JLabel lblDescripcion = new JLabel("Descripción:");
        lblDescripcion.setBounds(10, 80, 100, 25);
        add(lblDescripcion);

        txtDescripcion = new JTextField();
        txtDescripcion.setBounds(120, 80, 250, 25);
        add(txtDescripcion);

        JLabel lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setBounds(10, 115, 100, 25);
        add(lblCantidad);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(120, 115, 150, 25);
        add(txtCantidad);

        JLabel lblPeso = new JLabel("Peso:");
        lblPeso.setBounds(10, 150, 100, 25);
        add(lblPeso);

        txtPeso = new JTextField();
        txtPeso.setBounds(120, 150, 150, 25);
        add(txtPeso);

        JLabel lblDimensiones = new JLabel("Dimensiones:");
        lblDimensiones.setBounds(10, 185, 100, 25);
        add(lblDimensiones);

        txtDimensiones = new JTextField();
        txtDimensiones.setBounds(120, 185, 250, 25);
        add(txtDimensiones);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(120, 220, 100, 25);
        add(btnGuardar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(230, 220, 100, 25);
        add(btnCancelar);

        // Agregar Listeners
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarModificaciones();
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cerrar la ventana
            }
        });
    }

    public void cargarDonacion(int id) {
        this.donacionId = id;
        dtDonacion donacion = controlador.buscarDonacionPorId(id);

        if (donacion != null) {
            txtId.setText(String.valueOf(donacion.getId()));
            if (donacion instanceof dtAlimento) {
                dtAlimento alimento = (dtAlimento) donacion;
                cmbTipoDonacion.setSelectedItem("Alimento");
                txtDescripcion.setText(alimento.getDescripcionProductos());
                txtCantidad.setText(String.valueOf(alimento.getCantElementos()));
                txtPeso.setText("");
                txtDimensiones.setText("");
            } else if (donacion instanceof dtArticulo) {
                dtArticulo articulo = (dtArticulo) donacion;
                cmbTipoDonacion.setSelectedItem("Articulo");
                txtDescripcion.setText(articulo.getDescripcion());
                txtCantidad.setText(""); // Limpiar o deshabilitar si no se aplica
                txtPeso.setText(String.valueOf(articulo.getPeso()));
                txtDimensiones.setText(articulo.getDimensiones());
            }
        }
    }

    private void guardarModificaciones() {
        String tipoDonacion = (String) cmbTipoDonacion.getSelectedItem();
        String descripcion = txtDescripcion.getText();
        String cantidadText = txtCantidad.getText();
        String pesoText = txtPeso.getText();
        String dimensiones = txtDimensiones.getText();
        LocalDate fecha = LocalDate.now(); // Obtener la fecha actual

        try {
            if ("Alimento".equals(tipoDonacion)) {
                int cantidad = Integer.parseInt(cantidadText);
                dtAlimento donacion = new dtAlimento(donacionId, fecha, descripcion, cantidad);
                controlador.modificarDonacion(donacionId, donacion);
            } else if ("Articulo".equals(tipoDonacion)) {
                float peso = Float.parseFloat(pesoText);
                dtArticulo donacion = new dtArticulo(donacionId, fecha, descripcion, peso, dimensiones);
                controlador.modificarDonacion(donacionId, donacion);
            }

            JOptionPane.showMessageDialog(this, "Donación modificada con éxito.");
            dispose(); // Cerrar la ventana
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error en los datos ingresados. Verifique los valores.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
