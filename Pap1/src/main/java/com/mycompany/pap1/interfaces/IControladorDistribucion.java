/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pap1.interfaces;
import com.mycompany.pap1.datatypes.dtDistribucion;
import com.mycompany.pap1.logica.EstadoDistribucion;
import java.time.LocalDate;
import java.util.List;
/**
 *
 * @author martin
 */
public interface IControladorDistribucion {
    List<dtDistribucion> getTodasDistribuciones();
    List<dtDistribucion> getDistribucionesPorEstado(EstadoDistribucion estado);
    void ModificarDatosDistribucion(dtDistribucion dist,LocalDate nuevaFecha, EstadoDistribucion nuevoEstado );
}
