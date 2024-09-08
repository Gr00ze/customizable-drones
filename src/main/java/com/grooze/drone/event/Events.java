package com.grooze.drone.event;

import com.grooze.drone.entity.TestDroneEntity;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class Events {

    public static void init(){
        //UseEntityCallback.EVENT.register(Events::useEntity);
        //UseBlockCallback.EVENT.register(Events::useBlock);
        //UseItemCallback.EVENT.register(Events::useItem);

        UseEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            if (entity instanceof TestDroneEntity) {
                System.out.println("Interazione rilevata tramite evento Fabric!");
                return ActionResult.PASS;
            }
            return ActionResult.PASS;
        });


    }

    private static TypedActionResult<ItemStack> useItem(PlayerEntity playerEntity, World world, Hand hand) {
        System.out.println("Item Eseguito ");
        return TypedActionResult.pass(null);

    }

    private static ActionResult useBlock(PlayerEntity playerEntity, World world, Hand hand, BlockHitResult blockHitResult) {
        System.out.println("Block Eseguito ");
        return ActionResult.PASS;
    }

    private static ActionResult useEntity(PlayerEntity playerEntity, World world, Hand hand, Entity entity, EntityHitResult entityHitResult) {
        System.out.println("Entity Eseguito ");

        return ActionResult.PASS;
    }




}
