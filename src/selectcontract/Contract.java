/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectcontract;

/**
 *
 * @author C0472523
 */
public class Contract {
    String contractID, originCity, destCity, orderItem;
    
    public Contract(String contractID, String originCity, String destCity, String orderItem) {
        this.contractID = contractID;
        this.originCity = originCity;
        this.destCity = destCity;
        this.orderItem = orderItem;
    }
    
    public String getContractID() {
            return contractID;
        }
        
        public String getOriginCity() {
            return originCity;
        }
        
        public String getDestCity() {
            return destCity;
        }
        
        public String getOrderItem() {
            return orderItem;
        }
}
    

