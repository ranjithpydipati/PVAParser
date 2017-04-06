/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pva_parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 441683
 */


public class GOCreation {
    
    public static String RootFolder;
    public String workingdirectory = "";
    
    
    //workingdirectory="D:\\stubs";
     //public static String NewFolderName = "";
    
 
    public static void GoFileCreation(String PVAName,String ResponderName,String Responce)
    {
        try{
            
        
                    String Rsearch ="resStr = ``";  
                    String replacement = "resStr = `"+Responce+"`";
                    String s;
                File Template= new File("C:\\Users\\441683\\Desktop\\template.go");
                File Temp= new File("D:\\Einstein_CXP\\"+ResponderName+".go");
                FileReader fr = new FileReader(Template);
                BufferedReader br = new BufferedReader(fr);
                FileWriter fw = new FileWriter(Temp);
               // BufferedWriter bw = new BufferedWriter(fw);
		

                while ((s = br.readLine()) != null) {
                    if(s.contains("PVAName"))
                    {
                      String PVA=s.replace("PVAName", PVAName);
                     fw.write(PVA);
                     fw.append('\n');
                      //System.out.println(PVA);
                    }
                    else if(s.contains("Responder"))
                    {
                      String RName=s.replace("Responder", ResponderName); 
                      fw.write(RName);
                      fw.append('\n');
                      //System.out.println(RName);
                    }
                    else if(s.contains(Rsearch))
                    {
                      String responce=s.replace(Rsearch, replacement);  
                      fw.write(responce);
                      fw.append('\n');
                      //System.out.println(Responce);
                    }
                    else
                    {
                        fw.write(s);
                        fw.append('\n');
                        //System.out.println(s);      
                    }
                    
                }
                
                fw.close();
                
        
            }   
                catch (IOException ex) 
                {
            Logger.getLogger(GOCreation.class.getName()).log(Level.SEVERE, null, ex);
                }
        
     
            }
    public static String JsonPathCreation(String XPath)
    {
        String JsonPath="`xml:\"";
        StringTokenizer st = new StringTokenizer(XPath,"/*");
                             while(st.hasMoreTokens())
                             {
                                 //System.out.println(st.nextToken());
                                 String XML=st.nextToken();
                                 //System.out.println(XML);
                                 if(XML.contains("["))
                                 {
                                 String XML_y=XML.substring(XML.indexOf(':')+1,XML.indexOf('['));
                                 JsonPath=JsonPath.concat(XML_y+">");
                                 //System.out.println(JsonPath);
                                 }
                             }
                            // System.out.println(JsonPath+"'");
                            return JsonPath+"'";
    }
            
                
       
      private static void CreateFolder(String NewFolderName, String PVAName)
      {
       File file = new File("D:\\stubs\\Einstein_CPNIService");
      
        if (!file.exists()) {
           
            if (file.mkdir()) {               
                System.out.println("Directory is created!");
            } else 
                {
                System.out.println("Failed to create directory!");
                }
        }
         else
            {
                //If folder exists create a new folder name
                DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HHmmss");
                Date date = new Date();                
                NewFolderName = NewFolderName + " " + dateFormat.format(date);
                CreateFolder(NewFolderName,PVAName);
            } 
    }
      
    
    
}
