/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pap1.logica;


import com.mycompany.pap1.datatypes.dtBeneficiario;
import com.mycompany.pap1.interfaces.IControladorUsuario;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    
    private static ControladorUsuario instancia = null;
    
    public static ControladorUsuario getInstancia(){
            if (instancia == null)
                instancia = new ControladorUsuario();
            return instancia;
    }
    
    @Override
    public boolean ExisteUsuario(String email) {
        var m = ManejadorUsuario.getInstancia();
        for (Usuario us : m.GetUsuarios()) {
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
        m.AgregarUsuario(new Beneficiario(altaUsuarioNombre,altaUsuarioEmail, altaUsuarioDireccion,
        altaUsuarioFecha, altaUsuarioEstado, altaUsuarioBarrio));
    }

    @Override
    public void ConfirmarAltaRepartidor() {
        var m = ManejadorUsuario.getInstancia();
        m.AgregarUsuario(new Repartidor(altaUsuarioNombre,altaUsuarioEmail,altaUsuarioLicencia));
    }

    @Override
    public void CancelartAlta() {
        altaUsuarioNombre ="";
        altaUsuarioEmail = "";
        altaUsuarioDireccion = "";
        altaUsuarioLicencia = 0;
    }

    @Override
    public List<dtBeneficiario> GetBeneficiarios() {
        var b = ManejadorUsuario.getInstancia().GetBeneficiarios();
        
        List<dtBeneficiario> l = new ArrayList<>();
        
        for (var ben : b) {
            
            l.add(new dtBeneficiario(ben.getNombre(),ben.getEmail(),ben.getDireccion(),
                    ben.getFechaNacimiento(),ben.getEstado(),ben.getBarrio()));
        }
        return l;
    }
    
    @Override
    public List<Usuario> GetUsuarios(){
        return ManejadorUsuario.getInstancia().GetUsuarios();
    
    }

    @Override
    public List<String> GetEmailBeneficiarios() {
        var x = ManejadorUsuario.getInstancia().GetUsuarios();
        var res = new ArrayList<String>();
        
        for(var f : x){
            res.add(f.getEmail());
            
        }
        
        return res;
    }
    
    
}
