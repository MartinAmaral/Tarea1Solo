/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pap1.logica;


/**
 *
 * @author horacio
 */
public class Repartidor extends Usuario {

    private int numeroLicencia;
    public Repartidor(String nombre, String email,  int numeroLicencia) {
        this.nombre = nombre;
        this.email = email;
        this.numeroLicencia = numeroLicencia;
    }
    

    public int getnumeroLicencia(){
        return numeroLicencia;
    }
    public void setnumeroLicencia(int numeroLicencia){
        this.numeroLicencia = numeroLicencia;
    }
}
