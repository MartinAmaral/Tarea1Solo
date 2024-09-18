/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pap1.logica;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author martin
 */

@Entity
@Table(name = "distribuciones")
@IdClass(DistribucionID.class)
public class Distribucion implements Serializable{
    private LocalDate fechaPreparacion;
    private LocalDate fechaEntrega;
    
    @Enumerated(EnumType.STRING)
    private EstadoDistribucion estado;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "email", referencedColumnName = "email", nullable = false)
    private Beneficiario beneficiario;

    @Id
    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    private Donacion donacion;

    public Distribucion() {
        super();
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
    
    public void setFechaPreparacion(LocalDate fecha){
        fechaPreparacion = fecha;
    }
    public void setFechaEntrega(LocalDate fecha){
        fechaEntrega = fecha;
    }
    public void setEstadoDistribucion(EstadoDistribucion estado){
        this.estado = estado;
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

    public void setEstado(EstadoDistribucion estado) {
        this.estado = estado;
    }

    public void setBeneficiario(Beneficiario beneficiario) {
        this.beneficiario = beneficiario;
    }

    public void setDonacion(Donacion donacion) {
        this.donacion = donacion;
    }
    
    
}
