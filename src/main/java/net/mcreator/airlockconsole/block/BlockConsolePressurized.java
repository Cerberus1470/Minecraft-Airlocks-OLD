
package net.mcreator.airlockconsole.block;

import net.mcreator.airlockconsole.ElementsAirlockConsoleMod;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@ElementsAirlockConsoleMod.ModElement.Tag
public class BlockConsolePressurized extends ElementsAirlockConsoleMod.ModElement {
	@GameRegistry.ObjectHolder("airlock_console:console_pressurized")
	public static final PropertyBool PRESSURIZED = PropertyBool.create("pressurized");
	public static final Block block = null;
	public BlockConsolePressurized(ElementsAirlockConsoleMod instance) {
		super(instance, 8);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("console_pressurized"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("airlock_console:console_pressurized", "pressurized"));
	}
	public static class BlockCustom extends Block {
		public BlockCustom() {
			super(Material.ROCK);
			setUnlocalizedName("console_pressurized");
			setSoundType(SoundType.STONE);
			setHardness(1F);
			setResistance(10F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(CreativeTabs.REDSTONE);
			setDefaultState(getDefaultState().withProperty(PRESSURIZED, false));
		}

		@Override
		protected BlockStateContainer createBlockState() {
			return new BlockStateContainer(this, PRESSURIZED);
		}

		@Override
		public int getMetaFromState(IBlockState state) {

			return super.getMetaFromState(state);
		}

		@Override
		public IBlockState getStateFromMeta(int meta) {
			return super.getStateFromMeta(meta);
		}

		@Override
		public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer entity, EnumHand hand, EnumFacing direction,
				float hitX, float hitY, float hitZ) {
			super.onBlockActivated(world, pos, state, entity, hand, direction, hitX, hitY, hitZ);
//			world.setBlock(pos, state.cycle(PRESSURIZED), 3);
//			if (world.getBlockState(pos).get(PRESSURIZED)) {
//				world.setBlockState(pos, state.with(PRESSURIZED, true));
//			} else {
//				world.setBlockState(pos, state.with(PRESSURIZED, false));
//			int x = pos.getX();
//			int y = pos.getY();
//			int z = pos.getZ();
//			{
//				Map<String, Object> $_dependencies = new HashMap<>();
//				$_dependencies.put("x", x);
//				$_dependencies.put("y", y);
//				$_dependencies.put("z", z);
//				$_dependencies.put("world", world);
//				ProcedureConsoleChange.executeProcedure($_dependencies);
//			}
			return true;
		}
	}
}
