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
        alItems.add("1");
        alItems.add("3");
        alItems.add("5");
        alItems.add("10");
        alItems.add("15");
        alItems.add("30");
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
    public TimeComboboxModel(String temp){
        alItems.add("1");
        alItems.add("3");
        alItems.add("5");
        alItems.add("10");
        alItems.add("15");
        alItems.add("30");
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
        switch(temp){
            case "1":
                object = alItems.get(0);
                break;
            case "3":
                object = alItems.get(1);
                break;
            case "5":
                object = alItems.get(2);
                break;
            case "10":
                object = alItems.get(3);
                break;
            case "15":
                object = alItems.get(4);
                break;
            case "30":
                object = alItems.get(5);
                break;
            case "60":
                object = alItems.get(6);
                break;
            case "90":
                object = alItems.get(7);
                break;
            case "120":
                object = alItems.get(8);
                break;
            case "140":
                object = alItems.get(9);
                break;
            case "180":
                object = alItems.get(10);
                break;
            case "240":
                object = alItems.get(11);
                break;
            case "300":
                object = alItems.get(12);
                break;
            case "360":
                object = alItems.get(13);
                break;
            case "480":
                object = alItems.get(14);
                break;
            case "720":
                object = alItems.get(15);
                break;
            case "900":
                object = alItems.get(16);
                break;
            case "1000":
                object = alItems.get(17);
                break;
            case "1400":
                object = alItems.get(18);
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
