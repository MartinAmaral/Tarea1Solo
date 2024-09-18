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

 try {
        transaction = em.getTransaction();
        transaction.begin();
        String hql = "UPDATE YourEntity e SET e.fechaentrega = :newValue1, e.estado = :newValue2 WHERE e.id = :id AND e.email = :email";
        em.createQuery(hql)
          .setParameter("newValue1", nuevaFecha)
          .setParameter("newValue2", nuevoEstado)
          .setParameter("id", dist.getDonacion().getId())
          .setParameter("email", dist.getBeneficiario().getEmail())
          .executeUpdate();

        transaction.commit();
         } catch (Exception e) {
        if (transaction != null && transaction.isActive()) {
            transaction.rollback();
        }
        e.printStackTrace();
    } finally {
        em.close();
        emf.close();
    }
        
    }
}
