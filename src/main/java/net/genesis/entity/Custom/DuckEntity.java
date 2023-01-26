package net.genesis.entity.Custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;

import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.InstancedAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

//import static net.genesis.entity.sounds.ModSoundEvents.DUCK_IDLE;


public class DuckEntity extends PassiveEntity implements GeoAnimatable {

    //private static final RawAnimation walking_ani = RawAnimation.begin().thenLoop("misc.walk");
    //private static final RawAnimation idle_ani = RawAnimation.begin().thenLoop("misc.idle");

    public DuckEntity(EntityType<? extends PassiveEntity> type, World world) {
        super(type, world);


    }

    @Nullable

    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return PassiveEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3);
    }

    private AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    private PlayState predicate(AnimationState state) {
        if(state.isMoving()) {
            state.getController().setAnimation(RawAnimation.begin().thenLoop(("animation.duck.walk")));
            return PlayState.CONTINUE;
        }

        state.getController().setAnimation(RawAnimation.begin().thenLoop(("animation.duck.idle")));
        return PlayState.CONTINUE;
    }

   @Override
   public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
       controllers.add(new AnimationController(this, "controller",
               0, this::predicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }



    @Override
    public double getTick(Object o) {
        return 0;
    }
    @Override
    protected void initGoals(){
        this.goalSelector.add(1, new WanderAroundGoal(this, 1.0));
        //this.goalSelector.add(2, new SwimGoal(this));
    }

    //temporary sounds
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_PARROT_HURT;

    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_COD_DEATH;

    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_PARROT_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.ENTITY_CHICKEN_STEP, 0.15f, 1.0f);
    }
}
