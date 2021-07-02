package com.lapisliozuli.bunnyloversmc.items;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.FlowerFeature;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

public class BunnyBerries extends Item {
    public BunnyBerries(Item.Settings settings) {
        super(settings);
    }

//    // Able to grow Grass and Flowers, but without particles or item animation. It also crashes sometimes.
//    public ActionResult useOnBlock(ItemUsageContext context) {
////        BlockPos blockPos = pos.up();
//        World world = context.getWorld();
//        BlockPos blockPos = context.getBlockPos();
//        Block selfBlock = world.getBlockState(blockPos).getBlock();
////        Random random;
//        Random random = world.getRandom();
//        BlockState blockState = Blocks.GRASS.getDefaultState();
//
//        // What on earth is this label48?
//        label48:
//        for(int i = 0; i < 128; ++i) {
//            BlockPos blockPos2 = blockPos;
//
//            for(int j = 0; j < i / 16; ++j) {
//                blockPos2 = blockPos2.add(random.nextInt(3) - 1, (random.nextInt(3) - 1) * random.nextInt(3) / 2, random.nextInt(3) - 1);
//                if (!world.getBlockState(blockPos2.down()).isOf(selfBlock) || world.getBlockState(blockPos2).isFullCube(world, blockPos2)) {
//                    continue label48;
//                }
//            }
//
//            BlockState blockState2 = world.getBlockState(blockPos2);
//            if (blockState2.isOf(blockState.getBlock()) && random.nextInt(10) == 0) {
//                ((Fertilizable)blockState.getBlock()).grow((ServerWorld) world, random, blockPos2, blockState2);
//                world.syncWorldEvent(2005, blockPos2, 0);
//            }
//
//            if (blockState2.isAir()) {
//                BlockState blockState4;
//                if (random.nextInt(8) == 0) {
//                    List<ConfiguredFeature<?, ?>> list = world.getBiome(blockPos2).getGenerationSettings().getFlowerFeatures();
//                    if (list.isEmpty()) {
//                        continue;
//                    }
//
//                    ConfiguredFeature<?, ?> configuredFeature = (ConfiguredFeature)list.get(0);
//                    FlowerFeature flowerFeature = (FlowerFeature)configuredFeature.feature;
//                    blockState4 = flowerFeature.getFlowerState(random, blockPos2, configuredFeature.getConfig());
//                    world.syncWorldEvent(2005, blockPos2, 0);
//                } else {
//                    blockState4 = blockState;
//                }
//
//                if (blockState4.canPlaceAt(world, blockPos2)) {
//                    world.setBlockState(blockPos2, blockState4, 3);
//                }
//            }
//        }
//        return ActionResult.PASS;
//    }


//    public ActionResult useOnBlock(ItemUsageContext context) {
//        World world = context.getWorld();
//        BlockPos blockPos = context.getBlockPos();
//        BlockPos blockPos2 = blockPos.offset(context.getSide());
//        if (useOnFertilizable(context.getStack(), world, blockPos)) {
//            return ActionResult.FAIL;
//        } else {
//            return ActionResult.FAIL;
//        }
//    }

    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockPos blockPos2 = blockPos.offset(context.getSide());
        if (useOnFertilizable(context.getStack(), world, blockPos)) {
            if (!world.isClient) {
                // Spawns particles.
                world.syncWorldEvent(2005, blockPos, 0);
            }
//            // This affect item usage animation.
            return ActionResult.success(world.isClient);
        } else {
            BlockState blockState = world.getBlockState(blockPos);
            boolean bl = blockState.isSideSolidFullSquare(world, blockPos, context.getSide());
            if (bl && useOnGround(context.getStack(), world, blockPos2, context.getSide())) {
                if (!world.isClient) {
                    world.syncWorldEvent(2005, blockPos2, 0);
                }
                return ActionResult.success(world.isClient);
            } else {
                return ActionResult.PASS;
            }
        }
    }

    public static boolean useOnFertilizable(ItemStack stack, World world, BlockPos pos) {
        BlockState blockState = world.getBlockState(pos);
        if (blockState.getBlock() instanceof Fertilizable) {
            Fertilizable fertilizable = (Fertilizable)blockState.getBlock();
            if (fertilizable.isFertilizable(world, pos, blockState, world.isClient)) {
                if (world instanceof ServerWorld) {
                    if (fertilizable.canGrow(world, world.random, pos, blockState)) {
                        fertilizable.grow((ServerWorld)world, world.random, pos, blockState);
                    }

                    stack.decrement(1);
                }

                return true;
            }
        }

        return false;
    }

    public static boolean useOnGround(ItemStack stack, World world, BlockPos blockPos, @Nullable Direction facing) {
        if (world.getBlockState(blockPos).isOf(Blocks.WATER) && world.getFluidState(blockPos).getLevel() == 8) {
            if (!(world instanceof ServerWorld)) {
                return true;
            } else {
                label80:
                for(int i = 0; i < 128; ++i) {
                    BlockPos blockPos2 = blockPos;
                    BlockState blockState = Blocks.SEAGRASS.getDefaultState();

                    for(int j = 0; j < i / 16; ++j) {
                        blockPos2 = blockPos2.add(RANDOM.nextInt(3) - 1, (RANDOM.nextInt(3) - 1) * RANDOM.nextInt(3) / 2, RANDOM.nextInt(3) - 1);
                        if (world.getBlockState(blockPos2).isFullCube(world, blockPos2)) {
                            continue label80;
                        }
                    }

                    Optional<RegistryKey<Biome>> optional = world.getBiomeKey(blockPos2);
                    if (Objects.equals(optional, Optional.of(BiomeKeys.WARM_OCEAN)) || Objects.equals(optional, Optional.of(BiomeKeys.DEEP_WARM_OCEAN))) {
                        if (i == 0 && facing != null && facing.getAxis().isHorizontal()) {
                            blockState = (BlockState)((Block) BlockTags.WALL_CORALS.getRandom(world.random)).getDefaultState().with(DeadCoralWallFanBlock.FACING, facing);
                        } else if (RANDOM.nextInt(4) == 0) {
                            blockState = ((Block)BlockTags.UNDERWATER_BONEMEALS.getRandom(RANDOM)).getDefaultState();
                        }
                    }

                    if (blockState.getBlock().isIn(BlockTags.WALL_CORALS)) {
                        for(int k = 0; !blockState.canPlaceAt(world, blockPos2) && k < 4; ++k) {
                            blockState = (BlockState)blockState.with(DeadCoralWallFanBlock.FACING, Direction.Type.HORIZONTAL.random(RANDOM));
                        }
                    }

                    if (blockState.canPlaceAt(world, blockPos2)) {
                        BlockState blockState2 = world.getBlockState(blockPos2);
                        if (blockState2.isOf(Blocks.WATER) && world.getFluidState(blockPos2).getLevel() == 8) {
                            world.setBlockState(blockPos2, blockState, 3);
                        } else if (blockState2.isOf(Blocks.SEAGRASS) && RANDOM.nextInt(10) == 0) {
                            ((Fertilizable)Blocks.SEAGRASS).grow((ServerWorld)world, RANDOM, blockPos2, blockState2);
                        }
                    }
                }

                stack.decrement(1);
                return true;
            }
        } else {
            return false;
        }
    }

}
