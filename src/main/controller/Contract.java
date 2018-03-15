package main.controller;
import org.apache.log4j.Logger;
import main.model.Bot;
import main.model.Card;
import main.model.Distributor;

import java.util.List;

public class Contract implements GameStrategy {
    private static int value=0;
    private static int color;
    private static int valueVist;
    private static int costContr;

    public static int getValue() {
        return value;
    }

    public static void setValue(int value) {
        Contract.value = value;
    }

    public static int getColor() {
        return color;
    }

    public static void setColor(int color) {
        Contract.color = color;
    }

    public static int getValueVist() {
        return valueVist;
    }

    public static void setValueVist(int valueVist) {
        Contract.valueVist = valueVist;
    }

    public static int getCostContr() {
        return costContr;
    }

    public static void setCostContr(int costContr) {
        Contract.costContr = costContr;
    }

    public static int getKozir() {
        return Kozir;
    }

    public static void setKozir(int kozir) {
        Kozir = kozir;
    }

    public static int Kozir;

    @Override
    public void run(Distributor distributor, Bot bot1, Bot bot2, Bot bot3, Logger log) {
        loadKozir(bot1, bot2, bot3, distributor);
        podschetKozirVNachale(bot1, bot2, bot3);

        if (bot2.getStrategyBot2().equals("Contract")) {
            bot2.setZayvkaPriKontrakte("Contract");
            bot2.setValueContract(value);
            bot1.setZayvkaPriKontrakte("Vist");
            bot3.setZayvkaPriKontrakte("Pas");
        }
        if (bot1.getStrategyBot2().equals("Contract") & (int) Math.random() * 2 == 0) {
            bot1.setZayvkaPriKontrakte("Contract");
            bot1.setValueContract(value);
            bot3.setZayvkaPriKontrakte("Vist");
            bot2.setZayvkaPriKontrakte("Vist");
        }
        if (bot1.getStrategyBot2().equals("Contract") & (int) Math.random() * 2 == 1) {
            bot1.setZayvkaPriKontrakte("Contract");
            bot1.setValueContract(value);
            bot3.setZayvkaPriKontrakte("Pas");
            bot2.setZayvkaPriKontrakte("Vist");
        }
        if (bot3.getStrategyBot2().equals("Contract")) {
            bot3.setZayvkaPriKontrakte("Contract");
            bot3.setValueContract(value);
            bot2.setZayvkaPriKontrakte("Vist");
            bot1.setZayvkaPriKontrakte("Pas");
        }
        log.info("Играем КОНТРАКТ");
        log.info("Ответы при контракте");
        log.info(bot1.getZayvkaPriKontrakte() + " говорит "+bot1.getName());
        log.info(bot2.getZayvkaPriKontrakte() + " говорит "+bot2.getName());
        log.info(bot3.getZayvkaPriKontrakte() + " говорит "+bot3.getName());
        log.info("---------------------------");

        if(Kozir==0){log.info("Козырь SPADES");}
        if(Kozir==1){log.info("Козырь CLUBS");}
        if(Kozir==2){log.info("Козырь DIAMONDS");}
        if(Kozir==3){log.info("Козырь HEARTS");}
        log.info("---------------------------");
        if (bot1.getZayvkaPriKontrakte().equals("Contract") & bot2.getZayvkaPriKontrakte().equals("Vist") & bot3.getZayvkaPriKontrakte().equals("Vist")) {
            processOfGame(bot1, bot2, bot3, log);
            if(bot1.getKolvovziatok()>=bot1.getValueContract()) {
                bot1.setBullet(bot1.getBullet()+cost());
            }
            if(bot2.getKolvovziatok()>=bot2.getValueVist()) {
                bot2.setVista1(bot2.getVista1()+bot2.getKolvovziatok()*cost());
            }
            if(bot3.getKolvovziatok()>=bot3.getValueVist()) {
                bot3.setVista1(bot3.getVista1()+bot3.getKolvovziatok()*cost());
            }
            if(bot1.getKolvovziatok()<bot1.getValueContract()) {
                bot1.setHill(bot1.getHill()+(bot1.getValueContract()-bot1.getKolvovziatok())*cost());
            }
            if(bot2.getKolvovziatok()<bot2.getValueVist()) {
                bot2.setVista1(bot2.getVista1()+bot2.getKolvovziatok()*cost());
                bot2.setHill(bot2.getHill()+cost());
            }
            if(bot3.getKolvovziatok()<bot3.getValueVist()) {
                bot3.setVista1(bot3.getVista1()+bot3.getKolvovziatok()*cost());
                bot2.setHill(bot2.getHill()+cost());
            }

        }
        if (bot1.getZayvkaPriKontrakte().equals("Contract") & bot2.getZayvkaPriKontrakte().equals("Vist") & bot3.getZayvkaPriKontrakte().equals("Pas")) {
            int rand= (int) Math.random() * 2;
            if (rand == 0) {
                log.info(bot2.getName()+" говорит: играем в закрытую");
            }
            if (rand == 1) {
                log.info(bot2.getName()+" говорит: играем в открытую");
            }
            processOfGame(bot1, bot2, bot3, log);
            if(bot1.getKolvovziatok()>=bot1.getValueContract()) {
                bot1.setBullet(bot1.getBullet()+cost());
            }
            if(bot1.getKolvovziatok()<bot1.getValueContract()) {
                bot1.setHill(bot1.getHill()+(bot1.getValueContract()-bot1.getKolvovziatok())*cost());
            }
            if(bot2.getKolvovziatok()>=bot2.getValueVist()) {
                if (rand == 0) {
                    bot2.setVista1(bot2.getVista1()+bot2.getKolvovziatok()*cost());
                }
                if (rand == 1) {
                    bot2.setVista1(bot2.getVista1()+(bot2.getKolvovziatok()+bot3.getKolvovziatok())*cost());
                }

            }
            if(bot2.getKolvovziatok()<bot2.getValueVist()) {
                bot2.setHill(bot2.getHill()+cost());
            }

        }
        if (bot2.getZayvkaPriKontrakte().equals("Contract") & bot1.getZayvkaPriKontrakte().equals("Vist") & bot3.getZayvkaPriKontrakte().equals("Pas")) {
            int rand= (int) Math.random() * 2;
            if (rand  == 0) {
                log.info(bot1.getName()+" говорит: играем в закрытую");
            }
            if (rand == 1) {
                log.info(bot1.getName()+" говорит: играем в открытую");
            }
            processOfGame(bot1, bot2, bot3, log);
            if(bot2.getKolvovziatok()>=bot2.getValueContract()) {
                bot2.setBullet(bot2.getBullet()+cost());
            }
            if(bot2.getKolvovziatok()<bot2.getValueContract()) {
                bot2.setHill(bot2.getHill()+(bot2.getValueContract()-bot2.getKolvovziatok())*cost());
            }
            if(bot1.getKolvovziatok()>=bot1.getValueVist()) {
                if (rand == 0) {
                    bot1.setVista1(bot2.getVista1()+bot2.getKolvovziatok()*cost());
                }
                if (rand == 1) {
                    bot1.setVista1(bot2.getVista1()+(bot1.getKolvovziatok()+bot3.getKolvovziatok())*cost());
                }

            }
            if(bot1.getKolvovziatok()<bot1.getValueVist()) {
                bot1.setHill(bot1.getHill()+cost());
            }

        }
        if (bot3.getZayvkaPriKontrakte().equals("Contract") & bot2.getZayvkaPriKontrakte().equals("Vist") & bot1.getZayvkaPriKontrakte().equals("Pas")) {
            int rand= (int) Math.random() * 2;
            if (rand  == 0) {
                log.info(bot2.getName()+" говорит: играем в закрытую");
            }
            if (rand == 1) {
                log.info(bot2.getName()+" говорит: играем в открытую");
            }
            processOfGame(bot1, bot2, bot3, log);
            if(bot3.getKolvovziatok()>=bot3.getValueContract()) {
                bot3.setBullet(bot3.getBullet()+cost());
            }
            if(bot3.getKolvovziatok()<bot3.getValueContract()) {
                bot3.setHill(bot3.getHill()+(bot3.getValueContract()-bot3.getKolvovziatok())*cost());
            }
            if(bot1.getKolvovziatok()>=bot1.getValueVist()) {
                if (rand == 0) {
                    bot2.setVista2(bot2.getVista1()+bot2.getKolvovziatok()*cost());
                }
                if (rand == 1) {
                    bot2.setVista2(bot2.getVista1()+(bot2.getKolvovziatok()+bot1.getKolvovziatok())*cost());
                }

            }
            if(bot2.getKolvovziatok()<bot2.getValueVist()) {
                bot2.setHill(bot2.getHill()+cost());
            }
        }
    }


