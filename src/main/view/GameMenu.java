package main.view;
import main.Main;
import main.controller.*;
import main.model.*;
import org.apache.log4j.Logger;
import java.util.Scanner;

public class GameMenu {
    private Bot bot1 = new Bot();
    private Bot bot2 = new Bot();
    private Bot bot3 = new Bot();
    private Distributor distributor = new Distributor();
    private ProcessOfTrade processOfTrade = new ProcessOfTrade();
    private ProcessOfTradeTour2 processOfTradeTour2 = new ProcessOfTradeTour2();
    private Deck deck = new Deck();
    private Logger log = Logger.getLogger(Main.class.getName());
    private StartGame startGame = new StartGame();
    private GetResultInVist_Winner getResultInVist_winner = new GetResultInVist_Winner();
    private ChooseGame chooseGame = new ChooseGame();

    public void start() {
        menuBeforeStartGame();
        Scanner scanner = new Scanner(System.in);
        label:
        {
        int st = scanner.nextInt();

            switch (st) {
                case 1: {
                    setNameDistributor();
                    setNameBots();
                    setKindGame();
                    break label;
                }
                case 2: {
                    break;
                }
                default: {
                    log.info("Ошибка! Нажмите Run снова!");
                    break label;
                }
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
        log.info("2  - Игра до определенного количества суммарных очков в пуле");
        Scanner scanner = new Scanner(System.in);
        int kind = scanner.nextInt();
        switch(kind) {
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
        for (int i=0; i<game; i++) {
            startGame.setStartGame(deck, bot1, bot2, bot3, distributor);
            log.info("Начало раздачи " + i);
            cardsBot(bot1);
            cardsBot(bot2);
            cardsBot(bot3);
            log.info("---------------------------");
            log.info("Торг тур 1");
            log.info(processOfTrade.selectStrategy(bot1)+" говорит "+bot1.getName());
            log.info(processOfTrade.selectStrategy(bot2)+" говорит "+bot2.getName());
            log.info(processOfTrade.selectStrategy(bot3)+" говорит "+bot3.getName());
            processOfTradeTour2.trade2(bot1, bot2, bot3);
            log.info("---------------------------");
            log.info("Торг тур 2");
            log.info(bot1.getStrategyBot2()+" говорит "+bot1.getName());
            log.info(bot2.getStrategyBot2()+" говорит "+bot2.getName());
            log.info(bot3.getStrategyBot2()+" говорит "+bot3.getName());
            log.info("---------------------------");
            chooseGame.chooseG(distributor, bot1, bot2, bot3, log);
            log.info("---------------------------");
            log.info(bot1.getHill() + " Гора "+bot1.getName());
            log.info(bot1.getBullet() + " Пуля "+bot1.getName());
            log.info(bot1.getVista1() + " Вистов "+bot1.getName()+ " на "+bot2.getName());
            log.info(bot1.getVista2() + " Вистов "+bot1.getName()+ " на "+bot3.getName());
            log.info("---------------------------");
            log.info(bot2.getHill() + " Гора "+bot2.getName());
            log.info(bot2.getBullet() + " Пуля "+bot2.getName());
            log.info(bot2.getVista1() + " Вистов "+bot2.getName()+ " на "+bot1.getName());
            log.info(bot2.getVista2() + " Вистов "+bot2.getName()+ " на "+bot3.getName());
            log.info("---------------------------");
            log.info(bot3.getHill() + " Гора "+bot3.getName());
            log.info(bot3.getBullet() + " Пуля "+bot3.getName());
            log.info(bot3.getVista1() + " Вистов "+bot3.getName()+ " на "+bot1.getName());
            log.info(bot3.getVista2() + " Вистов "+bot3.getName()+ " на "+bot2.getName());
            log.info("---------------------------");
        }
        log.info("---------------------------");
        getResultInVist_winner.resultInVist(bot1, bot2, bot3);
    }

    //метод на количество пуль
    private void gameForNumberBullet() {
        Scanner scanner = new Scanner(System.in);
        int game = scanner.nextInt();
        int i=0;
        while((bot1.getBullet()+bot2.getBullet()+bot3.getBullet())<game) {
            startGame.setStartGame(deck, bot1, bot2, bot3, distributor);
            log.info("Начало раздачи " + i);
            cardsBot(bot1);
            cardsBot(bot2);
            cardsBot(bot3);
            log.info("---------------------------");
            log.info("Торг тур 1");
            log.info(processOfTrade.selectStrategy(bot1)+" говорит "+bot1.getName());
            log.info(processOfTrade.selectStrategy(bot2)+" говорит "+bot2.getName());
            log.info(processOfTrade.selectStrategy(bot3)+" говорит "+bot3.getName());
            processOfTradeTour2.trade2(bot1, bot2, bot3);
            log.info("---------------------------");
            log.info("Торг тур 2");
            log.info(bot1.getStrategyBot2()+" говорит "+bot1.getName());
            log.info(bot2.getStrategyBot2()+" говорит "+bot2.getName());
            log.info(bot3.getStrategyBot2()+" говорит "+bot3.getName());
            log.info("---------------------------");
            chooseGame.chooseG(distributor, bot1, bot2, bot3, log);
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
        }
        log.info("---------------------------");
        getResultInVist_winner.resultInVist(bot1, bot2, bot3);
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

    private void menuBeforeStartGame() {
        log.info("Добро пожаловать в симулятор игры преферанс");
        log.info("Совет: выбирайте только указанные варианты, так как обработки исключений нет");
        log.info("Выберите нужное действие:");
        log.info("1 - Перейти к началу игры и вводу начальных условий");
        log.info("2  - Выход");

    }
}
