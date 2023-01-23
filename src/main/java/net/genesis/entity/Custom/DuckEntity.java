package net.genesis.entity.Custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Tameable;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.registry.Registry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.apache.commons.codec.digest.MurmurHash3;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.InstancedAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

//import static net.genesis.entity.sounds.ModSoundEvents.DUCK_IDLE;


public class DuckEntity extends PassiveEntity implements GeoAnimatable {

    //private static final RawAnimation walking_ani = RawAnimation.begin().thenLoop("animation.duck.walk");
    private static final RawAnimation idle_ani = RawAnimation.begin().thenLoop("idle");

    public DuckEntity(EntityType<? extends PassiveEntity> entityType, World world) {
        super(entityType, world);


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

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);



    private <E extends GeoAnimatable>PlayState ani(AnimationState<E> event){
        if (event.isMoving()){
            //event.getController().setAnimation(walking_ani);
            //return  PlayState.CONTINUE;
        }
        event.getController().setAnimation(RawAnimation.begin().thenPlay("idle"));
        return PlayState.CONTINUE;

    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        //controllerRegistrar.add(new AnimationController(this, "controller", 0, this::ani));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }



    @Override
    public double getTick(Object o) {
        return 0;
    }
    @Override
    protected void initGoals(){
        this.goalSelector.add(1, new WanderAroundGoal(this, 1.0));
        this.goalSelector.add(2, new SwimGoal(this));
    }

    //public static final SoundEvent ENTITY_DUCK_IDLE = Registry.register("entity.duck.idle");
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
