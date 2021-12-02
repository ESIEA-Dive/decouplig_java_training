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
                "Vous pouvez lancer ce programe de deux manière :\n" +
                "en mode -interactive, vous jouerez une partie contre l'ordinateur \n" +
                "en mode -auto $1, vous pouvez faire deviner un chiffre à l'ordinateur. ($1 sera un chiffre que vous avez choisi)");

        }
    }
}