    //установка козыря для раздачи
    private void loadKozir(Bot bot1, Bot bot2, Bot bot3, Distributor distributor) {
        int[][] mas = new int[2][4];
        if (bot1.getStrategyBot2().equals("Contract")) {
            bot1.getCards().addAll(distributor.getCards());
            bot1.getCards().remove((int) (Math.random()) * 12);
            bot1.getCards().remove((int) (Math.random()) * 12);
            mas = bot1.getMas();
            Kozir = mas[0][3];

        }
        if (bot2.getStrategyBot2().equals("Contract")) {
            bot2.getCards().addAll(distributor.getCards());
            bot2.getCards().remove((int) (Math.random()) * 12);
            bot2.getCards().remove((int) (Math.random()) * 12);
            mas = bot2.getMas();
            Kozir = mas[0][3];

        }
        if (bot3.getStrategyBot2().equals("Contract")) {
            bot3.getCards().addAll(distributor.getCards());
            bot3.getCards().remove((int) (Math.random()) * 12);
            bot3.getCards().remove((int) (Math.random()) * 12);
            mas = bot3.getMas();
            Kozir = mas[0][3];

        }
    }

    // процесс одной раздачи, устанавливается очередность выклдывания карт
    private void processOfGame (Bot bot1, Bot bot2, Bot bot3, Logger log) {
    for (int mmm = 0; mmm < 10;) {
        label: {
            if (mmm == 0) {
                log.info("---------------------------");
                System.out.println("Раунд " + mmm);
                actionOfBots(bot1, bot2, bot3, log);
                mmm++;
                break label;
            }
            if (bot1.isWinnerOneStep()) {
                log.info("---------------------------");
                System.out.println("Раунд " + mmm);
                actionOfBots(bot1, bot2, bot3, log);
                mmm++;
                break label;
            }
            if (bot2.isWinnerOneStep()) {
                log.info("---------------------------");
                System.out.println("Раунд " + mmm);
                actionOfBots(bot2, bot1, bot3, log);
                mmm++;
                break label;
            }
            if (bot3.isWinnerOneStep()) {
                log.info("---------------------------");
                System.out.println("Раунд " + mmm);
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
                    for (i = 0; i <= bot2.getCards().size() - 1; i++) {
                        if (bot2.getCards().get(i).getColor() == Kozir) {
                            break first;
                        }
                        if (i == (bot2.getCards().size() - 1)) {
                            i = 0;
                            break first;
                        }
                    }
                }
            }
        }

        card2.setColor(bot2.getCards().get(i).getColor());
        card2.setValue(bot2.getCards().get(i).getValue());
        bot2.getCards().remove(i);
        log.info(bot2.getName() + "Пололожил " + card2.getCard(card2));
        if (card1.getColor() != Kozir & card2.getColor() == Kozir) {
            card2.setColor(card1.getColor());
            card2.setValue(card2.getValue() + 10);
        }
        int k = 0;
        second:
        {
            for (k = 0; k <= bot3.getCards().size() - 1; k++) {
                if (card1.getColor() == bot3.getCards().get(k).getColor()) {
                    break second;
                }
                if (k == (bot3.getCards().size() - 1)) {
                    for (k = 0; k <= bot3.getCards().size() - 1; k++) {
                        if (bot3.getCards().get(k).getColor() == Kozir) {
                            break second;
                        }
                        if (k == (bot3.getCards().size() - 1)) {
                            k = 0;
                            break second;
                        }
                    }
                }
            }
        }
        card3.setColor(bot3.getCards().get(k).getColor());
        card3.setValue(bot3.getCards().get(k).getValue());
        bot3.getCards().remove(k);
        log.info(bot3.getName() + " Пололожил " + card3.getCard(card3));
        if (card1.getColor() != Kozir & card3.getColor() == Kozir) {
            card3.setColor(card1.getColor());
            card3.setValue(card3.getValue() + 10);
        }

        if (card1.getColor() == card2.getColor() & card1.getColor() == card3.getColor()) {
            if (card1.getValue()>card2.getValue()& card1.getValue()>card3.getValue()) {
                log.info(bot1.getName() + " Забрал взятку");
                bot1.setKolvovziatok(bot1.getKolvovziatok() + 1);
                bot1.setWinnerOneStep(true);
                bot2.setWinnerOneStep(false);
                bot3.setWinnerOneStep(false);
            }
            if (card2.getValue()>card1.getValue()& card2.getValue()>card3.getValue()) {
                    log.info(bot2.getName() + " Забрал взятку");
                    bot2.setKolvovziatok(bot2.getKolvovziatok() + 1);
                    bot2.setWinnerOneStep(true);
                    bot1.setWinnerOneStep(false);
                    bot3.setWinnerOneStep(false);
            }
            if (card3.getValue()>card1.getValue()& card3.getValue()>card2.getValue()) {
                log.info(bot3.getName() + " Забрал взятку");
                    bot3.setKolvovziatok(bot3.getKolvovziatok() + 1);
                    bot3.setWinnerOneStep(true);
                    bot2.setWinnerOneStep(false);
                    bot1.setWinnerOneStep(false);
            }
        }
        if (card1.getColor() != card2.getColor() & card1.getColor() == card3.getColor()) {
            if (card1.getValue() > card3.getValue()) {
                log.info(bot1.getName() + " Забрал взятку");
                bot1.setKolvovziatok(bot1.getKolvovziatok() + 1);
                bot1.setWinnerOneStep(true);
                bot2.setWinnerOneStep(false);
                bot3.setWinnerOneStep(false);
            }
            if (card1.getValue() < card3.getValue()) {
                log.info(bot3.getName() + " Забрал взятку");
                bot3.setKolvovziatok(bot3.getKolvovziatok() + 1);
                bot3.setWinnerOneStep(true);
                bot2.setWinnerOneStep(false);
                bot1.setWinnerOneStep(false);
            }
        }
        if (card1.getColor() == card2.getColor() & card1.getColor() != card3.getColor()) {
            if (card1.getValue() > card2.getValue()) {
                log.info(bot1.getName() + " Забрал взятку");
                bot1.setKolvovziatok(bot1.getKolvovziatok() + 1);
                bot1.setWinnerOneStep(true);
                bot2.setWinnerOneStep(false);
                bot3.setWinnerOneStep(false);
            }
            if (card1.getValue() < card2.getValue()) {
                log.info(bot2.getName() + " Забрал взятку");
                bot2.setKolvovziatok(bot2.getKolvovziatok() + 1);
                bot2.setWinnerOneStep(true);
                bot3.setWinnerOneStep(false);
                bot1.setWinnerOneStep(false);
            }
        }
        if (card1.getColor() != card2.getColor() & card1.getColor() != card3.getColor()) {
            log.info(bot1.getName() + " Забрал взятку");
            bot1.setKolvovziatok(bot1.getKolvovziatok() + 1);
            bot1.setWinnerOneStep(true);
            bot2.setWinnerOneStep(false);
            bot3.setWinnerOneStep(false);
        }

    }

    //подсчет козырей в начале у каждого бота
    private void podschetKozirVNachale(Bot bot1, Bot bot2, Bot bot3) {
        for (int i = 0; i < 10; i++) {
            if (bot1.getCards().get(i).getColor() == Kozir) {
                bot1.setOstKozir(bot1.getOstKozir() + 1);
            }
            if (bot2.getCards().get(i).getColor() == Kozir) {
                bot2.setOstKozir(bot2.getOstKozir() + 1);
            }
            if (bot3.getCards().get(i).getColor() == Kozir) {
                bot3.setOstKozir(bot3.getOstKozir() + 1);
            }

        }
    }

    //возвращает стоимость контрактов
    private int cost() {
        if (value == 6) {
            costContr = 2;
            valueVist = 4;
        }
        if (value == 7) {
            costContr = 4;
            valueVist = 2;
        }
        if (value == 8) {
            costContr = 6;
            valueVist = 1;
        }
        if (value == 9) {
            costContr = 8;
            valueVist = 1;
        }
        if (value == 10) {
            costContr = 10;
            valueVist = 1;
        }
        return costContr;
    }

}