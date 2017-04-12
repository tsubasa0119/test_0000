package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by tsubasa on 2016/08/18.
 */
public class virus_block extends Block {
    public virus_block() {
        super(Material.cloth);
        setCreativeTab(CreativeTabs.tabMaterials);

        setBlockName(ExampleMod.MODID + "virus");
        setBlockTextureName(ExampleMod.MODID + ":" + "virus");
        setHardness(0.001f);
        setResistance(0.0000001f);
        //slipperiness = 100.0f;
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random random) {
        if (world.getBlockLightValue(x, y + 1, z) >= 13) {
            world.setBlock(x, y, z, ExampleMod.αbedrock);
            return;
        } else if (world.getBlockLightValue(x, y + 1, z) >= 7) {
            world.scheduleBlockUpdateWithPriority(x, y, z, this, 1, 100);
            return;
        }

        if (world.getBlock(x, y + 1, z) != Blocks.air) {
            world.setBlock(x, y + 1, z, ExampleMod.VIRUSBLOCK);
        }
        if (world.getBlock(x, y - 1, z) != Blocks.air) {
            world.setBlock(x, y - 1, z, ExampleMod.VIRUSBLOCK);
        }
        if (world.getBlock(x + 1, y, z) != Blocks.air) {
            world.setBlock(x + 1, y, z, ExampleMod.VIRUSBLOCK);
        }
        if (world.getBlock(x - 1, y, z) != Blocks.air) {
            world.setBlock(x - 1, y, z, ExampleMod.VIRUSBLOCK);
        }
        if (world.getBlock(x, y, z + 1) != Blocks.air) {
            world.setBlock(x, y, z + 1, ExampleMod.VIRUSBLOCK);
        }
        if (world.getBlock(x, y, z - 1) != Blocks.air) {
            world.setBlock(x, y, z - 1, ExampleMod.VIRUSBLOCK);
        }
        world.scheduleBlockUpdateWithPriority(x, y, z, this, 1, 100);
    }

    public void onBlockAdded(World world, int x, int y, int z) {
        world.scheduleBlockUpdateWithPriority(x, y, z, this, 1, 100);
    }

    public void onEntityCollidedWithBlock(World p_149670_1_, int p_149670_2_, int p_149670_3_, int p_149670_4_, Entity p_149670_5_) {
        if (p_149670_5_ instanceof EntityLivingBase) {
            EntityLivingBase entity = (EntityLivingBase) p_149670_5_;
            entity.attackEntityFrom(DamageSource.cactus, 2.0F);
            entity.addPotionEffect(new PotionEffect(Potion.confusion.id, 2, 1));
            entity.addPotionEffect(new PotionEffect(Potion.blindness.id, 2, 1));
            entity.addPotionEffect(new PotionEffect(Potion.hunger.id, 2, 199));
            entity.addPotionEffect(new PotionEffect(Potion.weakness.id, 2, 199));
            entity.addPotionEffect(new PotionEffect(Potion.poison.id, 2, 199));
            entity.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 2, 199));
        }

    }


    @Override

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
        return AxisAlignedBB.getBoundingBox(p_149668_2_ - 0.1, p_149668_3_ - 0.1, p_149668_4_ - 0.1, p_149668_2_ - 0.1, p_149668_3_ - 0.1, p_149668_4_ - 0.1);

    }

}
