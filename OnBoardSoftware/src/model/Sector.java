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
public class Sector {
    
    private String nameSector = "";
    private String codeSector = "";

    public Sector(String nameSector, String codeSector) {
        this.nameSector = nameSector;
        this.codeSector = codeSector;
    }

    public String getNameSector() {
        return nameSector;
    }

    public void setNameSector(String nameSector) {
        this.nameSector = nameSector;
    }

    public String getCodeSector() {
        return codeSector;
    }

    public void setCodeSector(String codeSector) {
        this.codeSector = codeSector;
    }
    
    
}
