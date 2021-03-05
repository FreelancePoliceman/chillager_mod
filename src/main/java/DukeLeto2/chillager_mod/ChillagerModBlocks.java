package DukeLeto2.chillager_mod;

import DukeLeto2.chillager_mod.blocks.FallingIce;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static DukeLeto2.chillager_mod.ChillagerMod.modid;

public class ChillagerModBlocks {
  //  public static Block BUTTERCUP_BLOCK = new FlowerBlock(StatusEffects.ABSORPTION, 7, AbstractBlock.Settings.of(Material.PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS));
    public static Block FALLING_ICE = new FallingIce(FabricBlockSettings.of(Material.ICE).hardness(0.6f).sounds(BlockSoundGroup.GLASS));
    public static void register() {
   //     Registry.register(Registry.BLOCK, new Identifier(modid, "buttercup"), BUTTERCUP_BLOCK);
    //    Registry.register(Registry.ITEM, new Identifier(modid, "buttercup"), new BlockItem(BUTTERCUP_BLOCK, new Item.Settings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.BLOCK, new Identifier(modid, "falling_ice"), FALLING_ICE);
    }
}
