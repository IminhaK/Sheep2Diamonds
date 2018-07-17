package net.bloop.sheeptodiamonds;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class SheepHit {

    @SubscribeEvent
    public void hitSheep(LivingDamageEvent event)
    {
        Entity target = event.getEntity();
        World world = target.getEntityWorld();

        //!world.isRemote MEANS SERVER SIDE ONLY
        if(target instanceof EntitySheep && !world.isRemote)
        {
            world.spawnEntity(new EntityItem(world, target.posX, target.posY, target.posZ, new ItemStack(Items.DIAMOND)));
        }
    }
}
