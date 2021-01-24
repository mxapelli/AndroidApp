package edu.upc.androidapp;

public class Achievements {
    private int calcAch;
    private int electronicsAch;
    private int commsAch;
    private int oescAch;
    private int dsaAch;
    private int aeroAch;
    private int tfgAch;
    private String id;

    public Achievements(int calcAch, int electronicsAch, int commsAch, int oescAch, int dsaAch, int aeroAch, int tfgAch, String id) {
        this.calcAch = calcAch;
        this.electronicsAch = electronicsAch;
        this.commsAch = commsAch;
        this.oescAch = oescAch;
        this.dsaAch = dsaAch;
        this.aeroAch = aeroAch;
        this.tfgAch = tfgAch;
        this.id = id;
    }
    public Achievements(){}

    public int getCalcAch() {
        return calcAch;
    }

    public void setCalcAch(int calcAch) {
        this.calcAch = calcAch;
    }

    public int getElectronicsAch() {
        return electronicsAch;
    }

    public void setElectronicsAch(int electronicsAch) {
        this.electronicsAch = electronicsAch;
    }

    public int getCommsAch() {
        return commsAch;
    }

    public void setCommsAch(int commsAch) {
        this.commsAch = commsAch;
    }

    public int getOescAch() {
        return oescAch;
    }

    public void setOescAch(int oescAch) {
        this.oescAch = oescAch;
    }

    public int getDsaAch() {
        return dsaAch;
    }

    public void setDsaAch(int dsaAch) {
        this.dsaAch = dsaAch;
    }

    public int getAeroAch() {
        return aeroAch;
    }

    public void setAeroAch(int aeroAch) {
        this.aeroAch = aeroAch;
    }

    public int getTfgAch() {
        return tfgAch;
    }

    public void setTfgAch(int tfgAch) {
        this.tfgAch = tfgAch;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
