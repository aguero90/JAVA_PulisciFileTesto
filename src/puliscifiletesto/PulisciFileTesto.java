/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package puliscifiletesto;
import javax.swing.*;
import java.io.*;
import javax.swing.filechooser.FileFilter;


/**
 *
 * @author alex
 */
public class PulisciFileTesto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new TxtFileFilter());
        int n = fileChooser.showOpenDialog(null);
        File f = fileChooser.getSelectedFile();
        String linea;
        try{
            //DataInputStream inStream = new DataInputStream(new FileInputStream(f));
            BufferedReader inStream = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            BufferedWriter outStream = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Final.txt")));
            while(inStream.hashCode() != -1){
                linea = inStream.readLine();
                String [] s = linea.split(";");
                outStream.write((s[1] + ";" + s[6]));
                outStream.newLine();
                }
            }
        catch(Exception e){
            
        }
    }
}





class TxtFileFilter extends FileFilter {

  public boolean accept(File file) {
    if (file.isDirectory()) return true;
    String fname = file.getName().toLowerCase();
    return fname.endsWith("txt");
  }

  public String getDescription() {
    return "File di testo";
  }
}