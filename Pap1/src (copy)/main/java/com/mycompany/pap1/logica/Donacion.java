/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pap1.logica;

import java.util.List;
import java.time.LocalDate;
/**
 *
 * @author martin
 */
public abstract class Donacion {
    int id;
    LocalDate fechaIngresada;

    public Donacion() {
        super();
    }

    public Donacion(int id, LocalDate fechaIngresada) {
        this.id = id;
        this.fechaIngresada = fechaIngresada;
    }
    
    public int getId(){
        return id;
    }
    public LocalDate getFechaIngresada(){
        return fechaIngresada;
    }
    
    public void setId(int id){
        this.id = id;
    }
    public void setFechaIngresada(LocalDate fecha){
        this.fechaIngresada = fecha;
    }
}
