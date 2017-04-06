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
public class Main {
    
    public static void main(String[] args) {
        String zipFilePath = "D:\\Einstein_CXP.pva";
        String destDirectory = "D:\\Einstein_CXP_1";
        UnZipPVA unzipper = new UnZipPVA();
        try {
            unzipper.unzip(zipFilePath, destDirectory);
        } catch (Exception ex) {
            // some errors occurred
            ex.printStackTrace();
        }
    }
    
}
