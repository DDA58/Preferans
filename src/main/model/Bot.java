package main.model;

import main.controller.GameStrategy;

import java.lang.reflect.Array;
import java.util.List;

public class Bot {
    private String name; // имя бота
    private int hill; // гора
    private int bullet; // пуля
    private double ownVista; // собственная виста
    // висты относительно других ботов
    private double vista1;
    private double vista2;
    private int OstKozir;
    private List<Card> cards;
    private String strategyBot;
    private String strategyBot2;
    private String zayvkaPriKontrakte;
    private int valueContract;
    private int colorContract;
    private boolean winnerOneStep;
    private int kolvovziatok;
    public int valueVist;


    public int getValueVist() {
        return valueVist;
    }

    public void setValueVist(int valueVist) {
        this.valueVist = valueVist;
    }

    public int getOstKozir() {
        return OstKozir;
    }

    public void setOstKozir(int ostKozir) {
        OstKozir = ostKozir;
    }
    // Карты бота после раздачи

    public boolean isWinnerOneStep() {
        return winnerOneStep;
    }

    public void setWinnerOneStep(boolean winnerOneStep) {

        this.winnerOneStep = winnerOneStep;
    }

    public int getKolvovziatok() {
        return kolvovziatok;
    }

    public void setKolvovziatok(int kolvovziatok) {
        this.kolvovziatok = kolvovziatok;
    }



    public int getValueContract() {
        return valueContract;
    }

    public void setValueContract(int valueContract) {
        this.valueContract = valueContract;
    }

    public int getColorContract() {
        return colorContract;
    }

    public void setColorContract(int colorContract) {
        this.colorContract = colorContract;
    }

    public String getZayvkaPriKontrakte() {
        return zayvkaPriKontrakte;
    }

    public void setZayvkaPriKontrakte(String zayvkaPriKontrakte) {
        this.zayvkaPriKontrakte = zayvkaPriKontrakte;
    }

    public String getStrategyBot2() {
        return strategyBot2;
    }

    public void setStrategyBot2(String strategyBot2) {
        this.strategyBot2 = strategyBot2;
    }


    public String getStrategyBot() {
        return strategyBot;
    }

    public void setStrategyBot(String strategyBot) {
        this.strategyBot = strategyBot;
    }

    private  int NumberOfSpades;
    private  int NumberOfClubs;
    private  int NumberOfDiamonds;
    private  int NumberOfHearts;
    public int [][] mas = new int[2][4];

    public int[][]  createMassiv() {
        mas[0][0] = 0;
        mas[0][1] = 1;
        mas[0][2] = 2;
        mas[0][3] = 3;
        mas[1][0] = NumberOfSpades;
        mas[1][1] = NumberOfClubs;
        mas[1][2] = NumberOfDiamonds;
        mas[1][3] = NumberOfHearts;
        for (int i = 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                //Сравниваем элементы попарно,
                //если они имеют неправильный порядок,
                //то меняем местами
                if (mas[1][j] > mas[1][j + 1] ){
                    int tmp = mas[1][j];
                    int tmp2 = mas[0][j];
                    mas[1][j] = mas[1][j + 1];
                    mas[0][j] = mas[0][j+1];
                    mas[1][j + 1] = tmp;
                    mas[0][j + 1] = tmp2;
                }

            }
        }
        return mas;
    }


    public int[][] getMas() {
        return mas;
    }

    public void setMas(int[][] mas) {
        this.mas = mas;
    }

    public int getNumberOfSpades() {
        return NumberOfSpades;
    }

    public void setNumberOfSpades(int numberOfSpades) {
        NumberOfSpades = numberOfSpades;
    }

    public int getNumberOfClubs() {
        return NumberOfClubs;
    }

    public void setNumberOfClubs(int numberOfClubs) {
        NumberOfClubs = numberOfClubs;
    }

    public int getNumberOfDiamonds() {
        return NumberOfDiamonds;
    }

    public void setNumberOfDiamonds(int numberOfDiamonds) {
        NumberOfDiamonds = numberOfDiamonds;
    }

    public int getNumberOfHearts() {
        return NumberOfHearts;
    }

    public void setNumberOfHearts(int numberOfHearts) {
        NumberOfHearts = numberOfHearts;
    }

    public Bot() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHill() {
        return hill;
    }

    public void setHill(int hill) {
        this.hill = hill;
    }

    public int getBullet() {
        return bullet;
    }

    public void setBullet(int bullet) {
        this.bullet = bullet;
    }

    public double getOwnVista() {
        return ownVista;
    }

    public void setOwnVista(double ownVista) {
        this.ownVista = ownVista;
    }

    public double getVista1() {
        return vista1;
    }

    public void setVista1(double vista1) {
        this.vista1 = vista1;
    }

    public double getVista2() {
        return vista2;
    }

    public void setVista2(double vista2) {
        this.vista2 = vista2;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

}
