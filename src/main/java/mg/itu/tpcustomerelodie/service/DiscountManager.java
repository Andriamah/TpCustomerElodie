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
import mg.itu.tpcustomerelodie.entity.Discount;

/**
 * Gère la persistance des Customers.
 * @author andri
 */

@RequestScoped
public class DiscountManager {
    @PersistenceContext(unitName = "discountPU")
    private EntityManager discountManger;
     /**
   * Retourne la liste de tous les Discount.
     * @return 
   */
     public List<Discount> getAllDiscounts() {
       Query query = discountManger.createNamedQuery("Discount.findAll");
       return query.getResultList();
    }

    @Transactional
    public Discount update(Discount discount) {
       return discountManger.merge(discount);
    }

    @Transactional
    public void persist(Discount discount) {
       discountManger.persist(discount);
    }
}
