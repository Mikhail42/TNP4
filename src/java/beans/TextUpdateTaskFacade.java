/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.TextUpdateTask;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Mikhail
 */
@Stateless
public class TextUpdateTaskFacade extends AbstractFacade<TextUpdateTask> {

    @PersistenceContext(unitName = "TNP4PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TextUpdateTaskFacade() {
        super(TextUpdateTask.class);
    } 
}
