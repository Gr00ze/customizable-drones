package com.grooze.drone.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

import static com.grooze.drone.util.DebugLog.print;

public class TestDroneEntity extends Entity {


    public TestDroneEntity(EntityType<?> type, World world) {
        super(type, world);
        noClip = false;
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {

    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {

    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {

    }

    @Override
    public void tick() {
        super.tick();

        World world = this.getWorld();
        Box bb = this.getBoundingBox();

        List<Entity> inbox = world.getOtherEntities(this,bb);


        //System.out.println(inbox);
        print(0, inbox.toString());
        print(1, String.valueOf(noClip));

    }

    @Override
    public ActionResult interact(PlayerEntity player, Hand hand) {
        System.out.println("Va");
        ActionResult actionResult = super.interact(player, hand);
        if (actionResult != ActionResult.PASS) {
            return actionResult;
        } else if (player.shouldCancelInteraction()) {
            return ActionResult.PASS;
        } else if (0F < 60.0F) {
            if (!this.getWorld().isClient) {
                return player.startRiding(this) ? ActionResult.CONSUME : ActionResult.PASS;
            } else {
                return ActionResult.SUCCESS;
            }
        } else {
            return ActionResult.PASS;
        }
    }

    @Override
    public ActionResult interactAt(PlayerEntity player, Vec3d hitPos, Hand hand) {
        System.out.println("Va2");
        return super.interactAt(player, hitPos, hand);
    }

    public boolean isCollidable() {
        return true;
    }

    public boolean canHit() {
        return !this.isRemoved();
    }

    protected boolean canAddPassenger(Entity passenger) {
        return this.getPassengerList().size() < this.getMaxPassengers() && !this.isSubmergedIn(FluidTags.WATER);
    }

    protected int getMaxPassengers() {
        return 1;
    }


}
