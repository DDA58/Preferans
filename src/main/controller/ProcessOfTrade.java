package main.controller;

import main.model.Bot;
import main.model.Card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProcessOfTrade {
    public String nameStrategy = null;
    public String selectStrategy(Bot bot) {
        int countSameColorS = 0;
        int countSameColorC = 0;
        int countSameColorD = 0;
        int countSameColorH = 0;
        int countLessOrEquals10 = 0;
        for (Card card : bot.getCards()) {
            switch (card.getColor()) {
                case 0:
                    countSameColorS++;
                    break;
                case 1:
                    countSameColorC++;
                    break;
                case 2:
                    countSameColorD++;
                    break;
                case 3:
                    countSameColorH++;
                    break;
            }
            bot.setNumberOfClubs(countSameColorC);
            bot.setNumberOfSpades(countSameColorS);
            bot.setNumberOfDiamonds(countSameColorD);
            bot.setNumberOfHearts(countSameColorH);


            if (card.getValue() <= 3) {
                countLessOrEquals10++;
            }
        }
        if ((countSameColorS == 4 || countSameColorC == 4 || countSameColorD == 4 || countSameColorH == 4) & (countLessOrEquals10 < 7)) {
            Contract.setValue(6);
            if (countSameColorS >= countSameColorC & countSameColorS >= countSameColorD & countSameColorS >= countSameColorH) {
                Contract.setColor(0);
            }
            if (countSameColorC >= countSameColorS & countSameColorC >= countSameColorD & countSameColorC >= countSameColorH) {
                Contract.setColor(1);
            }
            if (countSameColorD >= countSameColorS & countSameColorD >= countSameColorC & countSameColorD >= countSameColorH) {
                Contract.setColor(2);
            } else {
                Contract.setColor(3);
            }
            bot.setStrategyBot(nameStrategy=Contract.class.getSimpleName());
            return nameStrategy = Contract.class.getSimpleName();
        }
        if ((countSameColorS == 5 || countSameColorC == 5 || countSameColorD == 5 || countSameColorH == 5) & (countLessOrEquals10 < 7)) {
            Contract.setValue(7);
            if (countSameColorS >= countSameColorC & countSameColorS >= countSameColorD & countSameColorS >= countSameColorH) {
                Contract.setColor(0);
            }
            if (countSameColorC >= countSameColorS & countSameColorC >= countSameColorD & countSameColorC >= countSameColorH) {
                Contract.setColor(1);
            }
            if (countSameColorD >= countSameColorS & countSameColorD >= countSameColorC & countSameColorD >= countSameColorH) {
                Contract.setColor(2);
            } else {
                Contract.setColor(3);
            }
            bot.setStrategyBot(nameStrategy=Contract.class.getSimpleName());
            return nameStrategy = Contract.class.getSimpleName();
        }
        if ((countSameColorS >= 6 || countSameColorC >= 6 || countSameColorD >= 6 || countSameColorH >= 6) & (countLessOrEquals10 < 7)) {
            Contract.setValue(8);
            if (countSameColorS >= countSameColorC & countSameColorS >= countSameColorD & countSameColorS >= countSameColorH) {
                Contract.setColor(0);
            }
            if (countSameColorC >= countSameColorS & countSameColorC >= countSameColorD & countSameColorC >= countSameColorH) {
                Contract.setColor(1);
            }
            if (countSameColorD >= countSameColorS & countSameColorD >= countSameColorC & countSameColorD >= countSameColorH) {
                Contract.setColor(2);
            } else {
                Contract.setColor(3);
            }
            bot.setStrategyBot(nameStrategy=Contract.class.getSimpleName());
            return nameStrategy = Contract.class.getSimpleName();
        }
        if (countLessOrEquals10 >= 7) {
            bot.setStrategyBot(nameStrategy=Misery.class.getSimpleName());
            return nameStrategy = Misery.class.getSimpleName();
        } else {
            bot.setStrategyBot(nameStrategy="Pas");
            return nameStrategy = "Pas";

        }

    }
}


