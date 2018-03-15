package main.controller;

import main.model.Bot;
import main.model.Card;
import main.model.Distributor;
import org.apache.log4j.Logger;

public class Misery implements GameStrategy {



    @Override
    public void run(Distributor distributor, Bot bot1, Bot bot2, Bot bot3, Logger log) {
        log.info("Играем в МИЗЕР");
        getPrikupAndRemove(distributor, bot1, bot2, bot3);
        processOfGame(bot1, bot2, bot3, log);
        if(bot1.getStrategyBot2().equals("Misery")) {
            pointsForMisery(bot1);
        }
        if(bot2.getStrategyBot2().equals("Misery")) {
            pointsForMisery(bot2);
        }
        if(bot3.getStrategyBot2().equals("Misery")) {
            pointsForMisery(bot3);
        }
    }

    // процесс одной раздачи, устанавливается очередность выклдывания карт
    private void processOfGame(Bot bot1, Bot bot2, Bot bot3, Logger log) {
        for (int mmm = 0; mmm < 10; ) {
            label:
            {
                if (mmm == 0) {
                    log.info("---------------------------");
                    log.info("Raund " + mmm);
                    actionOfBots(bot1, bot2, bot3, log);
                    mmm++;
                    break label;
                }
                if (bot1.isWinnerOneStep()) {
                    log.info("---------------------------");
                    log.info("Raund " + mmm);
                    actionOfBots(bot1, bot2, bot3, log);
                    mmm++;
                    break label;
                }
                if (bot2.isWinnerOneStep()) {
                    log.info("---------------------------");
                    log.info("Raund " + mmm);
                    actionOfBots(bot2, bot1, bot3, log);
                    mmm++;
                    break label;
                }
                if (bot3.isWinnerOneStep()) {
                    log.info("---------------------------");
                    log.info("Raund " + mmm);
                    actionOfBots(bot3, bot1, bot2, log);
                    mmm++;
                    break label;
                }

            }
        }
    }

