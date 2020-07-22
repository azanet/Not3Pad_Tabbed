/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import static javax.swing.JFileChooser.FILES_ONLY;
import javax.swing.JOptionPane;

/**
 *
 * @author davidf
 */
public class MetodosPrincipal {
    
    
    public MetodosPrincipal() {
    }
    
    //Metodo Abrir
     public File AbrirArchivo(File archivo) throws IOException {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(FILES_ONLY);
        try{
        if (fileChooser.showOpenDialog(fileChooser) == JFileChooser.APPROVE_OPTION) {
            archivo = fileChooser.getSelectedFile();
     
                 return archivo;

        }
        }catch(HeadlessException e){
            e.getMessage();
        }
        return archivo;

    }//FFin del metodo ABRIR
    
 ////////////////////////////////////////////////////////////////////////////////  
     
    public File Guardar(File fichero, String texto) {

        //Crea un flujo de caracteres para grabar
        try {
            FileWriter flujo = new FileWriter(fichero); //Podriamos dejarle true para que seguiera escribiendo debajo de este si existiera, (aunqeu lo estoy eliminando mas arriba pòrque no es el caso)
            try (PrintWriter escritor = new PrintWriter(flujo)) {
                escritor.println(texto);
                escritor.close();
                flujo.close();
                return fichero;
            }
        } catch (IOException ex) {
            ex.getMessage();
        }
        return fichero;
    }//Fin del metodo GUARDAR
    
     
 ////////////////////////////////////////////////////////////////////////////////     
    
       public File GuardarComo(File archivo,String texto) throws IOException {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(FILES_ONLY);

        if (fileChooser.showSaveDialog(fileChooser) == JFileChooser.APPROVE_OPTION) {
            archivo = fileChooser.getSelectedFile();
            FileWriter escritor = null;

            try {
                escritor = new FileWriter(archivo);
                escritor.write(texto);
                     JOptionPane.showMessageDialog(null, "El ARCHIVO fue GUARDADO con Éxito", "Archivo Guardado", JOptionPane.INFORMATION_MESSAGE);
           
            } catch (IOException e) {
                e.getMessage();
                //   escritor.close();
                return archivo;

            }

            escritor.close();
            return archivo;

        }
        JOptionPane.showMessageDialog(null, "El ARCHIVO NO fue guardado ", "Archivo NO Guardado", JOptionPane.INFORMATION_MESSAGE);
            

        return archivo;

    }//FFin del metodo guardar como
     

////////////////////////////////////////////////////////////////////////////////         
       
  
     
}//Fin de METODOS PRINCIPAL
