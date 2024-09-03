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
    private String numeroLicencia;

    public Repartidor() {
        super();
    }
    
    public String getnumeroLicencia(){
        return numeroLicencia;
    }
    public void setnumeroLicencia(String numeroLicencia){
        this.numeroLicencia = numeroLicencia;
    }
}