    // боты выкладывают карты и сравнение карт
    private void actionOfBots(Bot bot1, Bot bot2, Bot bot3, Logger log) {
        Card card1 = new Card();
        Card card2 = new Card();
        Card card3 = new Card();
        card1.setColor(bot1.getCards().get(0).getColor());
        card1.setValue(bot1.getCards().get(0).getValue());
        bot1.getCards().remove(0);
        log.info(bot1.getName() + " Пололожил " + card1.getCard(card1));
        int i = 0;
        first:
        {
            for (i = 0; i <= bot2.getCards().size() - 1; i++) {
                if (card1.getColor() == bot2.getCards().get(i).getColor()) {
                    break first;
                }
                if (i == (bot2.getCards().size() - 1)) {
                        i = 0;
                        break first;
                }
            }
        }

        card2.setColor(bot2.getCards().get(i).getColor());
        card2.setValue(bot2.getCards().get(i).getValue());
        bot2.getCards().remove(i);
        log.info(bot2.getName() + " Пололожил " + card2.getCard(card2));
        int k = 0;
        second:
        {
            for (k = 0; k <= bot3.getCards().size() - 1; k++) {
                if (card1.getColor() == bot3.getCards().get(k).getColor()) {
                    break second;
                }
                if (k == (bot3.getCards().size() - 1)) {
                        k = 0;
                        break second;

                }
            }
        }
        card3.setColor(bot3.getCards().get(k).getColor());
        card3.setValue(bot3.getCards().get(k).getValue());
        bot3.getCards().remove(k);
        log.info(bot3.getName() + " Пололожил " + card3.getCard(card3));

        if (card1.getColor() == card2.getColor() & card1.getColor() == card3.getColor()) {
            if (card1.getValue() > card2.getValue() & card1.getValue() > card3.getValue()) {
                log.info(bot1.getName() + " Забрал взятку ");
                bot1.setKolvovziatok(bot1.getKolvovziatok() + 1);
                bot1.setWinnerOneStep(true);
                bot2.setWinnerOneStep(false);
                bot3.setWinnerOneStep(false);
            }
            if (card2.getValue() > card1.getValue() & card2.getValue() > card3.getValue()) {
                log.info(bot2.getName() + " Забрал взятку ");
                bot2.setKolvovziatok(bot2.getKolvovziatok() + 1);
                bot2.setWinnerOneStep(true);
                bot1.setWinnerOneStep(false);
                bot3.setWinnerOneStep(false);
            }
            if (card3.getValue() > card1.getValue() & card3.getValue() > card2.getValue()) {
                log.info(bot3.getName() + " Забрал взятку ");
                bot3.setKolvovziatok(bot3.getKolvovziatok() + 1);
                bot3.setWinnerOneStep(true);
                bot2.setWinnerOneStep(false);
                bot1.setWinnerOneStep(false);
            }
        }
        if (card1.getColor() != card2.getColor() & card1.getColor() == card3.getColor()) {
            if (card1.getValue() > card3.getValue()) {
                log.info(bot1.getName() + " Забрал взятку ");
                bot1.setKolvovziatok(bot1.getKolvovziatok() + 1);
                bot1.setWinnerOneStep(true);
                bot2.setWinnerOneStep(false);
                bot3.setWinnerOneStep(false);
            }
            if (card1.getValue() < card3.getValue()) {
                log.info(bot3.getName() + " Забрал взятку ");
                bot3.setKolvovziatok(bot3.getKolvovziatok() + 1);
                bot3.setWinnerOneStep(true);
                bot2.setWinnerOneStep(false);
                bot1.setWinnerOneStep(false);
            }
        }
        if (card1.getColor() == card2.getColor() & card1.getColor() != card3.getColor()) {
            if (card1.getValue() > card2.getValue()) {
                log.info(bot1.getName() + " Забрал взятку ");
                bot1.setKolvovziatok(bot1.getKolvovziatok() + 1);
                bot1.setWinnerOneStep(true);
                bot2.setWinnerOneStep(false);
                bot3.setWinnerOneStep(false);
            }
            if (card1.getValue() < card2.getValue()) {
                log.info(bot2.getName() + " Забрал взятку ");
                bot2.setKolvovziatok(bot2.getKolvovziatok() + 1);
                bot2.setWinnerOneStep(true);
                bot3.setWinnerOneStep(false);
                bot1.setWinnerOneStep(false);
            }
        }
        if (card1.getColor() != card2.getColor() & card1.getColor() != card3.getColor()) {
            log.info(bot1.getName() + " Забрал взятку ");
            bot1.setKolvovziatok(bot1.getKolvovziatok() + 1);
            bot1.setWinnerOneStep(true);
            bot2.setWinnerOneStep(false);
            bot3.setWinnerOneStep(false);
        }

    }

    //получение прикупа ботом, объявившем мизер
    private void getPrikupAndRemove(Distributor distributor, Bot bot1, Bot bot2, Bot bot3 ) {
        int[][] mas = new int[2][4];
        if (bot1.getStrategyBot2().equals("Misery")) {
            bot1.getCards().addAll(distributor.getCards());
            bot1.getCards().remove((int) (Math.random()) * 12);
            bot1.getCards().remove((int) (Math.random()) * 12);

        }
        if (bot2.getStrategyBot2().equals("Misery")) {
            bot2.getCards().addAll(distributor.getCards());
            bot2.getCards().remove((int) (Math.random()) * 12);
            bot2.getCards().remove((int) (Math.random()) * 12);

        }
        if (bot3.getStrategyBot2().equals("Misery")) {
            bot3.getCards().addAll(distributor.getCards());
            bot3.getCards().remove((int) (Math.random()) * 12);
            bot3.getCards().remove((int) (Math.random()) * 12);

        }
    }

    // очки в гору боту
    private void pointsForMisery(Bot bot) {
        if (bot.getKolvovziatok() > 0) {
            bot.setHill(bot.getHill() + 10);
        }
        if(bot.getKolvovziatok()==0) {
            bot.setBullet(bot.getBullet()+10);
        }
    }
}
