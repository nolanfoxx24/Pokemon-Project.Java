import java.util.*;
public class TypeChart
{
    private HashMap<Type, HashMap<Type, Double>> chart;
    // adds type matchups, variables for attacker, and HashMap with defender type and multiplier
    public void addMatchup(Type attacker, Type defender, double multiplier)
    {
        if(chart.containsKey(attacker))
        {
            chart.get(attacker).put(defender, multiplier);
        }
        else
        {
            HashMap<Type, Double> innerMap = new HashMap<>();
            chart.put(attacker, innerMap);
            innerMap.put(defender, multiplier);
        }
    }

    private void buildMatchups()
    {
        // Normal
        addMatchup(Type.NORMAL, Type.ROCK, 0.5);
        addMatchup(Type.NORMAL, Type.GHOST, 0.0);
        addMatchup(Type.NORMAL, Type.STEEL, 0.5);

        // Fire
        addMatchup(Type.FIRE, Type.FIRE, 0.5);
        addMatchup(Type.FIRE, Type.WATER, 0.5);
        addMatchup(Type.FIRE, Type.GRASS, 2.0);
        addMatchup(Type.FIRE, Type.ICE, 2.0);
        addMatchup(Type.FIRE, Type.BUG, 2.0);
        addMatchup(Type.FIRE, Type.ROCK, 0.5);
        addMatchup(Type.FIRE, Type.DRAGON, 0.5);
        addMatchup(Type.FIRE, Type.STEEL, 2.0);

        // Water
        addMatchup(Type.WATER, Type.FIRE, 2.0);
        addMatchup(Type.WATER, Type.WATER, 0.5);
        addMatchup(Type.WATER, Type.GRASS, 0.5);
        addMatchup(Type.WATER, Type.GROUND, 2.0);
        addMatchup(Type.WATER, Type.ROCK, 2.0);
        addMatchup(Type.WATER, Type.DRAGON, 0.5);

        // Electric
        addMatchup(Type.ELECTRIC, Type.WATER, 2.0);
        addMatchup(Type.ELECTRIC, Type.ELECTRIC, 0.5);
        addMatchup(Type.ELECTRIC, Type.GRASS, 0.5);
        addMatchup(Type.ELECTRIC, Type.GROUND, 0.0);
        addMatchup(Type.ELECTRIC, Type.FLYING, 2.0);
        addMatchup(Type.ELECTRIC, Type.DRAGON, 0.5);

        // Grass
        addMatchup(Type.GRASS, Type.FIRE, 0.5);
        addMatchup(Type.GRASS, Type.WATER, 2.0);
        addMatchup(Type.GRASS, Type.GRASS, 0.5);
        addMatchup(Type.GRASS, Type.POISON, 0.5);
        addMatchup(Type.GRASS, Type.GROUND, 2.0);
        addMatchup(Type.GRASS, Type.FLYING, 0.5);
        addMatchup(Type.GRASS, Type.BUG, 0.5);
        addMatchup(Type.GRASS, Type.ROCK, 2.0);
        addMatchup(Type.GRASS, Type.DRAGON, 0.5);
        addMatchup(Type.GRASS, Type.STEEL, 0.5);

        // Ice
        addMatchup(Type.ICE, Type.WATER, 0.5);
        addMatchup(Type.ICE, Type.GRASS, 2.0);
        addMatchup(Type.ICE, Type.ICE, 0.5);
        addMatchup(Type.ICE, Type.GROUND, 2.0);
        addMatchup(Type.ICE, Type.FLYING, 2.0);
        addMatchup(Type.ICE, Type.DRAGON, 2.0);
        addMatchup(Type.ICE, Type.STEEL, 0.5);

        // Fighting
        addMatchup(Type.FIGHTING, Type.NORMAL, 2.0);
        addMatchup(Type.FIGHTING, Type.ICE, 2.0);
        addMatchup(Type.FIGHTING, Type.POISON, 0.5);
        addMatchup(Type.FIGHTING, Type.ROCK, 2.0);
        addMatchup(Type.FIGHTING, Type.BUG, 2.0);
        addMatchup(Type.FIGHTING, Type.GHOST, 0.0);
        addMatchup(Type.FIGHTING, Type.STEEL, 2.0);
        addMatchup(Type.FIGHTING, Type.PSYCHIC, 0.5);
        addMatchup(Type.FIGHTING, Type.FLYING, 0.5);
        addMatchup(Type.FIGHTING, Type.FAIRY, 0.5);
        addMatchup(Type.FIGHTING, Type.DARK, 2.0);

        // Poison 
        addMatchup(Type.POISON, Type.GRASS, 2.0);
        addMatchup(Type.POISON, Type.POISON, 0.5);
        addMatchup(Type.POISON, Type.GROUND, 0.5);
        addMatchup(Type.POISON, Type.ROCK, 0.5);
        addMatchup(Type.POISON, Type.STEEL, 0.0);
        addMatchup(Type.POISON, Type.FAIRY, 2.0);

        // Ground 
        addMatchup(Type.GROUND, Type.FIRE, 2.0);
        addMatchup(Type.GROUND, Type.ELECTRIC, 2.0);
        addMatchup(Type.GROUND, Type.GRASS, 0.5);
        addMatchup(Type.GROUND, Type.POISON, 2.0);
        addMatchup(Type.GROUND, Type.FLYING, 0.0);
        addMatchup(Type.GROUND, Type.BUG, 0.5);
        addMatchup(Type.GROUND, Type.ROCK, 2.0);
        addMatchup(Type.GROUND, Type.STEEL, 2.0);

        // Flying 
        addMatchup(Type.FLYING, Type.ELECTRIC, 0.5);
        addMatchup(Type.FLYING, Type.GRASS, 2.0);
        addMatchup(Type.FLYING, Type.FIGHTING, 2.0);
        addMatchup(Type.FLYING, Type.BUG, 2.0);
        addMatchup(Type.FLYING, Type.ROCK, 0.5);
        addMatchup(Type.FLYING, Type.STEEL, 0.5);

        // Psychic 
        addMatchup(Type.PSYCHIC, Type.FIGHTING, 2.0);
        addMatchup(Type.PSYCHIC, Type.POISON, 2.0);
        addMatchup(Type.PSYCHIC, Type.DARK, 0.0);
        addMatchup(Type.PSYCHIC, Type.STEEL, 0.5);
        addMatchup(Type.PSYCHIC, Type.PSYCHIC, 0.5);

        // Bug 
        addMatchup(Type.BUG, Type.FIRE, 0.5);
        addMatchup(Type.BUG, Type.GRASS, 2.0);
        addMatchup(Type.BUG, Type.FIGHTING, 0.5);
        addMatchup(Type.BUG, Type.POISON, 0.5);
        addMatchup(Type.BUG, Type.FLYING, 0.5);
        addMatchup(Type.BUG, Type.GHOST, 0.5);
        addMatchup(Type.BUG, Type.STEEL, 0.5);
        addMatchup(Type.BUG, Type.PSYCHIC, 2.0);
        addMatchup(Type.BUG, Type.DARK, 2.0);
        addMatchup(Type.BUG, Type.FAIRY, 0.5);

        // Rock 
        addMatchup(Type.ROCK, Type.FIRE, 2.0);
        addMatchup(Type.ROCK, Type.ICE, 2.0);
        addMatchup(Type.ROCK, Type.FIGHTING, 0.5);
        addMatchup(Type.ROCK, Type.GROUND, 0.5);
        addMatchup(Type.ROCK, Type.FLYING, 2.0);
        addMatchup(Type.ROCK, Type.BUG , 2.0);
        addMatchup(Type.ROCK, Type.STEEL, 0.5);

        // Ghost 
        addMatchup(Type.GHOST, Type.NORMAL, 0.0);
        addMatchup(Type.GHOST, Type.GHOST, 2.0);
        addMatchup(Type.GHOST, Type.PSYCHIC, 2.0);
        addMatchup(Type.GHOST, Type.DARK, 0.5);

        // Dragon 
        addMatchup(Type.DRAGON, Type.DRAGON, 2.0);
        addMatchup(Type.DRAGON, Type.STEEL, 0.5);
        addMatchup(Type.DRAGON, Type.FAIRY, 0.5);

        // Dark 
        addMatchup(Type.DARK, Type.FIGHTING, 0.5);
        addMatchup(Type.DARK, Type.GHOST, 2.0);
        addMatchup(Type.DARK, Type.PSYCHIC, 2.0);
        addMatchup(Type.DARK, Type.DARK, 0.5);
        addMatchup(Type.DARK, Type.FAIRY, 0.5);

        // Steel
        addMatchup(Type.STEEL, Type.FIRE, 0.5);
        addMatchup(Type.STEEL, Type.WATER, 0.5);
        addMatchup(Type.STEEL, Type.ELECTRIC, 0.5);
        addMatchup(Type.STEEL, Type.ICE, 2.0);
        addMatchup(Type.STEEL, Type.ROCK, 2.0);
        addMatchup(Type.STEEL, Type.STEEL, 0.5);
        addMatchup(Type.STEEL, Type.FAIRY, 2.0);

        addMatchup(Type.FAIRY, Type.FIRE, 0.5);
        addMatchup(Type.FAIRY, Type.FIGHTING , 2.0);
        addMatchup(Type.FAIRY, Type.POISON, 0.5);
        addMatchup(Type.FAIRY, Type.DRAGON, 2.0);
        addMatchup(Type.FAIRY, Type.DARK, 2.0);
        addMatchup(Type.FAIRY, Type.STEEL, 0.5);
    }

    public TypeChart()
    {
        chart = new HashMap<>();
        buildMatchups();

    }

    public double getMultiplier(Type attacker, Type defender)
    {


        if (chart.containsKey(attacker) && chart.get(attacker).containsKey(defender))
        {
            return chart.get(attacker).get(defender);
        }
        else
        {
            return 1.0;
        }
    }
    
}
