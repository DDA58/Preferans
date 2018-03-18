package main.controller;

import main.model.Card;
import org.apache.log4j.Logger;
import main.model.Bot;
import main.model.Distribution;
import main.model.Distributor;

import java.util.List;

public class API_tasks {

    List<Distribution> distributions;

    public void first(int ID, Bot bot1, Bot bot2, Bot bot3, Distributor distributor, Distribution distribution, Logger log) {
        log.info("---------------------------");
        log.info("Карты " + bot1.getName() + ":");
        for (Card card : distribution.getCrdbot1()) {
            String str = Card.getCard(card);
            log.info(str);
        }
        log.info("---------------------------");
        log.info("Карты " + bot2.getName() + ":");
        for (Card card : distribution.getCrdbot2()) {
            String str = Card.getCard(card);
            log.info(str);
        }
        log.info("---------------------------");
        log.info("Карты " + bot3.getName() + ":");
        for (Card card : distribution.getCrdbot3()) {
            String str = Card.getCard(card);
            log.info(str);
        }
        log.info("---------------------------");
        log.info("Карты " + distributor.getName() + ":");
        for (Card card : distribution.getCrddistr()) {
            String str = Card.getCard(card);
            log.info(str);
        }
        for (int a = 0; a <= ID; a = a + 3) {
            if (ID == 1 + a) {
                log.info("---------------------------");
                log.info(bot2.getName() + " первым кладет карту в начале раздачи");
            }
            if (ID == 2 + a) {
                log.info("---------------------------");
                log.info(bot3.getName() + " первым кладет карту в начале раздачи");
            }
            if (ID == 0 + a) {
                log.info("---------------------------");
                log.info(bot1.getName() + " первым кладет карту в начале раздачи");
            }
        }
    }

    public void fifth(int ID, Bot bot1, Bot bot2, Bot bot3, Distributor distributor, Distribution distribution, Logger log) {
        log.info("У бота " + bot1.getName() + " " + distribution.getKolvoVziatBot1() + " взяток");
        log.info("У бота " + bot2.getName() + " " + distribution.getKolvoVziatBot2() + " взяток");
        log.info("У бота " + bot3.getName() + " " + distribution.getKolvoVziatBot3() + " взяток");
        log.info("У бота " + bot1.getName() + " " + distribution.getBulletB1() + " очков в пуле");
        log.info("У бота " + bot2.getName() + " " + distribution.getBulletB2() + " очков в пуле");
        log.info("У бота " + bot3.getName() + " " + distribution.getBulletB3() + " очков в пуле");
        log.info("У бота " + bot1.getName() + " " + distribution.getHillB1() + " очков в горе");
        log.info("У бота " + bot2.getName() + " " + distribution.getHillB2() + " очков в горе");
        log.info("У бота " + bot3.getName() + " " + distribution.getHillB3() + " очков в горе");
        log.info("У бота " + bot1.getName() + " " + distribution.getVistaB1onB2() + " вистов на " + bot2.getName());
        log.info("У бота " + bot1.getName() + " " + distribution.getVistaB1onB3() + " вистов на " + bot3.getName());
        log.info("У бота " + bot2.getName() + " " + distribution.getVistaB2onB3() + " вистов на " + bot3.getName());
        log.info("У бота " + bot2.getName() + " " + distribution.getVistaB2onB1() + " вистов на " + bot1.getName());
        log.info("У бота " + bot3.getName() + " " + distribution.getVistaB3onB2() + " вистов на " + bot2.getName());
        log.info("У бота " + bot3.getName() + " " + distribution.getVistaB3onB1() + " вистов на " + bot1.getName());
    }

    public void seventh(int ID, int IDBot, Bot bot1, Bot bot2, Bot bot3, Distributor distributor, Distribution distribution, Logger log) {
        if (IDBot == 1) {
            log.info("У бота " + bot1.getName() + " " + distribution.getBulletB1() + " очков в пуле");
            log.info("У бота " + bot1.getName() + " " + distribution.getHillB1() + " очков в горе");
            log.info("У бота " + bot1.getName() + " " + distribution.getVistaB1onB2() + " вистов на " + bot2.getName());
            log.info("У бота " + bot1.getName() + " " + distribution.getVistaB1onB3() + " вистов на " + bot3.getName());
        }
        if (IDBot == 2) {
            log.info("У бота " + bot2.getName() + " " + distribution.getBulletB2() + " очков в пуле");
            log.info("У бота " + bot2.getName() + " " + distribution.getHillB2() + " очков в горе");
            log.info("У бота " + bot2.getName() + " " + distribution.getVistaB2onB3() + " вистов на " + bot3.getName());
            log.info("У бота " + bot2.getName() + " " + distribution.getVistaB2onB1() + " вистов на " + bot1.getName());
        }
        if (IDBot == 3) {
            log.info("У бота " + bot3.getName() + " " + distribution.getBulletB3() + " очков в пуле");
            log.info("У бота " + bot3.getName() + " " + distribution.getHillB3() + " очков в горе");
            log.info("У бота " + bot3.getName() + " " + distribution.getVistaB3onB2() + " вистов на " + bot2.getName());
            log.info("У бота " + bot3.getName() + " " + distribution.getVistaB3onB1() + " вистов на " + bot1.getName());
        }
    }

}
