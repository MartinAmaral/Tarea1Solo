/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pap1.logica;

import com.mycompany.pap1.datatypes.dtDistribucion;
import com.mycompany.pap1.interfaces.IControladorDistribucion;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author martin
 */
public class ControladorDistribucion implements IControladorDistribucion {
    private static ControladorDistribucion instancia = null;
    
    public static ControladorDistribucion getInstancia(){
            if (instancia == null)
                instancia = new ControladorDistribucion();
            return instancia;
    }

    @Override
    public List<dtDistribucion> getTodasDistribuciones() {
        var res = new ArrayList<dtDistribucion>();
        
        var dist = ManejadorDistribucion.getInstancia().getDistribuciones();
        
        for(var d : dist ){
            
            res.add(new dtDistribucion(d.getFechaPreparacion(),d.getFechaEntrega(),
                    d.getEstadoDistribucion(),d.getBeneficiario(),d.getDonacion()));
        }
        return res;
    }

    @Override
    public void AgregarDistribucion(LocalDate fechaEntrega,LocalDate fechaPreparacion,String mail,int id){
        
        var dis = new Distribucion();
        dis.setFechaEntrega(fechaEntrega);
        dis.setFechaPreparacion(fechaPreparacion);
        dis.setEstado(EstadoDistribucion.PENDIENTE);
        var b = ManejadorUsuario.getInstancia().GetUsuarios().stream()
    .filter(x -> x.getEmail().equals(mail))
    .collect(Collectors.toList());
        dis.setBeneficiario((Beneficiario) b.get(0));
        var d = ManejadorDonacion.getInstancia().buscarDonacionPorId(id);
               
        dis.setDonacion(d);
        
        var emf = Persistence.createEntityManagerFactory("tarea");
        var em = emf.createEntityManager();
        
        em.getTransaction().begin();
		
        em.merge(dis);
		
        em.getTransaction().commit();
        
        em.close();
        emf.close();
        
    }
    
    @Override
    public List<dtDistribucion> getDistribucionesPorEstado(EstadoDistribucion estado) {
        var res = new ArrayList<dtDistribucion>();
        
        var dist = ManejadorDistribucion.getInstancia().getDistribucionesPorEstado(estado);
        
        for(var d : dist ){
            
            res.add(new dtDistribucion(d.getFechaPreparacion(),d.getFechaEntrega(),
                    d.getEstadoDistribucion(),d.getBeneficiario(),d.getDonacion()));
        }
        return res;
    }
    
    @Override
    public void ModificarDatosDistribucion(dtDistribucion dist,LocalDate nuevaFecha, EstadoDistribucion nuevoEstado ){
        
        var emf = Persistence.createEntityManagerFactory("tarea");
        var em = emf.createEntityManager();
        EntityTransaction transaction = null;

        System.out.println(dist.getDonacion().getId());
        System.out.println(dist.getBeneficiario().getEmail());
        try {
            transaction = em.getTransaction();
            transaction.begin();
            String sql = "UPDATE distribuciones SET fechaentrega = ?, estado = ? WHERE id = ? AND email = ?";

    // Execute native SQL update
    em.createNativeQuery(sql)
      .setParameter(1, nuevaFecha)       
      .setParameter(2, nuevoEstado.toString())      
      .setParameter(3, dist.getDonacion().getId())     
      .setParameter(4, dist.getBeneficiario().getEmail())  
      .executeUpdate();

    transaction.commit();
         } catch (Exception e) {
             System.out.println(e.getMessage());
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
        em.close();
        emf.close();
    }
        
    }
}
