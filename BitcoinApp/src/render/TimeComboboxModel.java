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
public class TimeComboboxModel implements ComboBoxModel{

    private ArrayList<String> alItems = new ArrayList<>();
    private Object object = new Object();
            
    public TimeComboboxModel(){
        alItems.add("3");
        alItems.add("5");
        alItems.add("10");
        alItems.add("15");
        alItems.add("20");
        alItems.add("60");
        alItems.add("90");
        alItems.add("120");
        alItems.add("140");
        alItems.add("180");
        alItems.add("240");
        alItems.add("300");
        alItems.add("360");
        alItems.add("480");
        alItems.add("720");
        alItems.add("900");
        alItems.add("1000");
        alItems.add("1440");
        object = alItems.get(0);
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
