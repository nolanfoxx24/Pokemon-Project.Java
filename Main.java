import java.util.Scanner;
public class Main
{
    private static void splashScreen(Scanner input)
    {
        System.out.println("Welcome to the Pokemon Battle Simulator Java Edition!");
        System.out.println("-- By Nolan Foxx");
        System.out.println("-------------------------------------------------------\n");

        System.out.println("────────▄███████████▄────────");
        System.out.println("─────▄███▓▓▓▓▓▓▓▓▓▓▓███▄─────");
        System.out.println("────███▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓███────");
        System.out.println("───██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██───");
        System.out.println("──██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██──");
        System.out.println("─██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██─");
        System.out.println("██▓▓▓▓▓▓▓▓▓███████▓▓▓▓▓▓▓▓▓██");
        System.out.println("██▓▓▓▓▓▓▓▓██░░░░░██▓▓▓▓▓▓▓▓██");
        System.out.println("██▓▓▓▓▓▓▓██░░███░░██▓▓▓▓▓▓▓██");
        System.out.println("███████████░░███░░███████████");
        System.out.println("██░░░░░░░██░░███░░██░░░░░░░██");
        System.out.println("██░░░░░░░░██░░░░░██░░░░░░░░██");
        System.out.println("██░░░░░░░░░███████░░░░░░░░░██");
        System.out.println("─██░░░░░░░░░░░░░░░░░░░░░░░██─");
        System.out.println("──██░░░░░░░░░░░░░░░░░░░░░██──");
        System.out.println("───██░░░░░░░░░░░░░░░░░░░██───");
        System.out.println("────███░░░░░░░░░░░░░░░███────");
        System.out.println("─────▀███░░░░░░░░░░░███▀─────");
        System.out.println("────────▀███████████▀────────");
        
        System.out.println("\n-------------------------------------------------------");

        System.out.println("Press ENTER to begin");
        input.nextLine();

    }
    private static Move getPlayerMove(Pokemon playerPokemon, Scanner playerInput)
    {
        System.out.println("\nYour Pokemon " + playerPokemon.getName() + " Moves: ");

            System.out.println("--------------------------------------");

            for(int i = 0; i < playerPokemon.getMoves().size(); i++)
            {
                System.out.println((i+1) + ". " + playerPokemon.getMoves().get(i).getName());
            }

        System.out.println("\nType the Number in front of the move you want to select");

        int input = playerInput.nextInt() - 1;
        playerInput.nextLine();

        // if Player selects a move that doesnt exist
        while(input > playerPokemon.getMoves().size() -1 || input < 0)
        {
            System.out.println("Invalid option, type the number in front of the move");
            input = playerInput.nextInt() -1;
            playerInput.nextLine();
        }
            return playerPokemon.getMoves().get(input);
    }
    public static void main(String[] args)
    {
        Scanner playerInput = new Scanner(System.in);
        TypeChart chart = new TypeChart();

        int playerHpLvl50 = Pokemon.calcStat(100, 50, true);
        int playerAtkLvl50 = Pokemon.calcStat(120, 50, false);
        int playerDefLvl50 = Pokemon.calcStat(65, 50, false);
        int playerSpAtkLvl50 = Pokemon.calcStat(45, 50, false);
        int playerSpDefLvl50 = Pokemon.calcStat(85, 50, false);
        int playerSpeLvl50 = Pokemon.calcStat(125, 50, false);

        Pokemon weavile = new Pokemon("Weavile", Type.DRAGON, null, playerHpLvl50, playerAtkLvl50,
        playerSpAtkLvl50, playerDefLvl50, playerSpDefLvl50, playerSpeLvl50);

        int cpuHpLvl50 = Pokemon.calcStat(100, 50, true);
        int cpuAtkLvl50 = Pokemon.calcStat(130, 50, false);
        int cpuDefLvl50 = Pokemon.calcStat(95, 50, false);
        int cpuSpAtkLvl50 = Pokemon.calcStat(80, 50, false);
        int cpuSpDefLvl50 = Pokemon.calcStat(85, 50, false);
        int cpuSpeLvl50 = Pokemon.calcStat(102, 50, false);

        Move iciclecrash = new Move("Icicle Crash", Type.ICE, 85, 90, MoveCategory.PHYSICAL);
        Move knockoff = new Move("Knock Off", Type.DARK, 65, 100, MoveCategory.PHYSICAL);
        Move iceShard = new Move("Ice Shard", Type.ICE, 40, 100, MoveCategory.PHYSICAL);

        weavile.addMove(iceShard);
        weavile.addMove(knockoff);
        weavile.addMove(iciclecrash);

        Pokemon garchomp = new Pokemon("Garchomp", Type.DRAGON, Type.GROUND, cpuHpLvl50, cpuAtkLvl50, 
        cpuSpAtkLvl50, cpuDefLvl50, cpuSpDefLvl50, cpuSpeLvl50);

        Move earthquake = new Move("Earthquake", Type.GROUND, 100, 100, MoveCategory.PHYSICAL);
        Move dragonclaw = new Move("Dragon Claw", Type.DRAGON, 80, 100, MoveCategory.PHYSICAL);
        Move stoneedge = new Move("Stone Edge",Type.ROCK, 100, 80, MoveCategory.PHYSICAL);
        Move firefang = new Move("Fire Fang", Type.FIRE, 65, 95, MoveCategory.PHYSICAL);

        garchomp.addMove(earthquake);
        garchomp.addMove(dragonclaw);
        garchomp.addMove(stoneedge);
        garchomp.addMove(firefang);

        Pokemon faster;
        Pokemon slower;
        Pokemon playerPokemon = weavile;
        Pokemon cpuPokemon = garchomp;
        
        Battle mainBattle = new Battle(playerPokemon, cpuPokemon, chart);

        Cpu cpu = new Cpu(cpuPokemon, playerPokemon, chart);

        splashScreen(playerInput);

        if(playerPokemon.getSpeed() > cpuPokemon.getSpeed())
        {
            faster = playerPokemon;
            slower = cpuPokemon;
        }

        else
        {
            slower = playerPokemon;
            faster = cpuPokemon;
        }

        // Battle Loop -----

        while(faster.getCurrentHp() > 0 && slower.getCurrentHp() > 0)
        {
            if (faster == playerPokemon)
            {
                mainBattle.executeTurn(playerPokemon, slower, getPlayerMove(playerPokemon, playerInput));
            }

            else
            {
                mainBattle.executeTurn(cpuPokemon, slower, cpu.selectMove());
            }

            if(slower.getCurrentHp() == 0)
                {
                    break; 
                }

            if(slower == playerPokemon)
            {
                mainBattle.executeTurn(playerPokemon, faster, getPlayerMove(playerPokemon, playerInput));
            }

            else
            {
                mainBattle.executeTurn(cpuPokemon, faster, cpu.selectMove());
            }
            
            mainBattle.applyEndOfTurnEffects(faster);
            mainBattle.applyEndOfTurnEffects(slower);
        }

            System.out.println(" ------------- Battle Ended -------------");

            if (faster.getCurrentHp() > 0)
            {
                System.out.println(faster.getName() + " won the battle!");
            }
            else
            {
                System.out.println(slower.getName() + " won the battle!");
            }
            System.out.println(faster.getName() + " Hp " + faster.getCurrentHp()); 
            System.out.println(slower.getName() + " Hp " + slower.getCurrentHp());
    }
}