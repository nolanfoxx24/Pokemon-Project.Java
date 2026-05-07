import java.util.Random;

public class Battle
{
    private Pokemon playerPokemon;
    private Pokemon cpuPokemon;
    private TypeChart chart;
    
    public Battle(Pokemon playerPokemon, Pokemon cpuPokemon, TypeChart chart)
    {
        this.playerPokemon = playerPokemon;
        this.cpuPokemon = cpuPokemon;
        this.chart = chart;
    }

    public void damageText(Pokemon attackingPokemon, Pokemon defendingPokemon, Move attackingMove, double damage)
    {
        System.out.println("------------------------------------------------------------------");
        System.out.println(attackingPokemon.getName() + " used " + attackingMove.getName() + "!");
        System.out.println("------------------------------------------------------------------");

        System.out.println(attackingMove.getName() + " deals " + (int) damage + " damage! " + defendingPokemon.getName() + " has " + defendingPokemon.getCurrentHp() + " HP remaining" );
    }

    public void applyEndOfTurnEffects(Pokemon p)
    {
        if(p.getStatus() == Status.BURNED)
        {
            double burnDmg = p.getMaxHp() * (1.0/16);
            p.takeDamage((int) burnDmg);

            System.out.println("------------------------------------------------------------------");
            System.out.println(p.getName() + " was hurt by its burn!");
            System.out.println("Damage: " + (int) burnDmg );
            System.out.println("------------------------------------------------------------------");
        }
        else if(p.getStatus() == Status.POISONED)
        {
            double poisonDmg = p.getMaxHp() * (1.0/8);
            p.takeDamage((int) poisonDmg);

            System.out.println("------------------------------------------------------------------");
            System.out.println(p.getName() + " was hurt by its poison!");
            System.out.println("Damage: " + (int) poisonDmg );
            System.out.println("------------------------------------------------------------------");
        }
    }

    public void applyStatusFromMove(Move move, Pokemon defender)
    {
        if(move.inflictsStatus() && !defender.hasStatus())
        {
            Random random = new Random();
            int roll = random.nextInt(100) + 1;

            if(roll <= move.getStatusChance())
            {
                defender.setStatus(move.getStatus());
            }
        }
    }

    public boolean canMove(Pokemon attacker)
    {
        if(!attacker.hasStatus())
        {
            return true;
        }

        if(attacker.getStatus() != Status.PARALYSIS)
        {
            return true;
        }

        Random random = new Random();
        int roll = random.nextInt(100) + 1;

        if(roll <= 25)
        {
            return false;
        }

        return true;
    }

    public void executeTurn(Pokemon attackingPokemon, Pokemon defendingPokemon, Move attackingMove )
    {
        if(!canMove(attackingPokemon))
        {
            System.out.println(attackingPokemon.getName() + " is unable to move!");
            return;
        }

        Random rand = new Random();
        int roll = rand.nextInt(100) + 1; // gives a number from 1 to 100

        if(roll <= attackingMove.getAccuracy())
        {
            int atkStat;
            int defStat;
            
            if(attackingMove.getMoveCategory() == MoveCategory.PHYSICAL )
            {
                atkStat = attackingPokemon.getAttack();
                defStat = defendingPokemon.getDefense();
            }

            else
            {
                atkStat = attackingPokemon.getSpecialAttack();
                defStat = defendingPokemon.getSpecialDefense();
            }

            if(attackingPokemon.getStatus() == Status.BURNED && attackingMove.getMoveCategory() == MoveCategory.PHYSICAL)
            {
                atkStat = (int) (atkStat * 0.5);
            }

            // Damage calcuation
            double multiplier = chart.getMultiplier(attackingMove.getType(), defendingPokemon.getType1());
            if(defendingPokemon.getType2() != null)
            {
                multiplier *= chart.getMultiplier(attackingMove.getType(), defendingPokemon.getType2());
            }

            double damage = ((double) atkStat) / defStat * attackingMove.getPower() * multiplier;
            
            defendingPokemon.takeDamage((int) damage);
            applyStatusFromMove(attackingMove, defendingPokemon);
            
            if(multiplier == 0.0)
            {
                System.out.println("------------------------------------------------------------------");
                System.out.println(attackingPokemon.getName() + " used " + attackingMove.getName() + "!");
                System.out.println("------------------------------------------------------------------");
                System.out.println("it had no effect!");
            }

            else if(multiplier == 1.0)
            {
                damageText(attackingPokemon, defendingPokemon, attackingMove, damage);
            }

            else if(multiplier >= 2.0)
            {
                damageText(attackingPokemon, defendingPokemon, attackingMove, damage);
                System.out.println("It's super effective! ");
            }

            else if(multiplier < 1.0 )
            {
                damageText(attackingPokemon, defendingPokemon, attackingMove, damage);
                System.out.println("It's not very effective...");
            }
        }

        else
        {
            System.out.println("------------------------------------------------------------------");
            System.out.println(attackingPokemon.getName() + " missed!");
        }
    }
}