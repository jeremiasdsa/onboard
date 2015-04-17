/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Objects;

/**
 *
 * @author YURISNMELO
 */
public class Employee {
    String nameEmployee ="";
    String IDEmployee="";

    public String getNameEmployee() {
        return nameEmployee;
    }

    public String getIDEmployee() {
        return IDEmployee;
    }

    public void setNameEmployee(String newNameEmployee) {
        this.nameEmployee = newNameEmployee;
    }

    public void setIDEmployee(String newIDEmployee) {
        this.IDEmployee = newIDEmployee;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.IDEmployee);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        if(other.getIDEmployee().equals(this.IDEmployee))return true;
        return false;
    }

   
    
}
