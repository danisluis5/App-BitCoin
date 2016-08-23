/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package render;

import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author vuongluis
 */
public class MoneyComboboxModel implements ComboBoxModel{

    private ArrayList<String> alItems = new ArrayList<>();
    private Object object = new Object();
    
    public MoneyComboboxModel(){
        alItems.add("BTC");
        alItems.add("Doge");
        alItems.add("LTC");
        object = alItems.get(0); 
    }
    public MoneyComboboxModel(String temp){
        alItems.add("BTC");
        alItems.add("Doge");
        alItems.add("LTC");
        switch(temp){
            case "BTC":
                object = alItems.get(0);
                break;
            case "Doge":
                object = alItems.get(1);
                break;
            case "LTC":
                object = alItems.get(2);
                break;
            default:
               object = alItems.get(0);
        }
    }
    @Override
    public void setSelectedItem(Object anItem) {
        object = anItem;
    }

    @Override
    public Object getSelectedItem() {
        return object;
    }

    @Override
    public int getSize() {
        return alItems.size();
    }

    @Override
    public Object getElementAt(int index) {
        return alItems.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        //
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        //
    }
    
}
