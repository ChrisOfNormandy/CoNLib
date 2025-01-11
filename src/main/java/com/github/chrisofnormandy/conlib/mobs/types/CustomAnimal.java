package com.github.chrisofnormandy.conlib.mobs.types;

import java.util.UUID;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class CustomAnimal extends Animal implements NeutralMob {

    private UUID persistentAngerTarget;
    private static final EntityDataAccessor<Integer> DATA_REMAINING_ANGER_TIME;
    // private static final EntityDataAccessor<Byte> DATA_FLAGS_ID;
    private static final UniformInt PERSISTENT_ANGER_TIME;

    private static EntityType<CustomAnimal> child;

    public CustomAnimal(EntityType<? extends CustomAnimal> entityType, Level level) {
        super(entityType, level);

    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0)
                .add(Attributes.MOVEMENT_SPEED, 0.25);
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.COW_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource p_28306_) {
        return SoundEvents.COW_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.COW_DEATH;
    }

    public MobType getMobType() {
        return MobType.UNDEFINED;
    }

    protected void playStepSound(BlockPos p_28301_, BlockState p_28302_) {
        this.playSound(SoundEvents.COW_STEP, 0.15F, 1.0F);
    }

    protected float getSoundVolume() {
        return 0.4F;
    }

    public UUID getPersistentAngerTarget() {
        return this.persistentAngerTarget;
    }

    public int getRemainingPersistentAngerTime() {
        return (Integer) this.entityData.get(DATA_REMAINING_ANGER_TIME);
    }

    public void setPersistentAngerTarget(@Nullable UUID uuid) {
        this.persistentAngerTarget = uuid;
    }

    public void setRemainingPersistentAngerTime(int angerTime) {
        this.entityData.set(DATA_REMAINING_ANGER_TIME, angerTime);
    }

    public void startPersistentAngerTimer() {
        this.setRemainingPersistentAngerTime(PERSISTENT_ANGER_TIME.sample(this.random));
    }

    @Nullable
    public CustomAnimal getBreedOffspring(ServerLevel serverLevel, AgeableMob mob) {
        return child.create(serverLevel);
    }

    static {
        // DATA_FLAGS_ID = SynchedEntityData.defineId(CustomAnimal.class,
        // EntityDataSerializers.BYTE);
        DATA_REMAINING_ANGER_TIME = SynchedEntityData.defineId(CustomAnimal.class, EntityDataSerializers.INT);
        PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(20, 39);
    }
}
