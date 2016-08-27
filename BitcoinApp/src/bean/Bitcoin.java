/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author vuongluis
 */
public class Bitcoin {
    private int id;
    private String typeofMoney;
    private String url;
    private String satoshi;
    private String time;
    private String typeofCaptcha;
    private String withDrawMoney;
    private boolean status;

    public Bitcoin(){    
    }
    
    public Bitcoin(int id, String typeofMoney, String url, String satoshi, String time, String typeofCaptcha, String withDrawMoney,boolean status) {
        this.id = id;
        this.typeofMoney = typeofMoney;
        this.url = url;
        this.satoshi = satoshi;
        this.time = time;
        this.typeofCaptcha = typeofCaptcha;
        this.withDrawMoney = withDrawMoney;
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public int getId() {
        return id;
    }

    public String getTypeofMoney() {
        return typeofMoney;
    }

    public String getUrl() {
        return url;
    }

    public String getSatoshi() {
        return satoshi;
    }

    public String getTime() {
        return time;
    }

    public String getTypeofCaptcha() {
        return typeofCaptcha;
    }

    public String getWithDrawMoney() {
        return withDrawMoney;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTypeofMoney(String typeofMoney) {
        this.typeofMoney = typeofMoney;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setSatoshi(String satoshi) {
        this.satoshi = satoshi;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setTypeofCaptcha(String typeofCaptcha) {
        this.typeofCaptcha = typeofCaptcha;
    }

    public void setWithDrawMoney(String withDrawMoney) {
        this.withDrawMoney = withDrawMoney;
    }
}
