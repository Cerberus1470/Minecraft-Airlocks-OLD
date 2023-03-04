package net.mcreator.airlockconsole.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;

import net.mcreator.airlockconsole.block.BlockConsolePressurized;
import net.mcreator.airlockconsole.ElementsAirlockConsoleMod;

import java.util.Map;

@ElementsAirlockConsoleMod.ModElement.Tag
public class ProcedureConsolePressurize extends ElementsAirlockConsoleMod.ModElement {
	public ProcedureConsolePressurize(ElementsAirlockConsoleMod instance) {
		super(instance, 5);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure ConsolePressurize!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure ConsolePressurize!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure ConsolePressurize!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure ConsolePressurize!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		{
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			IBlockState _bs = BlockConsolePressurized.block.getDefaultState();
			IBlockState _bso = world.getBlockState(_bp);
			for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getProperties().entrySet()) {
				IProperty _property = entry.getKey();
				if (_bs.getPropertyKeys().contains(_property))
					_bs = _bs.withProperty(_property, (Comparable) entry.getValue());
			}
			TileEntity _te = world.getTileEntity(_bp);
			NBTTagCompound _bnbt = null;
			if (_te != null) {
				_bnbt = _te.writeToNBT(new NBTTagCompound());
				_te.invalidate();
			}
			world.setBlockState(_bp, _bs, 3);
			if (_bnbt != null) {
				_te = world.getTileEntity(_bp);
				if (_te != null) {
					try {
						_te.readFromNBT(_bnbt);
					} catch (Exception ignored) {
					}
				}
			}
		}
	}
}
