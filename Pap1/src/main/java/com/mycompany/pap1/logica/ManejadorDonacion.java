/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pap1.logica;



import com.mycompany.pap1.datatypes.dtDonacion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author horacio
 */
public class ManejadorDonacion {
    private static ManejadorDonacion instancia = null;
    private List<Donacion> donaciones = new ArrayList<>();
    
    private ManejadorDonacion(){}
    
    public static ManejadorDonacion getInstancia(){
            if (instancia == null)
                instancia = new ManejadorDonacion();
            return instancia;
    }
        public void agregarDonacion(Donacion donacion) {
        donaciones.add(donacion);
        System.out.println("Donacion registrada con exito.");
    }
        public Donacion buscarDonacionPorId(int id) {
        for (Donacion donacion : donaciones) {
            if (donacion.getId() == id) {
                return donacion;
            }
        }
        return null;
    }
            public List<Donacion> obtenerDonacionesPorTipo(Class<? extends Donacion> tipo) {
        List<Donacion> resultado = new ArrayList<>();
        for (Donacion donacion : donaciones) {
            if (tipo.isInstance(donacion)) {
                resultado.add(donacion);
            }
        }
        return resultado;
    }
}
