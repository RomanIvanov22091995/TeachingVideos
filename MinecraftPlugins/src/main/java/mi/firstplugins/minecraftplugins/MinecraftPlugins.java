package mi.firstplugins.minecraftplugins;

import mi.firstplugins.minecraftplugins.commands.CalculatorCMD;
import org.bukkit.plugin.java.JavaPlugin;

public final class MinecraftPlugins extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Hello,world!");
       getCommand("calculator").setExecutor(new CalculatorCMD());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Bye,world!");

    }
}
