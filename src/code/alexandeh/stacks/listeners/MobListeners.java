package code.alexandeh.stacks.listeners;

import code.alexandeh.stacks.Stacks;
import code.alexandeh.stacks.managers.ConfigManager;
import code.alexandeh.stacks.managers.StackManager;
import code.alexandeh.stacks.objects.Stack;
import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.SpawnerSpawnEvent;

/**
 * Created by Alex on 8/17/2015.
 */
public class MobListeners implements Listener {

    private Stacks main = Stacks.getInstance();
    private StackManager sm = main.getStackManager();
    private ConfigManager cm = main.getConfigManager();

    public MobListeners() {
        Bukkit.getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void onDeath(EntityDeathEvent e) {
        if (sm.getStack(e.getEntity()) != null) {
            if (!(sm.getStack(e.getEntity()).getSize() <= 1)) {
                sm.getStack(e.getEntity()).keelJuan();
            }
        }
    }


    @EventHandler
    public void onSpawn(SpawnerSpawnEvent e) {
        if (e.getEntity() instanceof LivingEntity) {

            if (sm.getStack(e.getSpawner()) == null) {
                sm.createStack((LivingEntity) e.getEntity(), e.getSpawner());
                return;
            }

            Stack stack = sm.getStack(e.getSpawner());
            if (e.getSpawner().getLocation().distance(stack.getEntity().getLocation()) > cm.getDouble("mob-distance")) {
                stack.setLost(true);
                sm.createStack((LivingEntity) e.getEntity(), e.getSpawner());
                return;
            }

            if (stack.getSize() > cm.getInt("max-stack")) {
                sm.createStack((LivingEntity) e.getEntity(), e.getSpawner());
                return;
            }

            if (stack.isLost()) {
                return;
            }

            e.setCancelled(true);
            stack.setAmount(stack.getSize() + 1);
        }
    }
}
