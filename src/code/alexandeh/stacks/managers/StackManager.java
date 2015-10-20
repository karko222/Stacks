package code.alexandeh.stacks.managers;

import code.alexandeh.stacks.objects.Stack;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.LivingEntity;

import java.util.HashSet;

/**
 * Created by Alex on 8/17/2015.
 */
public class StackManager {

    private HashSet<Stack> stacks = new HashSet<>();

    public void createStack(LivingEntity entity, CreatureSpawner spawner) {
        Stack stack = new Stack(entity, spawner);
        stacks.add(stack);
    }

    public HashSet<Stack> getStacks() {
        return stacks;
    }

    public Stack getStack(LivingEntity entity) {
        for (Stack stack : getStacks()) {
            if (stack.getEntity().getEntityId() == entity.getEntityId()) {
                return stack;
            }
        }
        return null;
    }

    public Stack getStack(CreatureSpawner spawner) {
        for (Stack stack : getStacks()) {
            if (stack.getSpawner().getBlock().getX() == spawner.getBlock().getX() && stack.getSpawner().getBlock().getZ() == spawner.getBlock().getZ() && stack.getSpawner().getBlock().getY() == spawner.getBlock().getY()) {
                return stack;
            }
        }
        return null;
    }
}
