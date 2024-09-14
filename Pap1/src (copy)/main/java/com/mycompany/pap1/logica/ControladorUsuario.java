/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pap1.logica;


import com.mycompany.pap1.interfaces.IControladorUsuario;
import java.time.LocalDate;

/**
 *
 * @author horacio
 */
public class ControladorUsuario implements IControladorUsuario {

    private String altaUsuarioNombre;
    private String altaUsuarioEmail;
    private String altaUsuarioDireccion;
    private LocalDate altaUsuarioFecha;
    private EstadoBeneficiario altaUsuarioEstado;
    private Barrio altaUsuarioBarrio;
    private int altaUsuarioLicencia;
    
    
    @Override
    public boolean ExisteUsuario(String email) {
        var m = ManejadorUsuario.getInstancia();
        for (Usuario us : m.usuarios) {
            if (us.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void AgregarDatosAltaUsuario(String nombre, String email) {
        this.altaUsuarioNombre = nombre;
        this.altaUsuarioEmail = email;
    }

    @Override
    public void AgregarDatosAltaBeneficiario(String direccion, LocalDate fecha, EstadoBeneficiario estado,Barrio barrio) {
        this.altaUsuarioDireccion = direccion;
        this.altaUsuarioFecha = fecha;
        this.altaUsuarioEstado = estado;
        this.altaUsuarioBarrio = barrio;
    }

    @Override
    public void AgregarDatosAltaRepartidor(int licencia) {
        this.altaUsuarioLicencia = licencia;
    }

    @Override
    public void ConfirmarAltaBeneficiario() {
        var m = ManejadorUsuario.getInstancia();
        m.usuarios.add(new Beneficiario(altaUsuarioNombre,altaUsuarioEmail, altaUsuarioDireccion,
        altaUsuarioFecha, altaUsuarioEstado, altaUsuarioBarrio));
    }

    @Override
    public void ConfirmarAltaRepartidor() {
        var m = ManejadorUsuario.getInstancia();
        m.usuarios.add(new Repartidor(altaUsuarioNombre,altaUsuarioEmail,altaUsuarioLicencia)  
                );
    }

    @Override
    public void CancelartAlta() {
        altaUsuarioNombre ="";
        altaUsuarioEmail = "";
        altaUsuarioDireccion = "";
        altaUsuarioLicencia = 0;
    }
}
