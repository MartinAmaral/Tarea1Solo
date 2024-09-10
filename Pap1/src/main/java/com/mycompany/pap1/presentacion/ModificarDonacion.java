package com.mycompany.pap1.presentacion;

import com.mycompany.pap1.datatypes.dtAlimento;
import com.mycompany.pap1.datatypes.dtArticulo;
import com.mycompany.pap1.datatypes.dtDonacion;
import com.mycompany.pap1.interfaces.IControladorDonacion;
import com.mycompany.pap1.logica.Alimento;
import com.mycompany.pap1.logica.Articulo;
import com.mycompany.pap1.logica.Donacion;
import com.mycompany.pap1.logica.ManejadorDonacion;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

public class ModificarDonacion extends JInternalFrame {
    private IControladorDonacion controlador;
    private JTable tablaAlimentos;
    private JTable tablaArticulos;
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
        setLayout(new BorderLayout());

        // Panel de tablas
        JPanel panelTablas = new JPanel();
        panelTablas.setLayout(new GridLayout(1, 2));

        tablaAlimentos = new JTable();
        JScrollPane scrollAlimentos = new JScrollPane(tablaAlimentos);
        panelTablas.add(scrollAlimentos);

        tablaArticulos = new JTable();
        JScrollPane scrollArticulos = new JScrollPane(tablaArticulos);
        panelTablas.add(scrollArticulos);

        add(panelTablas, BorderLayout.CENTER);

        // Panel de detalles
        JPanel panelDetalles = new JPanel();
        panelDetalles.setLayout(null);

        JLabel lblId = new JLabel("ID:");
        lblId.setBounds(10, 10, 100, 25);
        panelDetalles.add(lblId);

        txtId = new JTextField();
        txtId.setBounds(120, 10, 150, 25);
        txtId.setEditable(false);
        panelDetalles.add(txtId);

        JLabel lblTipoDonacion = new JLabel("Tipo de Donación:");
        lblTipoDonacion.setBounds(10, 45, 120, 25);
        panelDetalles.add(lblTipoDonacion);

        cmbTipoDonacion = new JComboBox<>(new String[]{"Alimento", "Articulo"});
        cmbTipoDonacion.setBounds(150, 45, 150, 25);
        panelDetalles.add(cmbTipoDonacion);

        JLabel lblDescripcion = new JLabel("Descripción:");
        lblDescripcion.setBounds(10, 80, 100, 25);
        panelDetalles.add(lblDescripcion);

        txtDescripcion = new JTextField();
        txtDescripcion.setBounds(120, 80, 250, 25);
        panelDetalles.add(txtDescripcion);

        JLabel lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setBounds(10, 115, 100, 25);
        panelDetalles.add(lblCantidad);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(120, 115, 150, 25);
        panelDetalles.add(txtCantidad);

        JLabel lblPeso = new JLabel("Peso:");
        lblPeso.setBounds(10, 150, 100, 25);
        panelDetalles.add(lblPeso);

        txtPeso = new JTextField();
        txtPeso.setBounds(120, 150, 150, 25);
        panelDetalles.add(txtPeso);

        JLabel lblDimensiones = new JLabel("Dimensiones:");
        lblDimensiones.setBounds(10, 185, 100, 25);
        panelDetalles.add(lblDimensiones);

        txtDimensiones = new JTextField();
        txtDimensiones.setBounds(120, 185, 250, 25);
        panelDetalles.add(txtDimensiones);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(120, 220, 100, 25);
        panelDetalles.add(btnGuardar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(230, 220, 100, 25);
        panelDetalles.add(btnCancelar);

        add(panelDetalles, BorderLayout.SOUTH);

        // Cargar tablas
        cargarTablas();

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

        tablaAlimentos.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = tablaAlimentos.getSelectedRow();
            if (selectedRow >= 0) {
                int id = (int) tablaAlimentos.getValueAt(selectedRow, 0);
                cargarDonacion(id);
            }
        });

        tablaArticulos.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = tablaArticulos.getSelectedRow();
            if (selectedRow >= 0) {
                int id = (int) tablaArticulos.getValueAt(selectedRow, 0);
                cargarDonacion(id);
            }
        });
    }

    private void cargarTablas() {
        ManejadorDonacion mD = ManejadorDonacion.getInstancia();
        List<Donacion> alimentos = mD.obtenerDonacionesPorTipo(Alimento.class);
        List<Donacion> articulos = mD.obtenerDonacionesPorTipo(Articulo.class);

        tablaAlimentos.setModel(new DonacionTableModel(alimentos));
        tablaArticulos.setModel(new DonacionTableModel(articulos));
    }

    private void cargarDonacion(int id) {
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

    private class DonacionTableModel extends AbstractTableModel {
        private List<Donacion> donaciones;
        private String[] columnNames = {"ID", "Descripción", "Cantidad/Peso", "Dimensiones"};

        public DonacionTableModel(List<Donacion> donaciones) {
            this.donaciones = donaciones;
        }

        @Override
        public int getRowCount() {
            return donaciones.size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Donacion donacion = donaciones.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return donacion.getId();
                case 1:
                    if (donacion instanceof Alimento) {
                        return ((Alimento) donacion).getDescripcionProductos();
                    } else if (donacion instanceof Articulo) {
                        return ((Articulo) donacion).getDescripcion();
                    }
                    break;
                case 2:
                    if (donacion instanceof Alimento) {
                        return ((Alimento) donacion).getCantElementos();
                    } else if (donacion instanceof Articulo) {
                        return ((Articulo) donacion).getPeso();
                    }
                    break;
                case 3:
                    if (donacion instanceof Articulo) {
                        return ((Articulo) donacion).getDimensiones();
                    }
                    break;
            }
            return null;
        }

        @Override
        public String getColumnName(int column) {
            return columnNames[column];
        }
    }
}