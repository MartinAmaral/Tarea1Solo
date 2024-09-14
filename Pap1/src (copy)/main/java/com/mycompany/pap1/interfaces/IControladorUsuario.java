/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.pap1.interfaces;

import com.mycompany.pap1.logica.Barrio;
import com.mycompany.pap1.logica.EstadoBeneficiario;
import java.time.LocalDate;


/**
 *
 * @author horacio
 */
public interface IControladorUsuario {
    
    //General
    boolean ExisteUsuario(String email);
    
    // Caso Alta Usuario
    void AgregarDatosAltaUsuario(String nombre, String email);
    void AgregarDatosAltaBeneficiario(String direccion,LocalDate fecha, EstadoBeneficiario estado,Barrio barrio);
    void AgregarDatosAltaRepartidor(int licencia);
    void ConfirmarAltaBeneficiario();
    void ConfirmarAltaRepartidor();
    void CancelartAlta();
    
    // Caso Modificar Usuario
    
    
}
