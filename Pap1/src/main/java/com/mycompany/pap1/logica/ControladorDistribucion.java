/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pap1.logica;

import com.mycompany.pap1.datatypes.dtDistribucion;
import com.mycompany.pap1.interfaces.IControladorDistribucion;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author martin
 */
public class ControladorDistribucion implements IControladorDistribucion {
    private static ControladorDistribucion instancia = null;
    
    public static ControladorDistribucion getInstancia(){
            if (instancia == null)
                instancia = new ControladorDistribucion();
            return instancia;
    }

    @Override
    public List<dtDistribucion> getTodasDistribuciones() {
        var res = new ArrayList<dtDistribucion>();
        // sacar del manejador todas la distri
        return res;
    }

    @Override
    public List<dtDistribucion> getDistribucionesPorEstado(EstadoDistribucion estado) {
        var res = new ArrayList<dtDistribucion>();
        // sacar del manejador todas las segun igual al estado
        return res;
    }
    
    @Override
    public void ModificarDatosDistribucion(dtDistribucion dist,LocalDate nuevaFecha, EstadoDistribucion nuevoEstado ){
        
        //modificar en la base de datos la dist por la key y poner los nuevos valores
        
    }
}
