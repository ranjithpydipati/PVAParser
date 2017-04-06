/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pva_parser;

 import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 *
 * @author 441683
 */
public class UnZipPVA {
    
    
        //UnZipPVA unzipper = new UnZipPVA();
          //unzip(zipFilePath,destDirectory);

   private static final int BUFFER_SIZE = 8192;
    /**
     * Extracts a zip file specified by the zipFilePath to a directory specified by
     * destDirectory (will be created if does not exists)
     * @param zipFilePath
     * @param destDirectory
     * @throws IOException
     */
    public void unzip(String zipFilePath, String destDirectory) throws IOException {
        File destDir = new File(destDirectory);
        if (!destDir.exists()) {
            destDir.mkdir();
            System.out.println("Created");
        }
        ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath));
        ZipEntry entry = zipIn.getNextEntry();
        //System.out.println(entry);
       // zipIn.
        // iterates over entries in the zip file
        File Zipfile=new File(zipFilePath);
        //while (entry != null) {
            String filePath = destDirectory + File.separator + Zipfile.getName().replaceFirst("[.][^.]+$", "");
           // if (!entry.isDirectory()) {
                // if the entry is a file, extracts it
                extractFile(zipIn, filePath);
                System.out.println("unzipped");
           // } else {
                // if the entry is a directory, make the directory
                System.out.println(zipIn);
                //File dir = new File(filePath);
               //dir.mkdir();
                //extractFile(zipIn, filePath);
                
            
            //zipIn.closeEntry();
            //entry = zipIn.getNextEntry();
        //}
        zipIn.close();
    }
    /**
     * Extracts a zip entry (file entry)
     * @param zipIn
     * @param filePath
     * @throws IOException
     */
    private void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        byte[] bytesIn = new byte[BUFFER_SIZE];
        int read = 0;
        while ((read = zipIn.read(bytesIn)) != -1) {
            bos.write(bytesIn, 0, read);
            System.out.println(bytesIn);
        }
        bos.close();
    }
    
}
    

 



        
        
       
    
    

       
          
        
    

