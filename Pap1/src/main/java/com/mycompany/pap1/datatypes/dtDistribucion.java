/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.pap1.datatypes;

import com.mycompany.pap1.logica.EstadoDistribucion;
import com.mycompany.pap1.logica.Beneficiario;
import com.mycompany.pap1.logica.Donacion;
import java.time.LocalDate;

/**
 *
 * @author horacio
 */
public class dtDistribucion {
    private LocalDate fechaPreparacion;
    private LocalDate fechaEntrega;
    private EstadoDistribucion estado;
    
    private Beneficiario beneficiario;
    private Donacion donacion;

    public dtDistribucion(LocalDate fechaPreparacion, LocalDate fechaEntrega, EstadoDistribucion estado, Beneficiario beneficiario, Donacion donacion) {
        this.fechaPreparacion = fechaPreparacion;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
        this.beneficiario = beneficiario;
        this.donacion = donacion;
    }

    public LocalDate getFechaPreparacion(){
        return fechaPreparacion;
    }
    public LocalDate getFechaEntrega(){
        return fechaEntrega;
    }
    public EstadoDistribucion getEstadoDistribucion(){
        return estado;
    }

    public EstadoDistribucion getEstado() {
        return estado;
    }

    public Beneficiario getBeneficiario() {
        return beneficiario;
    }

    public Donacion getDonacion() {
        return donacion;
    }
    
    
}
