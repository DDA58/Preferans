package main.controller;
import main.model.Bot;
public class ProcessOfTradeTour2 {
    public void trade2(Bot bot1, Bot bot2, Bot bot3) {
        int[][] mas1 = new int[2][4];
        int[][] mas2 = new int[2][4];
        int[][] mas3 = new int[2][4];
        bot1.createMassiv();
        bot2.createMassiv();
        bot3.createMassiv();
        mas1 = bot1.getMas();
        mas2 = bot2.getMas();
        mas3 = bot3.getMas();

        if (bot1.getStrategyBot().equals("Pas") & bot2.getStrategyBot().equals("Pas") & bot3.getStrategyBot().equals("Pas")) {
            bot1.setStrategyBot2("Pas");
            bot2.setStrategyBot2("Pas");
            bot3.setStrategyBot2("Pas");
        }

        if (bot1.getStrategyBot().equals("Contract") & bot2.getStrategyBot().equals("Contract") & bot3.getStrategyBot().equals("Contract")) {

                if (mas1[0][3] >= mas2[0][3] & mas1[0][3] >= mas3[0][3]) {
                bot1.setStrategyBot2("Contract");
                bot2.setStrategyBot2("Pas");
                bot3.setStrategyBot2("Pas");
                }
                if (mas2[0][3] >= mas1[0][3] & mas2[0][3] >= mas3[0][3]) {
                    bot1.setStrategyBot2("Contract");
                    bot2.setStrategyBot2("Pas");
                    bot3.setStrategyBot2("Pas");
                }
                if (mas3[0][3] >= mas2[0][3] & mas3[0][3] >= mas1[0][3]) {
                    bot1.setStrategyBot2("Contract");
                    bot2.setStrategyBot2("Pas");
                    bot3.setStrategyBot2("Pas");
                }
                if (mas1[0][3] >= mas2[0][3] & mas1[0][3] <= mas3[0][3]) {
                    bot1.setStrategyBot2("Pas");
                    bot2.setStrategyBot2("Pas");
                    bot3.setStrategyBot2("Contract");
                }
                if (mas1[0][3] >= mas3[0][3] & mas1[0][3] <= mas2[0][3]) {
                    bot1.setStrategyBot2("Pas");
                    bot2.setStrategyBot2("Contract");
                    bot3.setStrategyBot2("Pas");
                }
                if (mas2[0][3] >= mas1[0][3] & mas2[0][3] <= mas3[0][3]) {
                    bot3.setStrategyBot2("Contract");
                    bot2.setStrategyBot2("Pas");
                    bot1.setStrategyBot2("Pas");
                }
                if (mas2[0][3] >= mas3[0][3] & mas2[0][3] <= mas1[0][3]) {
                    bot1.setStrategyBot2("Contract");
                    bot2.setStrategyBot2("Pas");
                    bot3.setStrategyBot2("Pas");
                }
                if (mas3[0][3] >= mas1[0][3] & mas3[0][3] <= mas2[0][3]) {
                    bot2.setStrategyBot2("Contract");
                    bot1.setStrategyBot2("Pas");
                    bot3.setStrategyBot2("Pas");
                }if (mas3[0][3] >= mas2[0][3] & mas3[0][3] <= mas1[0][3]) {
                    bot1.setStrategyBot2("Contract");
                    bot2.setStrategyBot2("Pas");
                    bot3.setStrategyBot2("Pas");
                }
                else {
                    if((int)Math.random()*3==0) {
                        bot1.setStrategyBot2("Contract");
                        bot2.setStrategyBot2("Pas");
                        bot3.setStrategyBot2("Pas");}
                        if((int)Math.random()*3==1) {
                        bot2.setStrategyBot2("Contract");
                        bot1.setStrategyBot2("Pas");
                        bot3.setStrategyBot2("Pas");}
                        if((int)Math.random()*3==2) {
                        bot3.setStrategyBot2("Contract");
                        bot2.setStrategyBot2("Pas");
                        bot1.setStrategyBot2("Pas");}
            }
        }
            if (bot1.getStrategyBot().equals("Contract") & bot2.getStrategyBot().equals("Contract")&!bot3.getStrategyBot().equals("Misery")&!bot3.getStrategyBot().equals("Contract")) {
                if (mas1[0][3] > mas2[0][3]) {
                    bot2.setStrategyBot2("Pas");
                    bot1.setStrategyBot2("Contract");
                    bot3.setStrategyBot2("Pas");
                } else {
                    bot2.setStrategyBot2("Contract");
                    bot1.setStrategyBot2("Pas");
                    bot3.setStrategyBot2("Pas");
                }
            }
            if (bot1.getStrategyBot().equals("Pas") & bot2.getStrategyBot().equals("Pas")&bot3.getStrategyBot().equals("Contract")) {
                bot2.setStrategyBot2("Pas");
                bot3.setStrategyBot2("Contract");
                bot1.setStrategyBot2("Pas");
            }
            if (bot1.getStrategyBot().equals("Contract") & bot3.getStrategyBot().equals("Contract")&!bot2.getStrategyBot().equals("Misery")&!bot2.getStrategyBot().equals("Contract")) {
                if (mas1[0][3] > mas3[0][3]) {
                    bot3.setStrategyBot2("Pas");
                    bot1.setStrategyBot2("Contract");
                    bot2.setStrategyBot2("Pas");
                } else {
                    bot1.setStrategyBot2("Pas");
                    bot2.setStrategyBot2("Pas");
                    bot3.setStrategyBot2("Contract");
                }
            }
            if (bot1.getStrategyBot().equals("Pas") & bot3.getStrategyBot().equals("Pas")&bot2.getStrategyBot().equals("Contract")) {
                bot1.setStrategyBot2("Pas");
                bot2.setStrategyBot2("Contract");
                bot3.setStrategyBot2("Pas");
            }
            if (bot3.getStrategyBot().equals("Contract") & bot2.getStrategyBot().equals("Contract")&!bot1.getStrategyBot().equals("Misery")&!bot1.getStrategyBot().equals("Contract")) {
                if (mas3[0][3] > mas2[0][3]) {
                    bot2.setStrategyBot2("Pas");
                    bot3.setStrategyBot2("Contract");
                    bot1.setStrategyBot2("Pas");
                } else {
                    bot3.setStrategyBot2("Pas");
                    bot2.setStrategyBot2("Contract");
                    bot1.setStrategyBot2("Pas");
                }
            }
            if (bot3.getStrategyBot().equals("Pas") & bot2.getStrategyBot().equals("Pas")&bot1.getStrategyBot().equals("Contract")) {
                bot2.setStrategyBot2("Pas");
                bot1.setStrategyBot2("Contract");
                bot3.setStrategyBot2("Pas");
            }

            if (bot1.getStrategyBot().equals("Misery")) {
                bot2.setStrategyBot2("Pas");
                bot3.setStrategyBot2("Pas");
                bot1.setStrategyBot2("Misery");
            }
            if (bot2.getStrategyBot().equals("Misery")) {
                bot1.setStrategyBot2("Pas");
                bot2.setStrategyBot2("Misery");
                bot3.setStrategyBot2("Pas");
            }
            if (bot3.getStrategyBot().equals("Misery")) {
            bot2.setStrategyBot2("Pas");
            bot1.setStrategyBot2("Pas");
            bot3.setStrategyBot2("Misery");
            }


    }
}
