/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.Bitcoin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import library.LibraryConnectDb;

/**
 *
 * @author vuongluis
 */
public class ModelBitCoin {

    private LibraryConnectDb lbdb;
    private Connection conn;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    private String table = "faucet";
    
    public ModelBitCoin(){
        lbdb = new LibraryConnectDb();
    }
    public ArrayList<Bitcoin> getList() {
        ArrayList<Bitcoin> alItems = new ArrayList<>();
        conn = lbdb.getConnectMySQL();
        try {
            st = conn.createStatement();
            rs = st.executeQuery(("SELECT * FROM "+table));
            while(rs.next()){
                alItems.add(new Bitcoin(rs.getInt("id"), rs.getString("typemoney"), rs.getString("url"), rs.getString("satoshi"), rs.getString("time"), rs.getString("captcha"), rs.getString("drawmoney"),rs.getBoolean("status")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelBitCoin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alItems;
    }

    public Bitcoin getItem(int id) {
        Bitcoin item = null;
        conn = lbdb.getConnectMySQL();
        try {
            pst = conn.prepareStatement("SELECT * FROM "+table+" WHERE id = ? LIMIT 1");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if(rs.next()){
                item = new Bitcoin(rs.getInt("id"), rs.getString("typemoney"), rs.getString("url"), rs.getString("satoshi"), rs.getString("time"), rs.getString("captcha"), rs.getString("drawmoney"),rs.getBoolean("status"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelBitCoin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return item;
    }

    public int addItem(Bitcoin bitcoin) {
        int id = 0;
        conn = lbdb.getConnectMySQL();
        String sql = "INSERT INTO "+table+"(typemoney,url,satoshi,time,captcha,drawmoney,status) VALUES(?,?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, bitcoin.getTypeofMoney());
            pst.setString(2, bitcoin.getUrl());
            pst.setString(3, bitcoin.getSatoshi());
            pst.setString(4, bitcoin.getTime());
            pst.setString(5, bitcoin.getTypeofCaptcha());
            pst.setString(6, bitcoin.getWithDrawMoney());
            pst.setBoolean(7, bitcoin.isStatus());
            id = pst.executeUpdate();
            rs = pst.getGeneratedKeys();
            if(rs.next()){
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelBitCoin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public int deleteItem(int id) {
        int result = 0;
        conn = lbdb.getConnectMySQL();
        try {
            pst = conn.prepareStatement("DELETE FROM "+table+" WHERE id = ? LIMIT 1");
            pst.setInt(1, id);
            result = pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ModelBitCoin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int editItem(Bitcoin bitcoin) {
        int result = 0;
        conn = lbdb.getConnectMySQL();
        String sql = "UPDATE "+table+" SET typemoney = ?,url = ?,satoshi = ?,time = ?,captcha = ?,drawmoney = ?,status = ? WHERE id = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, bitcoin.getTypeofMoney());
            pst.setString(2, bitcoin.getUrl());
            pst.setString(3, bitcoin.getSatoshi());
            pst.setString(4, bitcoin.getTime());
            pst.setString(5, bitcoin.getTypeofCaptcha());
            pst.setString(6, bitcoin.getWithDrawMoney());
            pst.setBoolean(7, bitcoin.isStatus());
            pst.setInt(8, bitcoin.getId());
            result = pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ModelBitCoin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
