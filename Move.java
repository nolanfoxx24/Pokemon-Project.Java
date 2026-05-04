public class Move
{
    private String name;
    private Type type;
    private int power;
    private int accuracy;
    private MoveCategory category;

    public Move(String name, Type type, int power, int accuracy, MoveCategory category)
    {
        this.name = name;
        this.type = type;
        this.power = power;
        this.accuracy = accuracy;
        this.category = category;
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
}