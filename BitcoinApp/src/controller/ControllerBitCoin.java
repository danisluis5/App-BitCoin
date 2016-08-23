/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Bitcoin;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import library.LibraryString;
import model.ModelBitCoin;

/**
 *
 * @author vuongluis
 */
/** Writing code before after connect view **/
public class ControllerBitCoin extends AbstractTableModel{

    private ArrayList<Bitcoin> alItems = new ArrayList<>();
    private ModelBitCoin model;
    
    private String cols[] = {
        "<html><strong>ID</strong></html>",
        "<html><strong>WEBSITE</strong></html>",
        "<html><strong>SATOSHI</strong></html>",
        "<html><strong>TIME</strong></html>",
        "<html><strong>WITHDRAW</strong></html>"
    };
    private JTable table;
    
    public ControllerBitCoin(JTable table){
        this.table = table;
        model = new ModelBitCoin();
        alItems = model.getList();
    }
    @Override
    public int getRowCount() {
        return alItems.size();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Bitcoin obBitcoin = alItems.get(rowIndex);
        Object result = null;
        switch(columnIndex){
            case 0:
                result = obBitcoin.getId();
                break;
            case 1:
                result = new LibraryString().subString(obBitcoin.getUrl());
                break;
            case 2:
                result = obBitcoin.getSatoshi();
                break;
            case 3:
                result = Integer.parseInt(obBitcoin.getTime());
                break;
            case 4:
                result = obBitcoin.getWithDrawMoney();
                break;
        }
        return result;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex == 0){
            return Integer.class;
        }else if(columnIndex == 3){
            return Integer.class;
        }
        return  super.getColumnClass(columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        return cols[column];
    }
    
    public void initTable(){
        table.setModel(this);
        
        table.getTableHeader().setPreferredSize(new Dimension(0, 30));
        table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 11));
        
        table.setRowHeight(26);
        table.setFont(new Font("Tahoma", Font.BOLD, 11));
        
        table.getColumnModel().getColumn(0).setPreferredWidth(40);
        table.getColumnModel().getColumn(1).setPreferredWidth(140);
        table.getColumnModel().getColumn(2).setPreferredWidth(80);
        table.getColumnModel().getColumn(3).setPreferredWidth(60);
        table.getColumnModel().getColumn(4).setPreferredWidth(120);
    }

    public int addItem(Bitcoin bitcoin) {
        // thêm vào cơ sỡ dữ liệu
        int id = model.addItem(bitcoin);
        bitcoin.setId(id);
        // thêm vào model
        alItems.add(bitcoin);
        this.fireTableDataChanged();
        table.scrollRectToVisible(table.getCellRect(this.getRowCount()-1, 0, true));
        return id;
    }

    public int deleteItem(int id, int row) {
        // xóa trong cơ sỡ dữ liệu
        int result = model.deleteItem(id);
        // xóa trong model
        int rowmodel = table.convertRowIndexToModel(row);
        alItems.remove(rowmodel);
        this.fireTableDataChanged();
        return result;
    }

    public int editItem(Bitcoin bitcoin,int row) {
        // cập nhật trong cơ sỡ dữ liệu
        int result = model.editItem(bitcoin);
        // cập nhật trong model
        int rowmodel = table.convertRowIndexToModel(row);
        alItems.set(rowmodel, bitcoin);
        this.fireTableDataChanged();
        return result;
    }
}
