package main.controller;
import org.apache.log4j.Logger;
import main.model.Bot;
import main.model.Card;
import main.model.Distributor;

import java.util.stream.Stream;

public class Unpacking implements GameStrategy {

    @Override
    public void run(Distributor distributor, Bot bot1, Bot bot2, Bot bot3, Logger log) {
        log.info("Играем РАСПАС");
    processOfGame(distributor, bot1, bot2, bot3, log);
    pointsForUnpacking(bot1, bot2, bot3);
    }
    // процесс одной раздачи, устанавливается очередность выкладывания карт
    private void processOfGame(Distributor distributor,Bot bot1, Bot bot2, Bot bot3, Logger log) {
        for (int mmm = 0; mmm < 10; ) {
            label:
            {
                if (mmm == 0) {
                    log.info("---------------------------");
                    log.info("Raund " + mmm);
                    actionOfBotsZiroOne(distributor, bot1, bot2, bot3, log);
                    mmm++;
                    break label;
                }
                if (mmm == 1) {
                    if (bot1.isWinnerOneStep()) {
                        log.info("---------------------------");
                        log.info("Raund " + mmm);
                        actionOfBotsZiroOne(distributor,bot1, bot2, bot3, log);
                        mmm++;
                        break label;
                    }
                    if (bot2.isWinnerOneStep()) {
                        log.info("---------------------------");
                        log.info("Raund " + mmm);
                        actionOfBotsZiroOne(distributor,bot2, bot1, bot3, log);
                        mmm++;
                        break label;
                    }
                    if (bot3.isWinnerOneStep()) {
                        log.info("---------------------------");
                        log.info("Raund " + mmm);
                        actionOfBotsZiroOne(distributor,bot3, bot1, bot2, log);
                        mmm++;
                        break label;
                    }
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


    // боты выкладывают карты и сравнение карт для ходов 0-1
    private void actionOfBotsZiroOne(Distributor distributor, Bot bot1, Bot bot2, Bot bot3, Logger log) {
        Card cardD = new Card();
        Card card1 = new Card();
        Card card2 = new Card();
        Card card3 = new Card();
        cardD.setColor(distributor.getCards().get(0).getColor());
        cardD.setValue(distributor.getCards().get(0).getValue());
        distributor.getCards().remove(0);
        log.info(distributor.getName() + " Пололожил " + cardD.getCard(cardD));
        int m = 0;
        third:
        {
            for (m = 0; m <= bot1.getCards().size() - 1; m++) {
                if (cardD.getColor() == bot1.getCards().get(m).getColor()) {
                    break third;
                }
                if (m == (bot1.getCards().size() - 1)) {
                        m = 0;
                        break third;

                }
            }
        }

        card1.setColor(bot1.getCards().get(m).getColor());
        card1.setValue(bot1.getCards().get(m).getValue());
        bot1.getCards().remove(m);
        log.info(bot1.getName() + " Пололожил " + card1.getCard(card1));
        int i = 0;
        first:
        {
            for (i = 0; i <= bot2.getCards().size() - 1; i++) {
                if (cardD.getColor() == bot2.getCards().get(i).getColor()) {
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
                if (cardD.getColor() == bot3.getCards().get(k).getColor()) {
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

    // боты выкладывают карты и сравнение карт для ходов больше первого
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
                    for (i = 0; i <= bot2.getCards().size() - 1; i++) {
                        i = 0;
                        break first;
                    }
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
                    for (k = 0; k <= bot3.getCards().size() - 1; k++) {
                        k = 0;
                        break second;
                    }
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

    // очки в гору или пулю
    private void pointsForUnpacking(Bot bot1, Bot bot2, Bot bot3) {
        Stream<Integer> str = Stream.of(bot1.getKolvovziatok(), bot2.getKolvovziatok(),bot3.getKolvovziatok());
        int min= str.min(Integer::compareTo).get();
        if(bot1.getKolvovziatok()==0) {bot1.setBullet(bot1.getBullet()+1);}
        if(bot2.getKolvovziatok()==0) {bot2.setBullet(bot1.getBullet()+1);}
        if(bot3.getKolvovziatok()==0) {bot3.setBullet(bot1.getBullet()+1);}
        bot1.setHill(bot1.getHill()+(bot1.getKolvovziatok()-min));
        bot2.setHill(bot2.getHill()+(bot2.getKolvovziatok()-min));
        bot3.setHill(bot3.getHill()+(bot3.getKolvovziatok()-min));
    }
}
