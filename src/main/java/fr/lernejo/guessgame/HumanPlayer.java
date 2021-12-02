package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class HumanPlayer implements Player{

    Scanner sc = new Scanner(System.in);
    private final Logger logger = LoggerFactory.getLogger("Player");
    @Override
    public long askNextGuess() {
        System.out.println("Veuillez donner un nombre");
        Scanner sc = new Scanner(System.in);
        long nbr = sc.nextLong();
        logger.log("" + nbr);
        return nbr;
    }

    @Override
    public void respond(boolean lowerOrGreater) {

    }
}
