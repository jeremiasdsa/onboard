/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onboardsoftware;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 *
 * @author jeremias
 */
public class ReadXLSX {

    public ArrayList<Task> getTasks(String tabela) {
        ArrayList<Task> tasks = new ArrayList<Task>();
        FileInputStream spreadSheet = null;
        try {
            File file = new File(tabela);
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
                    System.out.println();
                    ArrayList<Cell> list = new ArrayList<Cell>();
                    while (cellIterator.hasNext()) {
                        //minha celula
                        Cell cell = cellIterator.next();
                        list.add(cell);
                    }
                    Task task = new Task(list);
                   
                    tasks.add(task);
                }
            } catch (IOException ex) {
                Logger.getLogger(ReadXLSX.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadXLSX.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                spreadSheet.close();
            } catch (IOException ex) {
                Logger.getLogger(ReadXLSX.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return tasks;
    }
}
