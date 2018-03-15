package main.controller;
import org.apache.log4j.Logger;
import main.model.Bot;
import main.model.Distributor;


public interface GameStrategy {
    void run(Distributor distributor, Bot bot1, Bot bot2, Bot bot3, Logger log);
}
