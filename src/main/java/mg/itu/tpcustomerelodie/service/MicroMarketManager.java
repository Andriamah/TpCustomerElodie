/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.tpcustomerelodie.service;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;
import mg.itu.tpcustomerelodie.entity.MicroMarket;


/**
 *
 * @author andri
 */
@RequestScoped
public class MicroMarketManager {
     @PersistenceContext(unitName = "microMarketPU")
    private EntityManager em;
     /**
   * Retourne la liste de tous les Discount.
     * @return 
   */
     public List<MicroMarket> getAllMicroMarkets() {
       Query query = em.createNamedQuery("MicroMarket.findAll");
       return query.getResultList();
    }

    @Transactional
    public MicroMarket update(MicroMarket microMarket) {
       return em.merge(microMarket);
    }
}
