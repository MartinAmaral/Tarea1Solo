/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pap1.datatypes;

import java.time.LocalDate;
import java.util.Date;

public class dtAlimento extends dtDonacion {
    private String descripcionProductos;
    private int cantElementos;

    public dtAlimento(int id, LocalDate fechaIngresada, String descripcionProductos, int cantElementos) {
        super(id, fechaIngresada);
        this.descripcionProductos = descripcionProductos;
        this.cantElementos = cantElementos;
    }

    public String getDescripcionProductos() {
        return descripcionProductos;
    }

    public int getCantElementos() {
        return cantElementos;
    }

    public void setDescripcionProductos(String descripcionProductos) {
        this.descripcionProductos = descripcionProductos;
    }

    public void setCantElementos(int cantElementos) {
        this.cantElementos = cantElementos;
    }
}

