package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.concurrent.TimeUnit;


public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private Long numberToGuess;

    public Simulation(Player player) {

        this.player = player;
    }

    public void initialize(long numberToGuess,long maxIterations) {

        this.numberToGuess = numberToGuess;
        loopUntilPlayerSucceed(maxIterations);
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {

        long nbr = player.askNextGuess();
        if(nbr == numberToGuess)
        {
            System.out.println("Félicitation tu as trouvé(e) le bon Chiffre :D! TROP FORT !!!");
            logger.log("End");
            return true;
        }
        else
        {
            if(nbr > numberToGuess)
                System.out.println("Votre Chiffre est plus petit");
            else
                System.out.println("Votre Chiffre est plus grand !stonk!");
            logger.log("Mauvais chiffre");
            return false;
        }
    }

    public void loopUntilPlayerSucceed(long maxIterations) {

        boolean isFound = false;
        long begin = System.currentTimeMillis();
        for(int i = 0; i<=maxIterations;i++)
        {
            isFound = nextRound();
            if(isFound)
                break;
        }
        long time = System.currentTimeMillis() - begin;
        String format = String.format("%02d:%02d.%02d",
            TimeUnit.MILLISECONDS.toMinutes(time),
            TimeUnit.MILLISECONDS.toSeconds(time),
            TimeUnit.MILLISECONDS.toMillis(time));
        if(!isFound)
            logger.log("Tu n'as pas trouvé le chiffre :/ !");
        logger.log("La partie a pris "+format+" minutes");
    }
}
