import java.util.Random;
public class Cpu 
{
    private Pokemon cpuPokemon;
    private Pokemon playerPokemon;
    private TypeChart chart;

    public Cpu(Pokemon cpuPokemon, Pokemon playerPokemon, TypeChart chart)
    {
        this.cpuPokemon = cpuPokemon;
        this.playerPokemon = playerPokemon;
        this.chart = chart;
    }

    public Move selectMove()
    {
        Move bestMove = cpuPokemon.getMoves().get(0);

        int bestScore = -200;
        int curScore;
        Move curMove;
        Random random = new Random();

        for(int i = 0; i < cpuPokemon.getMoves().size(); i++)
        {
            curScore = 0;

            // type effectiveness

            curMove = cpuPokemon.getMoves().get(i);

            double multiplier = chart.getMultiplier(curMove.getType(), playerPokemon.getType1());

            if(playerPokemon.getType2() != null)
            {
                multiplier *= chart.getMultiplier(curMove.getType(), playerPokemon.getType2());
            }
            
            if(multiplier == 0.0)
            {
                curScore -= 100;
            }
            else if(multiplier >= 4.0)
            {
                curScore += 30;
            }
            else if(multiplier >= 2.0)
            {
                curScore += 15;
            }
            else if (multiplier == 1.0)
            {
                curScore += 0;
            }
            else if(multiplier >= 0.5)
            {
                curScore -= 15;
            }
            else if (multiplier <= 0.25)
            {
                curScore -= 30;
            }

            // checks move power

            if(curMove.getPower() >= 100)
            {
                curScore += 10;
            }
            else if(curMove.getPower() >= 80)
            {
                curScore += 5;
            }

            // checks move accuracy
            if(curMove.getAccuracy() <= 70)
            {
                curScore -= 20;
            }
            else if (curMove.getAccuracy() <= 80)
            {
                curScore -= 10;
            }
            else if (curMove.getAccuracy() <= 90)
            {
                curScore -= 5;
            }



            // checks CPU stats
            if(cpuPokemon.getAttack() > cpuPokemon.getSpecialAttack() +20 && curMove.getMoveCategory() == MoveCategory.PHYSICAL)
            {
                curScore += 15;
            }
            else if(cpuPokemon.getSpecialAttack() > cpuPokemon.getAttack() +20 && curMove.getMoveCategory() == MoveCategory.SPECIAL)
            {
                curScore += 15;
            }

            //checks player's stats

            // if playerpokemon's defense is 50 higher than its special defense
            // AND if Cpu pokemon's special attack + 50 is higher than its attack
            
            if(playerPokemon.getDefense() > playerPokemon.getSpecialDefense() + 50 &&
            curMove.getMoveCategory() == MoveCategory.SPECIAL && cpuPokemon.getSpecialAttack() + 50 > cpuPokemon.getAttack())
            {
                curScore += 10;
            }
            else if(playerPokemon.getSpecialDefense() > playerPokemon.getDefense() + 50 &&
            curMove.getMoveCategory() == MoveCategory.PHYSICAL && cpuPokemon.getAttack() + 50 > cpuPokemon.getSpecialAttack())
            {
                curScore += 10;
            } 

            // Randomness factor
            int factor = random.nextInt(11) -5;
            curScore += factor;

            // compares Scores
            if(curScore > bestScore)
            {
                bestScore = curScore;
                bestMove = curMove;
            }
        }
        
        return bestMove;
    }
}
