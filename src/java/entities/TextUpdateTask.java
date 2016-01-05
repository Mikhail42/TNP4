/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Mikhail
 */
@Entity
public class TextUpdateTask implements Serializable {    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    private String stringToUpdate;
    public void setStringToUpdate(String s){
        stringToUpdate = s;
    }
    public String getStringToUpdate(){
        return stringToUpdate;
    }
    
    private Integer amountToDelete; 
    public void setAmountToDelete(String s){
        if (s!=null && !s.isEmpty())
        amountToDelete = Integer.parseInt(s);
    }
    public String getAmountToDelete(){
        if (amountToDelete!=null)
        return amountToDelete.toString();
        else return "";
    }
    
    private String updatedString;
    public String getUpdatedString(){
        if (!isDo) doTask();
        return updatedString;
    }       
    
    private boolean isDo = false;
    private void doTask(){
        updatedString = stringToUpdate.substring(amountToDelete, stringToUpdate.length());
        isDo = true;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TextUpdateTask)) {
            return false;
        }
        TextUpdateTask other = (TextUpdateTask) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TextUpdateTask[ id=" + id + " ]";
    }    
}