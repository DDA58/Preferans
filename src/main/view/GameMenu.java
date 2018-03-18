package main.view;

import main.Main;
import main.controller.*;
import main.model.*;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameMenu {
    private Bot bot1 = new Bot();
    private Bot bot2 = new Bot();
    private Bot bot3 = new Bot();
    public Distributor distributor = new Distributor();
    private ProcessOfTrade processOfTrade = new ProcessOfTrade();
    private ProcessOfTradeTour2 processOfTradeTour2 = new ProcessOfTradeTour2();
    private Deck deck = new Deck();
    private Logger log = Logger.getLogger(Main.class.getName());
    private StartGame startGame = new StartGame();
    private GetResultInVist_Winner getResultInVist_winner = new GetResultInVist_Winner();
    private ChooseGame chooseGame = new ChooseGame();
    private API_tasks apiTasks = new API_tasks();
    public List<Distribution> distrs = new ArrayList<>();

    public void start() {

        menuBeforeStartGame();
        Scanner scanner = new Scanner(System.in);
        int st = scanner.nextInt();

        switch (st) {
            case 1: {
                setNameDistributor();
                setNameBots();
                setKindGame();
                break;
            }
            case 2: {
                break;
            }
            default: {
                log.info("Ошибка! Нажмите Run снова!");
                break;
            }
        }

    }

    private void setNameDistributor() {
        Scanner scanner = new Scanner(System.in);
        log.info("Введите имя РАЗДАЮЩЕГО");
        String str = scanner.next();
        distributor.setName(str);
    }

    private void setNameBots() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя ПЕРВОГО БОТА");
        String str1 = scanner.next();
        bot1.setName(str1);
        System.out.println("Введите имя ВТОРОГО БОТА");
        String str2 = scanner.next();
        bot2.setName(str2);
        System.out.println("Введите имя ТРЕТЬЕГО БОТА");
        String str3 = scanner.next();
        bot3.setName(str3);
    }

    //метод на выбор вида игры
    private void setKindGame() {
        log.info("Выберите вид игры:");
        log.info("1 - Игра до определенного количества раздач");
        log.info("2 - Игра до определенного количества суммарных очков в пуле");
        Scanner scanner = new Scanner(System.in);
        int kind = scanner.nextInt();
        switch (kind) {
            case 1: {
                log.info("Введите число сколько раздач сыграют боты");
                log.info("Внимание не рекомендуется вводить количество раздач более 15 по причине длины лога");
                gameForNumberDistribution();
                break;
            }
            case 2: {
                log.info("Введите число суммарных очков в пуле ботов");
                log.info("Внимание не рекомендуется вводить число пуль более 20 по причине длины лога");
                gameForNumberBullet();
                break;
            }
            default: {
                log.info("Ошибка! Нажмите Run снова!");
            }
        }


    }

    //метод на количество раздач
    private void gameForNumberDistribution() {
        Scanner scanner = new Scanner(System.in);
        int game = scanner.nextInt();
        for (int i = 0; i <= game; i++) {
            int a = 0;
            int b = 0;
            int c = 0;
            if (i == 1 + c) {
                c = c + 3;
                bot2.setWinnerOneStep(true);
                bot3.setWinnerOneStep(false);
                bot1.setWinnerOneStep(false);
            }
            if (i == 2 + b) {
                b = b + 3;
                bot3.setWinnerOneStep(true);
                bot2.setWinnerOneStep(false);
                bot1.setWinnerOneStep(false);
            }
            if (i == 0 + a) {
                a = a + 3;
                bot1.setWinnerOneStep(true);
                bot3.setWinnerOneStep(false);
                bot2.setWinnerOneStep(false);
            }
            Distribution distribution = new Distribution();
            distribution.setIDDistr(i);
            startGame.setStartGame(deck, bot1, bot2, bot3, distributor, distribution);

            log.info("Начало раздачи " + i);
            cardsBot(bot1);
            cardsBot(bot2);
            cardsBot(bot3);
            log.info("---------------------------");
            log.info("Торг тур 1");
            log.info(processOfTrade.selectStrategy(bot1) + " говорит " + bot1.getName());
            log.info(processOfTrade.selectStrategy(bot2) + " говорит " + bot2.getName());
            log.info(processOfTrade.selectStrategy(bot3) + " говорит " + bot3.getName());
            processOfTradeTour2.trade2(bot1, bot2, bot3);
            log.info("---------------------------");
            log.info("Торг тур 2");
            log.info(bot1.getStrategyBot2() + " говорит " + bot1.getName());
            log.info(bot2.getStrategyBot2() + " говорит " + bot2.getName());
            log.info(bot3.getStrategyBot2() + " говорит " + bot3.getName());
            log.info("---------------------------");
            chooseGame.chooseG(distributor, bot1, bot2, bot3, log);
            setCharacteristicsDistribution(distribution);
            distrs.add(distribution);
            log.info("---------------------------");
            log.info(bot1.getHill() + " Гора " + bot1.getName());
            log.info(bot1.getBullet() + " Пуля " + bot1.getName());
            log.info(bot1.getVista1() + " Вистов " + bot1.getName() + " на " + bot2.getName());
            log.info(bot1.getVista2() + " Вистов " + bot1.getName() + " на " + bot3.getName());
            log.info("---------------------------");
            log.info(bot2.getHill() + " Гора " + bot2.getName());
            log.info(bot2.getBullet() + " Пуля " + bot2.getName());
            log.info(bot2.getVista1() + " Вистов " + bot2.getName() + " на " + bot1.getName());
            log.info(bot2.getVista2() + " Вистов " + bot2.getName() + " на " + bot3.getName());
            log.info("---------------------------");
            log.info(bot3.getHill() + " Гора " + bot3.getName());
            log.info(bot3.getBullet() + " Пуля " + bot3.getName());
            log.info(bot3.getVista1() + " Вистов " + bot3.getName() + " на " + bot1.getName());
            log.info(bot3.getVista2() + " Вистов " + bot3.getName() + " на " + bot2.getName());
            log.info("---------------------------");
            if (i == (game)) {
                log.info("---------------------------");
                getResultInVist_winner.resultInVist(bot1, bot2, bot3, log);
                menuAfterEndGame();
                int num = scanner.nextInt();
                switch (num) {
                    case 1: System.out.println("Введите номер раздачи");
                        int ID = scanner.nextInt();
                        apiTasks.first(ID, bot1, bot2, bot3, distributor, distribution, log);
                        break;
                    case 5: System.out.println("Введите номер раздачи");
                        int ID1 = scanner.nextInt();
                        apiTasks.fifth(ID1, bot1, bot2, bot3, distributor, distribution, log);
                        break;
                    case 7: System.out.println("Введите номер раздачи");
                        int ID2 = scanner.nextInt();
                        System.out.println("Введите номер бота(1, 2 или 3)");
                        int ID3 = scanner.nextInt();
                        apiTasks.seventh(ID2, ID3, bot1, bot2, bot3, distributor,distribution, log);
                        break;
                }
            }

        }
    }

    //метод на количество пуль
    private void gameForNumberBullet() {
        Scanner scanner = new Scanner(System.in);
        int game = scanner.nextInt();
        int i = 1;
        while ((bot1.getBullet() + bot2.getBullet() + bot3.getBullet()) < game) {
            int a = 0;
            int b = 0;
            int c = 0;
            if (i == 1 + c) {
                c = c + 3;
                bot2.setWinnerOneStep(true);
                bot3.setWinnerOneStep(false);
                bot1.setWinnerOneStep(false);
            }
            if (i == 2 + b) {
                b = b + 3;
                bot3.setWinnerOneStep(true);
                bot2.setWinnerOneStep(false);
                bot1.setWinnerOneStep(false);
            }
            if (i == 0 + a) {
                a = a + 3;
                bot1.setWinnerOneStep(true);
                bot3.setWinnerOneStep(false);
                bot2.setWinnerOneStep(false);
            }
            Distribution distribution = new Distribution();
            distribution.setIDDistr(i);
            startGame.setStartGame(deck, bot1, bot2, bot3, distributor, distribution);

            log.info("Начало раздачи " + i);
            cardsBot(bot1);
            cardsBot(bot2);
            cardsBot(bot3);
            log.info("---------------------------");
            log.info("Торг тур 1");
            log.info(processOfTrade.selectStrategy(bot1) + " говорит " + bot1.getName());
            log.info(processOfTrade.selectStrategy(bot2) + " говорит " + bot2.getName());
            log.info(processOfTrade.selectStrategy(bot3) + " говорит " + bot3.getName());
            processOfTradeTour2.trade2(bot1, bot2, bot3);
            log.info("---------------------------");
            log.info("Торг тур 2");
            log.info(bot1.getStrategyBot2() + " говорит " + bot1.getName());
            log.info(bot2.getStrategyBot2() + " говорит " + bot2.getName());
            log.info(bot3.getStrategyBot2() + " говорит " + bot3.getName());
            log.info("---------------------------");
            chooseGame.chooseG(distributor, bot1, bot2, bot3, log);
            setCharacteristicsDistribution(distribution);
            distrs.add(distribution);
            log.info("---------------------------");
            log.info(bot1.getHill() + " Гора " + bot1.getName());
            log.info(bot1.getBullet() + " Пуля " + bot1.getName());
            log.info(bot1.getVista1() + " Вистов " + bot1.getName() + " на " + bot2.getName());
            log.info(bot1.getVista2() + " Вистов " + bot1.getName() + " на " + bot3.getName());
            log.info("---------------------------");
            log.info(bot2.getHill() + " Гора " + bot2.getName());
            log.info(bot2.getBullet() + " Пуля " + bot2.getName());
            log.info(bot2.getVista1() + " Вистов " + bot2.getName() + " на " + bot1.getName());
            log.info(bot2.getVista2() + " Вистов " + bot2.getName() + " на " + bot3.getName());
            log.info("---------------------------");
            log.info(bot3.getHill() + " Гора " + bot3.getName());
            log.info(bot3.getBullet() + " Пуля " + bot3.getName());
            log.info(bot3.getVista1() + " Вистов " + bot3.getName() + " на " + bot1.getName());
            log.info(bot3.getVista2() + " Вистов " + bot3.getName() + " на " + bot2.getName());
            log.info("---------------------------");
            i++;
            if ((bot1.getBullet() + bot2.getBullet() + bot3.getBullet()) >= game){
                log.info("---------------------------");
                getResultInVist_winner.resultInVist(bot1, bot2, bot3, log);
                menuAfterEndGame();
                int num = scanner.nextInt();
                switch (num) {
                    case 1: System.out.println("Введите номер раздачи");
                    int ID = scanner.nextInt();
                    apiTasks.first(ID, bot1, bot2, bot3, distributor, distribution, log);
                        break;
                    case 5: System.out.println("Введите номер раздачи");
                    int ID1 = scanner.nextInt();
                    apiTasks.fifth(ID1, bot1, bot2, bot3, distributor, distribution, log);
                        break;
                    case 7: System.out.println("Введите номер раздачи");
                        int ID2 = scanner.nextInt();
                        System.out.println("Введите номер бота(1, 2 или 3)");
                        int ID3 = scanner.nextInt();
                        apiTasks.seventh(ID2, ID3, bot1, bot2, bot3, distributor,distribution, log);
                        break;
                }
            }
        }

    }

    //метод логирования карт
    private void cardsBot(Bot bot) {
        log.info("---------------------------");
        log.info("Карты " + bot.getName() + ":");
        for (Card card : bot.getCards()) {
            String str = Card.getCard(card);
            log.info(str);
        }
    }

    private void menuAfterEndGame() {
        log.info("1 - Получение данных определенной раздачи");
        log.info("5 - Получение данных о результатах розыгрыша определенной раздачи");
        log.info("7 - Получение данных о текущем состоянии пули, горы и вистах выбранного боты после определенной раздачи");
    }

    private void menuBeforeStartGame() {
        log.info("Добро пожаловать в симулятор игры преферанс");
        log.info("Совет: выбирайте только указанные варианты, так как обработки исключений нет");
        log.info("Выберите нужное действие:");
        log.info("1 - Перейти к началу игры и вводу начальных условий");
        log.info("2  - Выход");

    }

    private void setCharacteristicsDistribution(Distribution distribution) {
        distribution.setKolvoVziatBot1(bot1.getKolvovziatok());
        distribution.setKolvoVziatBot2(bot2.getKolvovziatok());
        distribution.setKolvoVziatBot3(bot3.getKolvovziatok());
        distribution.setBulletB1(bot1.getBullet());
        distribution.setBulletB2(bot2.getBullet());
        distribution.setBulletB3(bot3.getBullet());
        distribution.setHillB1(bot1.getHill());
        distribution.setHillB2(bot2.getHill());
        distribution.setHillB3(bot3.getHill());
        distribution.setVistaB1onB2(bot1.getVista1());
        distribution.setVistaB1onB3(bot1.getVista2());
        distribution.setVistaB2onB3(bot1.getVista2());
        distribution.setVistaB2onB1(bot1.getVista1());
        distribution.setVistaB3onB2(bot1.getVista2());
        distribution.setVistaB3onB1(bot1.getVista1());
    }

}
