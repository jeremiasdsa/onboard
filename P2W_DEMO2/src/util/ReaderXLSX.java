/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;
import model.Permit;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author jeremias
 */
public class ReaderXLSX extends SwingWorker<ArrayList<Permit>, Permit>{
    
    private ArrayList<Permit> permits = new ArrayList<>();
    private String filePath ="";
    
    public ReaderXLSX(String filePath){
        this.filePath=filePath;
    }
    
    
    
    @Override
    protected void process(List<Permit> chunks){
//        for(Permit p:chunks){
//            System.out.println(p.toString());
//            System.out.println(chunks.size());
//            depois tem q atualizar a gui por aqui
//        } 
    }
    
    @Override
    protected void done(){
        try{
            permits = get();
           // System.out.println(permits.toString());
            //System.out.println(permits.size());
        } catch (InterruptedException e) {

        } catch (ExecutionException e) {
            System.out.println("Tah rodando!!!=  " + e.getMessage());
        }
    
    }
    
    
    @Override
    protected ArrayList<Permit> doInBackground() throws Exception {
       FileInputStream spreadSheet = null;
        try{
            File file = new File(filePath);
           //  System.out.println("Caminho do arquivo: "+filePath);
            spreadSheet = new FileInputStream(file);
        try {
                //planilha com todas as abas
                XSSFWorkbook workbook = new XSSFWorkbook(spreadSheet);
                //primeira planilha
                XSSFSheet sheet = workbook.getSheetAt(0);
                //todas as linhas da planilha[0]
                Iterator<Row> rowIterator = sheet.iterator();
                    //varre todas as linhas da planilha[0]
                while (rowIterator.hasNext()) {
                    //pegando cada linha
                    Row row = rowIterator.next();
                    
                    //todas as celulas de cada linha
                    Iterator<Cell> cellIterator = row.iterator();
                    //varre todas as celulas
                    //System.out.println();
                    ArrayList<Cell> line = new ArrayList<Cell>();
                    while (cellIterator.hasNext()) {
                        //minha celula
                        Cell cell = cellIterator.next();
                        line.add(cell);
                    }
                    Permit permit = new Permit(line);
                    //System.out.println(permit.toString());
                    //Thread.sleep(1000);
                    
                    publish(permit);
                     //applyT.aplyTasksInModules(f, task);
                     // f.setVisible(true);
                    
                    permits.add(permit);
                    //System.out.println(permits.toString());
                }
            } catch (IOException ex) {
                Logger.getLogger(ReaderXLSX.class.getName()).log(Level.SEVERE, null, ex);
            }    
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReaderXLSX.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                spreadSheet.close();
            } catch (IOException ex) {
                Logger.getLogger(ReaderXLSX.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //System.out.println(tasks.toString());
       // System.out.println("Saindo do background");
        return permits;
    }
}
