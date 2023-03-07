package com.monky.alstakka.entity.custom;

import com.monky.alstakka.entity.ModEntityTypes;
import com.monky.alstakka.item.ModItems;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class ThrownDipEntity extends ThrowableItemProjectile {
    public ThrownDipEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public ThrownDipEntity(Level pLevel, LivingEntity pShooter) {
        super(ModEntityTypes.THROWNDIP.get(), pShooter, pLevel);
    }

    public ThrownDipEntity(Level pLevel, double pX, double pY, double pZ) {
        super(ModEntityTypes.THROWNDIP.get(), pX, pY, pZ, pLevel);
    }

    /**
     * Handles an entity event received from a {@link net.minecraft.network.protocol.game.ClientboundEntityEventPacket}.
     */
    public void handleEntityEvent(byte pId) {
        if (pId == 3) {
            double d0 = 0.08D;

            for (int i = 0; i < 8; ++i) {
                this.level.addParticle(new ItemParticleOption(ParticleTypes.ITEM, this.getItem()), this.getX(), this.getY(), this.getZ(), ((double) this.random.nextFloat() - 0.5D) * 0.08D, ((double) this.random.nextFloat() - 0.5D) * 0.08D, ((double) this.random.nextFloat() - 0.5D) * 0.08D);
            }
        }

    }

    /**
     * Called when the arrow hits an entity
     */
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        pResult.getEntity().hurt(DamageSource.thrown(this, this.getOwner()), 0.0F);
    }

    /**
     * Called when this EntityFireball hits a block or entity.
     */
    protected void onHit(HitResult pResult) {
        super.onHit(pResult);
        if (!this.level.isClientSide) {

            DipEntity dip = new DipEntity(ModEntityTypes.DIP.get(), level);
            if (dip != null) {
                dip.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                this.level.addFreshEntity(dip);
            }
            this.level.broadcastEntityEvent(this, (byte) 3);
            this.discard();
        }

    }

    protected Item getDefaultItem() {
        return ModItems.DIP_ITEM.get();
    }


}