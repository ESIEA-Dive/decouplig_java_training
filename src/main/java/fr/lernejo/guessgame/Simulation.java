package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.concurrent.TimeUnit;


public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;  //TODO add variable type
    private Long numberToGuess; //TODO add variable type

    public Simulation(Player player) {
        //TODO implement me
        this.player = player;
    }

    public void initialize(long numberToGuess,long maxIterations) {
        //TODO implement me
        this.numberToGuess = numberToGuess;
        loopUntilPlayerSucceed(maxIterations);
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        //TODO implement me
        long nbr = player.askNextGuess();
        if(nbr == numberToGuess)
        {
            System.out.println("Félicitation vous avez trouvé(e) le bon Chiffre !!!");
            logger.log("End");
            return true;
        }
        else
        {
            if(nbr > numberToGuess)
                System.out.println("Votre Chiffre est plus grand");
            else
                System.out.println("Votre Chiffre est plus petit");
            logger.log("Mauvais chiffre");
            return false;
        }
    }

    public void loopUntilPlayerSucceed(long maxIterations) {
        //TODO implement me
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
            logger.log("Le joueur n'a pas trouvé le chiffre");
        logger.log("La partie a pris "+format+" minutes");
    }
}
