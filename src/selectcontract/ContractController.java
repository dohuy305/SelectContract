/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectcontract;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author C0472523
 */
class ContractController {

    
        
        private ContractView theView;
        private ContractModel theModel;
        
        public ContractController(ContractView theView, ContractModel theModel) {
        
            this.theView = theView;
            this.theModel = theModel;
            this.theView.addPrevListener(new PrevButtonListener());
            this.theView.addBidListener(new BidButtonListener());
            this.theView.addNextListener(new NextButtonListener());
        
        setUpDisplay();
    }
    class PrevButtonListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(theModel.getCurrentContractNum() == 0) {
                    return;
                }
                try {
                    theModel.prevContract();
                }
                catch (Exception ex) {
                    System.out.println(ex);
                    theView.displayErrorMessage("Error: There is a problem setting a previous contract.");
                }
                setUpDisplay();
            }
        }
    
    class BidButtonListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(theModel.getCurrentContractNum() == 0) {
                    return;
                }
                try {
                    theModel.bidContract();
                }
                catch (Exception ex) {
                    System.out.println(ex);
                    theView.displayErrorMessage("Error: There is a problem setting a previous contract.");
                }
                setUpDisplay();
            }
        }
    
    class NextButtonListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(theModel.getCurrentContractNum() >= theModel.theContracts.size()) {
                    return;
                }
                try {
                    theModel.nextContract();
                }
                catch (Exception ex) {
                    System.out.println(ex);
                    theView.displayErrorMessage("Error: There is a problem setting a previous contract.");
                }
                setUpDisplay();
            }
        }
    
    private void setUpDisplay() {
        try {
            
            if(theModel.getCurrentContractNum() < theModel.theContracts.size() -1) {
                theView.setJNextButtonEnable(true);
            }
            else {
                theView.setJNextButtonEnable(false);
            }
            
            if(theModel.getCurrentContractNum() > 0) {
                theView.setJPrevButtonEnable(true);
            }
            else {
                theView.setJPrevButtonEnable(false);
            }
            
            if(theModel.foundContract() == true) {
                Contract c = theModel.getTheContract();
                theView.setContractID(c.getContractID());
                theView.setDestCity(c.getDestCity());
                theView.setOriginCity(c.getOriginCity());
                theView.setOrderItem(c.getOrderItem());
            }
            else {
                theView.setContractID("???");
                theView.setDestCity("???");
                theView.setOriginCity("???");
                theView.setOrderItem("???");
            }
        }
        catch (Error ex){
            System.out.println(ex);
            theView.displayErrorMessage("Error: There was a problem setting the contract. \n" + "          Contract number: " + theModel.getCurrentContractNum());
        }
        
        theView.updateContractViewPanel(theModel.getCurrentContractNum(), theModel.theContracts.size());
    }
}
