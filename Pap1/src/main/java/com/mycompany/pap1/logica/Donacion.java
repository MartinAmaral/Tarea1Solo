/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pap1.logica;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
/**
 *
 * @author martin
 */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
public abstract class Donacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    LocalDate fechaIngresada; 
    @OneToMany(mappedBy = "beneficiario")
    private List<Distribucion> distribuciones;

    public Donacion() {
        super();
    }

    public Donacion(LocalDate fechaIngresada) {
        this.fechaIngresada = fechaIngresada;
    }
    
    public int getId(){
        return id;
    }
    public LocalDate getFechaIngresada(){
        return fechaIngresada;
    }

    public List<Distribucion> getDistribuciones() {
        return distribuciones;
    }
    
    
    
    public void setId(int id){
        this.id = id;
    }
    public void setFechaIngresada(LocalDate fecha){
        this.fechaIngresada = fecha;
    }

    public void setDistribuciones(List<Distribucion> distribuciones) {
        this.distribuciones = distribuciones;
    }
}
