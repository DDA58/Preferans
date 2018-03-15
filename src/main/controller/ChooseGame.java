package main.controller;
import org.apache.log4j.Logger;
import main.model.Bot;
import main.model.Distributor;

public class ChooseGame {
    public void chooseG(Distributor distributor, Bot bot1, Bot bot2, Bot bot3, Logger log) {
        if(bot1.getStrategyBot2().equals("Contract")|bot2.getStrategyBot2().equals("Contract")|bot3.getStrategyBot2().equals("Contract")) {
            Contract contract = new Contract();
            contract.run(distributor, bot1, bot2, bot3, log);
        }
        if(bot1.getStrategyBot2().equals("Misery")|bot2.getStrategyBot2().equals("Misery")|bot3.getStrategyBot2().equals("Misery")) {
            Misery misery = new Misery();
            misery.run(distributor, bot1, bot2, bot3, log);
        }
        if(bot1.getStrategyBot2().equals("Pas")&bot2.getStrategyBot2().equals("Pas")&bot3.getStrategyBot2().equals("Pas")) {
            Unpacking unpacking = new Unpacking();
            unpacking.run(distributor, bot1, bot2, bot3, log);
        }

    }
}
