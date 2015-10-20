package code.alexandeh.stacks.objects;

import code.alexandeh.stacks.Stacks;
import code.alexandeh.stacks.managers.ConfigManager;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.LivingEntity;

/**
 * Created by Alex on 8/17/2015.
 */
public class Stack {

    Stacks main = Stacks.getInstance();
    ConfigManager cm = main.getConfigManager();
    LivingEntity entity;
    CreatureSpawner spawner;
    int size;
    boolean lost = false;

    public Stack(LivingEntity entity, CreatureSpawner spawner) {
        this.spawner = spawner;
        this.entity = entity;
        size = 1;
    }



    private void updateDisplayName() {
        if (size > 1) {
            entity.setCustomName(cm.getString("mob-displayname").replace("{amount}", String.valueOf(size)));
            if (cm.getBoolean("mob-displayname-visible")) {
                entity.setCustomNameVisible(true);
            } else {
                entity.setCustomNameVisible(false);
            }
        } else {
            entity.setCustomName("");
        }
    }

    public void keelJuan() {
        entity = (LivingEntity) spawner.getWorld().spawnEntity(entity.getLocation(), entity.getType());
        setAmount(size - 1);
    }

    public void setAmount(int amount) {
        size = amount;
        updateDisplayName();
    }

    public int getSize() {
        return size;
    }

    public LivingEntity getEntity() {
        return entity;
    }

    public CreatureSpawner getSpawner() {
        return spawner;
    }

    public boolean isLost() {
        return lost;
    }

    public void setLost(boolean lost) {
        this.lost = lost;
    }
}
