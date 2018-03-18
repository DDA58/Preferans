package main.model;

import java.util.ArrayList;
import java.util.List;

public class Distribution {
    private int IDDistr;
    private List<Card> crdbot1;
    private List<Card> crdbot2;
    private List<Card> crdbot3;
    private List<Card> crddistr;
    private int kolvoVziatBot1;
    private int kolvoVziatBot2;
    private int kolvoVziatBot3;
    private int hillB1; // гора
    private int bulletB1; // пуля
    private double vistaB1onB2;
    private double vistaB1onB3;
    private int hillB2; // гора
    private int bulletB2; // пуля
    private double vistaB2onB1;
    private double vistaB2onB3;
    private int hillB3; // гора
    private int bulletB3; // пуля
    private double vist1B;
    private double vist2B;
    private double vist3B;

    public double getVist1B() {
        return vist1B;
    }

    public void setVist1B(double vist1B) {
        this.vist1B = vist1B;
    }

    public double getVist2B() {
        return vist2B;
    }

    public void setVist2B(double vist2B) {
        this.vist2B = vist2B;
    }

    public double getVist3B() {
        return vist3B;
    }

    public void setVist3B(double vist3B) {
        this.vist3B = vist3B;
    }

    public int getKolvoVziatBot1() {
        return kolvoVziatBot1;
    }

    public void setKolvoVziatBot1(int kolvoVziatBot1) {
        this.kolvoVziatBot1 = kolvoVziatBot1;
    }

    public int getKolvoVziatBot2() {
        return kolvoVziatBot2;
    }

    public void setKolvoVziatBot2(int kolvoVziatBot2) {
        this.kolvoVziatBot2 = kolvoVziatBot2;
    }

    public int getKolvoVziatBot3() {
        return kolvoVziatBot3;
    }

    public void setKolvoVziatBot3(int kolvoVziatBot3) {
        this.kolvoVziatBot3 = kolvoVziatBot3;
    }

    public int getHillB1() {
        return hillB1;
    }

    public void setHillB1(int hillB1) {
        this.hillB1 = hillB1;
    }

    public int getBulletB1() {
        return bulletB1;
    }

    public void setBulletB1(int bulletB1) {
        this.bulletB1 = bulletB1;
    }

    public double getVistaB1onB2() {
        return vistaB1onB2;
    }

    public void setVistaB1onB2(double vistaB1onB2) {
        this.vistaB1onB2 = vistaB1onB2;
    }

    public double getVistaB1onB3() {
        return vistaB1onB3;
    }

    public void setVistaB1onB3(double vistaB1onB3) {
        this.vistaB1onB3 = vistaB1onB3;
    }

    public int getHillB2() {
        return hillB2;
    }

    public void setHillB2(int hillB2) {
        this.hillB2 = hillB2;
    }

    public int getBulletB2() {
        return bulletB2;
    }

    public void setBulletB2(int bulletB2) {
        this.bulletB2 = bulletB2;
    }

    public double getVistaB2onB1() {
        return vistaB2onB1;
    }

    public void setVistaB2onB1(double vistaB2onB1) {
        this.vistaB2onB1 = vistaB2onB1;
    }

    public double getVistaB2onB3() {
        return vistaB2onB3;
    }

    public void setVistaB2onB3(double vistaB2onB3) {
        this.vistaB2onB3 = vistaB2onB3;
    }

    public int getHillB3() {
        return hillB3;
    }

    public void setHillB3(int hillB3) {
        this.hillB3 = hillB3;
    }

    public int getBulletB3() {
        return bulletB3;
    }

    public void setBulletB3(int bulletB3) {
        this.bulletB3 = bulletB3;
    }

    public double getVistaB3onB2() {
        return vistaB3onB2;
    }

    public void setVistaB3onB2(double vistaB3onB2) {
        this.vistaB3onB2 = vistaB3onB2;
    }

    public double getVistaB3onB1() {
        return vistaB3onB1;
    }

    public void setVistaB3onB1(double vistaB3onB1) {
        this.vistaB3onB1 = vistaB3onB1;
    }

    private double vistaB3onB2;
    private double vistaB3onB1;

    public int getIDDistr() {
        return IDDistr;
    }

    public void setIDDistr(int IDDistr) {
        this.IDDistr = IDDistr;
    }

    public List<Card> getCrdbot1() {
        return crdbot1;
    }

    public void setCrdbot1(List<Card> crdbot1) {
        this.crdbot1 = crdbot1;
    }

    public List<Card> getCrdbot2() {
        return crdbot2;
    }

    public void setCrdbot2(List<Card> crdbot2) {
        this.crdbot2 = crdbot2;
    }

    public List<Card> getCrdbot3() {
        return crdbot3;
    }

    public void setCrdbot3(List<Card> crdbot3) {
        this.crdbot3 = crdbot3;
    }

    public List<Card> getCrddistr() {
        return crddistr;
    }

    public void setCrddistr(List<Card> crddistr) {
        this.crddistr = crddistr;
    }

   /* public String getFirstBotNameTrade() {
        return firstBotNameTrade;
    }

    public void setFirstBotNameTrade(String firstBotNameTrade) {
        this.firstBotNameTrade = firstBotNameTrade;
    }*/
}
