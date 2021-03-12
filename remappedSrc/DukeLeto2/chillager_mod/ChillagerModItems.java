package DukeLeto2.chillager_mod;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SnowballItem;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static DukeLeto2.chillager_mod.ChillagerMod.modid;

public class ChillagerModItems {
    /* Milk buckets are in ItemGroup.MISC, for some reason. Should I change this to match? */
 ;//   public static final Item BUTTERMILK_BUCKET = new ButtermilkBucketItem(new FabricItemSettings().group(ItemGroup.FOOD).maxCount(1).recipeRemainder(net.minecraft.item.Items.BUCKET).food(FoodComponentsEveryoneWon.BUTTERMILK_BUCKET));
    //  public static final Item MOOBLOOM_SPAWN_EGG = new SpawnEggItem(ChillagerModEntities.MOOBLOOM, 0,0, new FabricItemSettings().group(ItemGroup.MISC));
    public static final Item CHILLAGER_SPAWN_EGG = new SpawnEggItem(ChillagerModEntities.CHILLAGER,14802,15594235,new FabricItemSettings().group(ItemGroup.MISC));
    //public static final Item ENCHANTED_SNOWBALL = new SnowballItem()
    public static final FreezingSnowballItem FREEZING_SNOWBALL = new FreezingSnowballItem(new FabricItemSettings().maxCount(16).group(ItemGroup.MISC));
    public static void register () {
 //       Registry.register(Registry.ITEM, new Identifier(modid, "buttermilk_bucket"), BUTTERMILK_BUCKET);
  //      Registry.register(Registry.ITEM, new Identifier(modid, "moobloom_spawn_egg"), MOOBLOOM_SPAWN_EGG);
        Registry.register(Registry.ITEM, new Identifier(modid, "chillager_spawn_egg"), CHILLAGER_SPAWN_EGG);
        Registry.register(Registry.ITEM, new Identifier(modid, "freezing_snowball"), FREEZING_SNOWBALL);
    }
}
