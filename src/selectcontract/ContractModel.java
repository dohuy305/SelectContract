/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectcontract;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author C0472523
 */
class ContractModel {
    protected ArrayList<Contract> theContracts;
    private int contractCounter;
    public static final int NUMBER_OF_CONTRACT_ATTRIBUTES = 4 ;
    public static final int INDEX_OF_CONTRACT_ID = 0;
    public static final int INDEX_OF_ORIGIN_CITY = 1;
    public static final int INDEX_OF_DEST_CITY = 2;
    public static final int INDEX_OF_ORDER_ITEM = 3;
    
    public ContractModel() {
        contractCounter = 0;
        theContracts = new ArrayList<Contract>();
        String filename = "M:\\SelectContract\\src\\selectcontract\\contracts.txt";
        
        try(
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            
            while((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split(",", NUMBER_OF_CONTRACT_ATTRIBUTES);
                
                String contractID = tokens[INDEX_OF_CONTRACT_ID];
                String originCity = tokens[INDEX_OF_ORIGIN_CITY];
                String destCity = tokens[INDEX_OF_DEST_CITY];
                String orderItem = tokens[INDEX_OF_ORDER_ITEM];
                
                Contract dataContract = new Contract(contractID, originCity, destCity, orderItem);
                
                theContracts.add(dataContract);
            }
            fileReader.close();
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    boolean foundContract() {
        if(theContracts.size() > 0) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public Contract getTheContract() {
        return theContracts.get(contractCounter);
    }
    
    public int getContractCount() {
        return theContracts.size();
    }
    
    public int getCurrentContractNum() {
        return contractCounter;
    }
    
    public void nextContract() {
        if(contractCounter < theContracts.size()) {
            contractCounter++;
        }
    }
    
    public void prevContract() {
        if(contractCounter > -1) {
            contractCounter--;
        }
    }

    void bidContract() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    

