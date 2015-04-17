/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author YURISNMELO
 */
public class Maintenance {
    
    private String typeMaintenance;
    private Employee comissioner;
    private Sector sector;
    
    public Maintenance(String typeMaintenance, Employee comissioner, Sector sector){
        this.typeMaintenance = typeMaintenance;
        this.comissioner = comissioner;
        this.sector = sector;
    }
    
    public String getTypeMaintenance(){
        return this.typeMaintenance;
    }
    public Employee getComissioner(){
        return this.comissioner;
    }
    public Sector getSector(){
        return this.sector;
    }
    public void setTypeMaintenance(String newTypeMaintenance){
        this.typeMaintenance = newTypeMaintenance;
    }
    public void setComissioner(Employee newEmployee){
        this.comissioner = newEmployee;
    }
    public void setSector(Sector newSector){
        this.sector = newSector;
    }
    
    
}
