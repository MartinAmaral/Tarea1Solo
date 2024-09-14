/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pap1.datatypes;

import java.time.LocalDate;

/**
 *
 * @author horacio
 */

public abstract class dtDonacion {
    private int id;
    private LocalDate fechaIngresada;
    private static int contadorID = 0;

    public dtDonacion(int id, LocalDate fechaIngresada) {
        this.id = id;
        this.fechaIngresada = fechaIngresada;
    }
    
    public static int generarID() {
        return ++contadorID;
    }

    public int getId() {
        return id;
    }

    public LocalDate getFechaIngresada() {
        return fechaIngresada;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFechaIngresada(LocalDate fecha) {
        this.fechaIngresada = fecha;
    }
}
