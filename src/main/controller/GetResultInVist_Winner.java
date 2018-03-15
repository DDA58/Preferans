package main.controller;

import main.model.Bot;

import java.util.stream.Stream;

public class GetResultInVist_Winner {
    public  void resultInVist (Bot bot1, Bot bot2, Bot bot3) {

        Stream<Integer> str = Stream.of(bot1.getBullet(), bot2.getBullet(),bot3.getBullet());
        int maxBul = str.max(Integer::compareTo).get();
        int otherHill1 = maxBul-bot1.getBullet()+bot1.getHill();
        int otherHill2 = maxBul-bot2.getBullet()+bot2.getHill();
        int otherHill3 = maxBul-bot3.getBullet()+bot3.getHill();
        Stream<Integer> str2 = Stream.of(otherHill1, otherHill2, otherHill3);
        int minOtherHill = str2.min(Integer::compareTo).get();
        int otherHill11 = otherHill1-minOtherHill;
        int otherHill22 = otherHill2-minOtherHill;
        int otherHill33 = otherHill3-minOtherHill;
        double otherVist2_1 = otherHill11*2.5+bot2.getVista1();
        double otherVist3_1 = otherHill11*2.5+bot3.getVista1();
        double otherVist1_2 = otherHill22*2.5+bot1.getVista1();
        double otherVist3_2 = otherHill22*2.5+bot3.getVista2();
        double otherVist1_3 = otherHill33*2.5+bot1.getVista2();
        double otherVist2_3 = otherHill33*2.5+bot2.getVista2();
        double oootherVist1_2;
        double oootherVist2_1;
        double oootherVist1_3;
        double oootherVist3_1;
        double oootherVist2_3;
        double oootherVist3_2;
        if(otherVist1_2>otherVist2_1) {
             oootherVist1_2 = otherVist1_2-otherVist2_1;
             oootherVist2_1 = -oootherVist1_2;
        }
        else {
            oootherVist2_1 = otherVist2_1-otherVist1_2;
            oootherVist1_2 = -oootherVist2_1;
        }

        if(otherVist1_3>otherVist3_1) {
            oootherVist1_3 = otherVist1_3-otherVist3_1;
            oootherVist3_1 = -oootherVist1_3;
        }
        else {
            oootherVist3_1 = otherVist3_1-otherVist1_3;
            oootherVist1_3 = -oootherVist3_1;
        }

        if(otherVist2_3>otherVist3_2) {
            oootherVist2_3 = otherVist2_3-otherVist3_2;
            oootherVist3_2 = -oootherVist2_3;
        }
        else {
            oootherVist3_2 = otherVist3_2-otherVist2_3;
            oootherVist2_3 = -oootherVist3_2;
        }
        bot1.setOwnVista(oootherVist1_2+oootherVist1_3);
        bot2.setOwnVista(oootherVist2_1+oootherVist2_3);
        bot3.setOwnVista(oootherVist3_1+oootherVist3_2);
        System.out.println("Вистов у "+bot1.getName()+": "+bot1.getOwnVista());
        System.out.println("Вистов у "+bot2.getName()+": "+bot2.getOwnVista());
        System.out.println("Вистов у "+bot3.getName()+": "+bot3.getOwnVista());
        Stream<Double> str3 = Stream.of(bot1.getOwnVista(), bot2.getOwnVista(),bot3.getOwnVista());
        double maxOwnVist = str3.max(Double::compareTo).get();
        if(bot1.getOwnVista()==maxOwnVist&bot2.getOwnVista()!=maxOwnVist&bot3.getOwnVista()!=maxOwnVist) {
            System.out.println(bot1.getName()+" Победил ");
        }
        if(bot2.getOwnVista()==maxOwnVist&bot1.getOwnVista()!=maxOwnVist&bot3.getOwnVista()!=maxOwnVist) {
            System.out.println(bot2.getName()+" Победил ");
        }
        if(bot3.getOwnVista()==maxOwnVist&bot2.getOwnVista()!=maxOwnVist&bot1.getOwnVista()!=maxOwnVist) {
            System.out.println(bot3.getName()+" Победил ");
        }
        if(bot1.getOwnVista()==maxOwnVist&bot2.getOwnVista()==maxOwnVist) {
            System.out.println("Ничья между: "+bot1.getName()+" и "+bot2.getName());
        }
        if(bot1.getOwnVista()==maxOwnVist&bot3.getOwnVista()==maxOwnVist) {
            System.out.println("Ничья между: "+bot1.getName()+" и "+bot3.getName());
        }
        if(bot3.getOwnVista()==maxOwnVist&bot2.getOwnVista()==maxOwnVist) {
            System.out.println("Ничья между: "+bot2.getName()+" и "+bot3.getName());
        }
    }
}
