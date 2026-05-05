import java.util.ArrayList;

public class Pokemon 
{
    private String name;

    private Type type1;
    private Type type2;

    private int maxHp;
    private int currentHp;

    private int attack;
    private int specialAttack;

    private int defense;
    private int specialDefense;

    private int speed;

    private Status status;

    private ArrayList<Move> moves = new ArrayList<>();

    public Pokemon(String name, Type type1, Type type2, int maxHp, int attack,
    int specialAttack, int defense, int specialDefense, int speed)
    {
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.attack = attack;
        this.specialAttack = specialAttack;
        this.defense = defense;
        this.specialDefense = specialDefense;
        this.speed = speed;
        this.status = null;

    }

    public static int calcStat(int base, int level, boolean isHp)
    {
        int newStat = 0;

        if(isHp)
        {
            newStat = ((2 * base * level) / 100) + 10 + level;
        }
        else
        {
            newStat = ((2* base * level) / 100) + 5;
        }
        return newStat;
    }

    public void addMove(Move move)
    {
        moves.add(move);
    }

    public String getName()
    {
        return name;
    }

    public Type getType1()
    {
        return type1;
    }

    public Type getType2()
    {
        return type2;
    }

    public int getMaxHp()
    {
        return maxHp;
    }

    public int getCurrentHp()
    {
        return currentHp;
    }

    public int getAttack()
    {
        return attack;
    }

    public int getSpecialAttack()
    {
        return specialAttack;
    }

    public int getDefense()
    {
        return defense;
    }

    public int getSpecialDefense()
    {
        return specialDefense;
    }

    public int getSpeed()
    {
        return speed;
    }

    public ArrayList<Move> getMoves()
    {
        return moves;
    }

    public Status geStatus()
    {
        return status;
    }
    
    public void setStatus(Status newStatus)
    {
        status = newStatus;
    }
    
    public void takeDamage(int damage)
    {
        currentHp -= damage;
        if(currentHp < 0)
        {
            currentHp = 0;
        }
    }
}
