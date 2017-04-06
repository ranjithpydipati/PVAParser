/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pva_parser;

/**
 *
 * @author 441683
 */


import java.io.BufferedReader;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
public class PVA_Parser {

    /**
     * @param args the command line arguments
     */
    public static NodeList LiteralMessage= null;
    public static NodeList Responder_Name = null;
    public static NodeList Responder_Type = null;
    public static NodeList Responders_Clinet = null;
    public static NodeList XMLDataBank_Variables= null;
    public static NodeList Response_Variables= null;
    public static NodeList XMLDataBank_ExtractXPath= null;
    public static HashMap Responce = new HashMap();
    public static String XML_responce = null;
    public static String PVAName= null;
    
    public static void main(String[] args) {
        
        
        //String JsonPath="`xml:\"";
        // TODO code application logic here
        
      /* String zipFilePath = "C:\\Users\\441683\\Desktop\\Einstein_IndTools.pva";
        String destDirectory = "C:\\Users\\441683\\Desktop\\";
        UnZipPVA unzipper = new UnZipPVA();
        try {
            unzipper.unzip(zipFilePath,destDirectory);
        } catch (IOException ex) {
            Logger.getLogger(PVA_Parser.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        try {
                //unzipper.unzip(zipFilePath,destDirectory);
                File fXmlFile = new File("D:\\Einstein_CXP\\Einstein_CXP.xml");
                PVAName=fXmlFile.getName().replaceFirst("[.][^.]+$", "");
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(fXmlFile);
                Element docEle = doc.getDocumentElement();
                
                //ClientTester is the Tag to get Responder level Inforamtion
                //Pulling Responder inforamtion
                Responders_Clinet = docEle.getElementsByTagName("ClientTesterTest");
                
        
                for(int i = 0; i < Responders_Clinet.getLength(); i++) {
                    //Node childNode = childNodes.item(i);
                     LiteralMessage = ((Element)Responders_Clinet.item(i)).getElementsByTagName("ClientTester_LiteralMessage");
                    
                     Responder_Name = ((Element)Responders_Clinet.item(i)).getElementsByTagName("name");
                     
                     Responder_Type = ((Element)Responders_Clinet.item(i)).getElementsByTagName("type");
                     //System.out.println(Responders_Clinet.getLength());
                     Response_Variables= ((Element)Responders_Clinet.item(i)).getElementsByTagName("valueColumnName");
                     
                     XMLDataBank_ExtractXPath=((Element)Responders_Clinet.item(i)).getElementsByTagName("XMLDataBank_ExtractXPath");
                     
                     XMLDataBank_Variables= ((Element)Responders_Clinet.item(i)).getElementsByTagName("customName");
                             
                       // System.out.println(Responder_Name.item(1).getTextContent());
                    for(int j = 0; j < LiteralMessage.getLength(); j++) {
                        Node current = LiteralMessage.item(j);       
                        Responce.put(Responder_Name.item(1).getTextContent(), current.getTextContent());
                        
                       // System.out.println(Responce.get(Responder_Name.item(1).getTextContent()));
                         //System.out.println(Response_Variables.getLength());
                         if(Response_Variables.getLength() != 0)
                         {
                         for(int k=0;k<Response_Variables.getLength();k++)
                         {
                             String XML_R= Responce.get(Responder_Name.item(1).getTextContent()).toString();
                             if(k==0)
                             {
                             XML_responce= XML_R.replace("${"+Response_Variables.item(k).getTextContent()+"}", "'+ h."+Response_Variables.item(k).getTextContent()+" +'");
                             }
                             else
                             {
                             XML_responce= XML_responce.replace("${"+Response_Variables.item(k).getTextContent()+"}", "'+ h."+Response_Variables.item(k).getTextContent()+" +'");
                             }
                             //System.out.println(XML_DataBank.item(k).getTextContent());
                            
                         }
                    }
                         else
                         {
                            XML_responce= Responce.get(Responder_Name.item(1).getTextContent()).toString();
                         }
                        for(int l=0;l<XMLDataBank_ExtractXPath.getLength();l++)
                         {
                             String XML_Xpath=XMLDataBank_ExtractXPath.item(l).getTextContent();
                             String XMl_X=XML_Xpath.replace("/*:Envelope/*", "");
                             //  System.out.println(XMl_X);
                             //String Jpath=GOCreation.JsonPathCreation(XMl_X);
                             String JsonXpath=XMLDataBank_Variables.item(l).getTextContent()+" string "+GOCreation.JsonPathCreation(XMl_X);
                             //String XML_y=XMl_X.substring(XMl_X.indexOf(":")+1, XMl_X.indexOf("["));  
                           //System.out.println(JsonXpath);
                         }
                        
                      String r= Responder_Type.item(0).getTextContent() .replaceAll("[^a-zA-Z0-9]+","");
                        System.out.println(r);
                         GOCreation.GoFileCreation(PVAName,Responder_Name.item(1).getTextContent(),XML_responce);
                         MainGoCreation.MainFunctionCreation(PVAName.toLowerCase(), Responder_Name.item(1).getTextContent(), "CXP_URL", Responder_Name.item(1).getTextContent().toUpperCase(),Responder_Type.item(0).getTextContent(),Responders_Clinet.getLength());
                         
                    }
                   
                }
                
                
    
                
            }
         catch (Exception e)
         {
            e.printStackTrace();
         }
    }
    
}
