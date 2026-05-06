public class Move
{
    private String name;
    private Type type;
    private int power;
    private int accuracy;
    private MoveCategory category;
    private Status status;
    private int statusChance;

    // move without status effect
    public Move(String name, Type type, int power, int accuracy, MoveCategory category)
    {
        this.name = name;
        this.type = type;
        this.power = power;
        this.accuracy = accuracy;
        this.category = category;
        this.status = null;
        this.statusChance = 0;
    }

    // move with status effect
    public Move(String name, Type type, int power, int accuracy, MoveCategory category, Status status, int statusChance)
    {
        this.name = name;
        this.type = type;
        this.power = power;
        this.accuracy = accuracy;
        this.category = category;
        this.status = status;
        this.statusChance = statusChance;
    }

    public String getName()
    {
        return name;
    }

    public Type getType()
    {
        return type;
    }

    public int getPower()
    {
        return power;
    }
    
    public int getAccuracy()
    {
        return accuracy;
    }

    public MoveCategory getMoveCategory()
    {
        return category;
    }
    
    public Status getStatus()
    {
        return status;
    }

    public int getStatusChance()
    {
        return statusChance;
    }

    public boolean inflictsStatus()
    {
        return status != null;
    }
}