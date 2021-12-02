package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.security.SecureRandom;

public class Launcher {
    private static final Logger logger = LoggerFactory.getLogger("launcher");
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        long nbr = random.nextLong(100);

        if(args[0].equals("-interactive"))
        {
            Simulation simulation = new Simulation(new HumanPlayer());
            simulation.initialize(nbr,Long.MAX_VALUE);
        } else if(args[0].equals("-auto") && args[1].matches("[-+]?\\d*\\.?\\d+")) //regex qui vérifie si c'est un numeric
        {
            Simulation simulation = new Simulation(new ComputerPlayer());
            simulation.initialize(Long.parseLong(args[1]),1000);
        } else {
            logger.log("" +
                "2 manières de lancer ce jeux :\n" +
                " -interactive, jouer une partie vs l'ordinateur \n" +
                " -auto $1, faire deviner un chiffre à l'ordinateur.");

        }
    }
}
