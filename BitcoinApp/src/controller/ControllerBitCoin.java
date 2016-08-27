/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Bitcoin;
import java.awt.Color;
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
        "<html><strong>STT</strong></html>",
        "<html><strong>MONEY</strong></html>",
        "<html><strong>WEBSITE</strong></html>",
        "<html><strong>SATOSHI</strong></html>",
        "<html><strong>TIME</strong></html>",
        "<html><strong>CAPTCHA</strong></html>",
        "<html><strong>WITHDRAW</strong></html>",
        "<html><strong>PAYING</strong></html>"
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
                result = obBitcoin.getTypeofMoney();
                break;
            case 2:
                result = new LibraryString().subString(obBitcoin.getUrl());
                break;
            case 3:
                result = obBitcoin.getSatoshi();
                break;
            case 4:
                result = Integer.parseInt(obBitcoin.getTime());
                break;
            case 5:
                result = obBitcoin.getTypeofCaptcha();
                break;
            case 6:
                result = obBitcoin.getWithDrawMoney();
                break;
            case 7:
                result = obBitcoin.isStatus();
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
        }else if(columnIndex == 4){
            return Integer.class;
        }else if(columnIndex == 7){
            return Boolean.class;
        }
        return  super.getColumnClass(columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        return cols[column];
    }

    
    public void initTable(){
        table.setModel(this);
        table.getTableHeader().setForeground(Color.decode("#a90834"));
        table.setBackground(Color.decode("#0e0e0e"));
        table.setForeground(Color.decode("#295159"));
        // ((JComponent)table.getDefaultRenderer(Boolean.class)).setOpaque(true);     
        
        table.getTableHeader().setPreferredSize(new Dimension(0, 30));
        table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 11));
        
        table.setRowHeight(26);
        table.setFont(new Font("Tahoma", Font.BOLD, 11));
        
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(0).setResizable(false);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(1).setResizable(false);
        table.getColumnModel().getColumn(2).setPreferredWidth(500);
        table.getColumnModel().getColumn(2).setResizable(false);
        table.getColumnModel().getColumn(3).setPreferredWidth(200);
        table.getColumnModel().getColumn(3).setResizable(false);
        table.getColumnModel().getColumn(4).setPreferredWidth(150);
        table.getColumnModel().getColumn(4).setResizable(false);
        table.getColumnModel().getColumn(5).setPreferredWidth(200);
        table.getColumnModel().getColumn(5).setResizable(false);
        table.getColumnModel().getColumn(6).setPreferredWidth(250);
        table.getColumnModel().getColumn(6).setResizable(false);
        table.getColumnModel().getColumn(7).setPreferredWidth(150);
        table.getColumnModel().getColumn(7).setResizable(false);
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
