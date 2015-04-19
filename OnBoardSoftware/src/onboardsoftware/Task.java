/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onboardsoftware;

import java.util.ArrayList;
import java.util.Date;
import org.apache.poi.ss.usermodel.Cell;

/**
 *
 * @author jeremias
 */    


public class Task {
    
    private ArrayList<Cell> list = new ArrayList<Cell>();

    public Task(ArrayList<Cell> list){
        
        this.list=list;
    
        
    
    }
    
    public boolean isCold(){
        if(getColdWorkPermitNo().toString().compareTo("")==0){
            return false;
        }else{
            return true;
        }
            
    
    }
    public ArrayList<Cell> getList(){
        return this.list;
    }

    public Cell getColdWorkPermitNo() {
        return this.list.get(0);
    }

    public void setColdWorkPermitNo(Cell coldWorkPermitNo) {
        this.list.add(0, coldWorkPermitNo);
    }

    public Cell getHotWorkPermitNo() {
        return this.list.get(1);
    }

    public void setHotWorkPermitNo(Cell hotWorkPermitNo) {
        this.list.add(1, hotWorkPermitNo);
    }

    public Cell getIssuedForDay() {
        return this.list.get(2);
    }

    public void setIssuedForDay(Cell issuedForDay) {
        this.list.add(2, issuedForDay);
    }

    public Cell getWorkDescription() {
        return this.list.get(3);
    }

    public void setWorkDescription(Cell workDescription) {
        this.list.set(3, workDescription);
    }

    public Cell getDateIssued() {
        return this.list.get(4);
    }

    public void setDateIssued(Cell dateIssued) {
        this.list.set(4, dateIssued);
    }

    public Cell getModuleNumber() {
        return this.list.get(5);
    }

    public void setModuleNumber(Cell moduleNumber) {
        this.list.set(5, moduleNumber);
    }

    public Cell getAreaAuthority() {
        return this.list.get(6);
    }

    public void setAreaAuthority(Cell areaAuthority) {
        this.list.set(6, areaAuthority);
    }

    public Cell getDateCompleted() {
        return this.list.get(7);
    }

    public void setDateCompleted(Cell dateCompleted) {
        this.list.set(7, dateCompleted);
    }

    public Cell getSsic() {
        return this.list.get(8);
    }

    public void setSsic(Cell ssic) {
        this.list.set(8, ssic);
    }

    public Cell getEpm() {
        return this.list.get(9);
    }

    public void setEpm(Cell epm) {
        this.list.set(9, epm);
    }

    public Cell getEsec() {
        return this.list.get(10);
    }

    public void setEsec(Cell esec) {
        this.list.set(10, esec);
    }

    public Cell getLockOutBoxNo() {
        return this.list.get(11);
    }

    public void setLockOutBoxNo(Cell lockOutBoxNo) {
        this.list.set(11, lockOutBoxNo);
    }

    public Cell getWorkContinuingUnderPermitNo() {
        return this.list.get(12);
    }

    public void setWorkContinuingUnderPermitNo(Cell workContinuingUnderPermitNo) {
        this.list.set(12, workContinuingUnderPermitNo);
    }
    
    @Override
    public String toString() {
        return "<html><h1>" + "cold=" + getColdWorkPermitNo() + "<br>"  + "hot= " + getHotWorkPermitNo()+"<br>"  + "issuedForDay= " + getIssuedForDay()+"<br>"  + 
                "workDescription= " + getWorkDescription()+"<br>"  + "dateIssued= " + getDateIssued()+"<br>"  + "moduleNumber= "+ getModuleNumber() +"<br>"  + "areaAuthority= "+ 
                getAreaAuthority() +"<br>"  + "dateCompleted= " + getDateCompleted()+"<br>"  + "ssic= "+ getSsic() +"<br>"  + "epm= " + getEpm()+"<br>"  + "esec= " + getEsec()+"<br>"  + "lockOutBoxNo= "+ 
                getLockOutBoxNo() +"<br>"  +  "workContinuingUnderPermitNo= " + getWorkContinuingUnderPermitNo()+"<br>" +"</h1></html>";
    }
    
    
}
