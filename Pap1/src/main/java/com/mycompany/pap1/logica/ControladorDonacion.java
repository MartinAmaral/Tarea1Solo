/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pap1.logica;


import com.mycompany.pap1.datatypes.dtAlimento;
import com.mycompany.pap1.datatypes.dtArticulo;
import com.mycompany.pap1.datatypes.dtDonacion;
import com.mycompany.pap1.interfaces.IControladorDonacion;


/**
 *
 * @author horacio
 */
public class ControladorDonacion implements IControladorDonacion{
    
    public ControladorDonacion(){
        super();
    }
    
    @Override
    public void agregarDonacion(dtDonacion donacion) {
    Donacion nuevaDonacion = null;

    if (donacion instanceof dtAlimento) {
        dtAlimento dtAlimentoDonacion = (dtAlimento) donacion;
        nuevaDonacion = new Alimento(
            dtAlimentoDonacion.getDescripcionProductos(),
            dtAlimentoDonacion.getCantElementos(),
            donacion.getId(),
            donacion.getFechaIngresada()
        );
    } else if (donacion instanceof dtArticulo) {
        dtArticulo dtArticuloDonacion = (dtArticulo) donacion;
        nuevaDonacion = new Articulo(
            dtArticuloDonacion.getDescripcion(),
            dtArticuloDonacion.getPeso(),
            dtArticuloDonacion.getDimensiones(),
            donacion.getId(),
            donacion.getFechaIngresada()
        );
    } else {
        System.out.println("Error: no se registro la donacion.");
        return; 
    }

    
    ManejadorDonacion mD = ManejadorDonacion.getInstancia();
    mD.agregarDonacion(nuevaDonacion);
    System.out.println("Donacion registrada con exito.");
    }

    @Override
    public void modificarDonacion(int id, dtDonacion datosModificados) {
        ManejadorDonacion mD = ManejadorDonacion.getInstancia();
        Donacion donacionExistente = mD.buscarDonacionPorId(id);

        if (donacionExistente != null) {
            if (donacionExistente instanceof Alimento && datosModificados instanceof dtAlimento) {
                Alimento alimentoExistente = (Alimento) donacionExistente;
                dtAlimento alimentoModificado = (dtAlimento) datosModificados;
                alimentoExistente.setDescripcionProductos(alimentoModificado.getDescripcionProductos());
                alimentoExistente.setCantElementos(alimentoModificado.getCantElementos());
            } else if (donacionExistente instanceof Articulo && datosModificados instanceof dtArticulo) {
                Articulo articuloExistente = (Articulo) donacionExistente;
                dtArticulo articuloModificado = (dtArticulo) datosModificados;
                articuloExistente.setDescripcion(articuloModificado.getDescripcion());
                articuloExistente.setPeso(articuloModificado.getPeso());
                articuloExistente.setDimensiones(articuloModificado.getDimensiones());
            } else {
                System.out.println("Error: tipos de donación no coinciden.");
                return;
            }

            System.out.println("Donación modificada con éxito.");
        } else {
            System.out.println("Error: donación no encontrada.");
        }
    }

    @Override    
    public dtDonacion buscarDonacionPorId(int id) {
        ManejadorDonacion mD = ManejadorDonacion.getInstancia();
        Donacion donacion = mD.buscarDonacionPorId(id);
        if (donacion == null) {
            return null;
        }
        if (donacion instanceof Alimento) {
            Alimento alimento = (Alimento) donacion;
            return new dtAlimento(alimento.getId(), alimento.getFechaIngresada(), alimento.getDescripcionProductos(), alimento.getCantElementos());
        } else if (donacion instanceof Articulo) {
            Articulo articulo = (Articulo) donacion;
            return new dtArticulo(articulo.getId(), articulo.getFechaIngresada(), articulo.getDescripcion(), articulo.getPeso(), articulo.getDimensiones());
        }
        return null; 
    }
 }

