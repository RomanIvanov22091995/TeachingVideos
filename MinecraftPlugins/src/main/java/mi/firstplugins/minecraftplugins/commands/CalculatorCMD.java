package mi.firstplugins.minecraftplugins.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CalculatorCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        // /calc 10+12 ["10","+","12"]
        int a,b;
        try {
            a = Integer.parseInt(args[0]);
            b = Integer.parseInt(args[1]);
        }catch (NumberFormatException e ){
            return false;
        }

        switch (args[2]){
            case "+"->{
                sender.sendMessage("Result = "+ (a + b));
                return true;
            }
            case "-"->{
                sender.sendMessage("Result = "+ (a - b));
                return true;
            }
            case "*"->{
                sender.sendMessage("Result = "+ (a * b));
                return true;
            }
            case "/"->{
                sender.sendMessage("Result = "+ (a / b));
                return true;
            }
        }
        return false;
    }
}
