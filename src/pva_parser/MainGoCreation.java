/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pva_parser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//import static pva_parser.PVA_Parser.PVAName;

/**
 *
 * @author 441683
 */
public class MainGoCreation {
    
    public static int i=1,j=1;
     public static void MainFunctionCreation(String PVAName,String ResponderName,String PVA_URL,String Responder_Const,String RequestType,int Reponder_Count) throws IOException
    {
        
        File Fun_Temp=new File("D:\\Fun_Template.go");
        File Fun= new File("D:\\Function.go");
        FileWriter fw = new FileWriter(Fun.getAbsoluteFile(),true);
        FileReader fr = new FileReader(Fun_Temp);
        BufferedReader br = new BufferedReader(fr);
        BufferedWriter bw = new BufferedWriter(fw);
         String s;
          
         //System.out.println(Reponder_Count);
	if(Reponder_Count==1)
        {
             while ((s = br.readLine()) != null) {
                 if(s.contains("PVAName")||s.contains("ResponderName")|| s.contains("PVA_URL") ||s.contains("Responder_Const")|| s.contains("RequestType") )
                 {
                     if(s.contains("PVAName"))
                    {
                      String PVA=s.replace("PVAName", PVAName);
                     
                      if(PVA.contains("ResponderName"))
                      {
                          PVA=PVA.replace("ResponderName", ResponderName);
                      }
			bw.write(PVA);
                        bw.append('\n');
                      //System.out.println(PVA);
                    }
                     else if(s.contains("ResponderName"))
                    {
                      String RName=s.replace("ResponderName", ResponderName); 
                      bw.write(RName);
                      bw.append('\n');
                      //System.out.println(RName);
                    }
                     else if(s.contains("PVA_URL"))
                    {
                      String RName=s.replace("PVA_URL", PVA_URL); 
                      if(RName.contains("Responder_Const"))
                      {
                          RName=RName.replace("Responder_Const", Responder_Const);
                      }
                      bw.write(RName);
                      bw.append('\n');
                      //System.out.println(RName);
                    }
                    else if(s.contains("Responder_Const"))
                    {
                      String RName=s.replace("Responder_Const", Responder_Const); 
                      bw.write(RName);
                      bw.append('\n');
                      //System.out.println(RName);
                    }
                    else if(s.contains("RequestType"))
                    {
                      String RName=s.replace("RequestType", RequestType); 
                      bw.write(RName);
                      bw.append('\n');
                      //System.out.println(RName);
                    }
                 }            
                 else
                    {
                        bw.write(s);
                        bw.append('\n');
                        //System.out.println(s);      
                    }
             }   
                
               bw.close();  
        }
        else
        {
           
            if(j==1)
            {
           while ((s = br.readLine()) != null) {
               
               System.out.println(i); 
               if(i>5)
                 {
                    System.out.println(1);  
                     break;
                 }
                 if(s.contains("PVAName")||s.contains("ResponderName")|| s.contains("PVA_URL") ||s.contains("Responder_Const")|| s.contains("RequestType") )
                 {
                     if(s.contains("PVAName"))
                    {
                      String PVA=s.replace("PVAName", PVAName);
                     
                      if(PVA.contains("ResponderName"))
                      {
                          PVA=PVA.replace("ResponderName", ResponderName);
                      }
			bw.write(PVA);
                        bw.append('\n');
                      //System.out.println(PVA);
                    }
                     else if(s.contains("ResponderName"))
                    {
                      String RName=s.replace("ResponderName", ResponderName); 
                      bw.write(RName);
                      bw.append('\n');
                      //System.out.println(RName);
                    }
                     else if(s.contains("PVA_URL"))
                    {
                      String RName=s.replace("PVA_URL", PVA_URL); 
                      if(RName.contains("Responder_Const"))
                      {
                          RName=RName.replace("Responder_Const", Responder_Const);
                      }
                      bw.write(RName);
                      bw.append('\n');
                      //System.out.println(RName);
                    }
                    else if(s.contains("Responder_Const"))
                    {
                      String RName=s.replace("Responder_Const", Responder_Const); 
                      bw.write(RName);
                      bw.append('\n');
                      //System.out.println(RName);
                    }
                    else if(s.contains("RequestType"))
                    {
                      String RName=s.replace("RequestType", RequestType); 
                      bw.write(RName);
                      bw.append('\n');
                      //System.out.println(RName);
                    }
                 }            
                 else
                    {
                        bw.write(s);
                        bw.append('\n');
                        //System.out.println(s);      
                    }
                i= i+1;
                 
             }   
               j=j+1; 
               bw.write("  s := string(hah)");
               bw.append('\n');
               bw.close(); 
               
            }
            else
            {
                 File Fun_Temp_1=new File("D:\\Fun_Template_1.go");
       // File Fun= new File("D:\\Function.go");
        FileWriter fw_1 = new FileWriter(Fun.getAbsoluteFile(),true);
        FileReader fr_1 = new FileReader(Fun_Temp_1);
        BufferedReader br_1 = new BufferedReader(fr_1);
        BufferedWriter bw_1 = new BufferedWriter(fw_1);
         String S;
         while (( S =br_1.readLine()) != null) {
         if(S.contains("PVAName")||S.contains("ResponderName")|| S.contains("PVA_URL") || S.contains("Responder_Const")|| S.contains("RequestType") )
                 {
                     if(S.contains("PVAName"))
                    {
                      String PVA=S.replace("PVAName", PVAName);
                     
                      if(PVA.contains("ResponderName"))
                      {
                          PVA=PVA.replace("ResponderName", ResponderName);
                      }
			bw_1.write(PVA);
                        bw_1.append('\n');
                      //System.out.println(PVA);
                    }
                     else if(S.contains("ResponderName"))
                    {
                      String RName=S.replace("ResponderName", ResponderName); 
                      bw_1.write(RName);
                      bw_1.append('\n');
                      //System.out.println(RName);
                    }
                     else if(S.contains("PVA_URL"))
                    {
                      String RName=S.replace("PVA_URL", PVA_URL); 
                      if(RName.contains("Responder_Const"))
                      {
                          RName=RName.replace("Responder_Const", Responder_Const);
                      }
                      bw_1.write(RName);
                      bw_1.append('\n');
                      //System.out.println(RName);
                    }
                    else if(S.contains("Responder_Const"))
                    {
                      String RName=S.replace("Responder_Const", Responder_Const); 
                      bw_1.write(RName);
                      bw_1.append('\n');
                      //System.out.println(RName);
                    }
                    else if(S.contains("RequestType"))
                    {
                      String RName=S.replace("RequestType", RequestType); 
                      bw_1.write(RName);
                      bw_1.append('\n');
                      //System.out.println(RName);
                    }
                 }            
                 else
                    {
                        bw_1.write(S);
                        bw_1.append('\n');
                        //System.out.println(s);      
                    }
         
         
            }
         j=j+1; 
         if(j==Reponder_Count+1)
         {
         bw_1.write("}");
         bw_1.append('\n');
         bw_1.write("}");
         bw_1.append('\n');
         }
          bw_1.close(); 
               
            }
        }
                
                
    } 
}
