package net.mcreator.airlockconsole.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;

import net.mcreator.airlockconsole.block.BlockConsoleDepressurized;
import net.mcreator.airlockconsole.block.BlockConsolePressurized;
import net.mcreator.airlockconsole.ElementsAirlockConsoleMod;

import java.util.Map;

@ElementsAirlockConsoleMod.ModElement.Tag
public class ProcedureConsoleChange extends ElementsAirlockConsoleMod.ModElement {
	public ProcedureConsoleChange(ElementsAirlockConsoleMod instance) {
		super(instance, 7);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure ConsoleChange!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure ConsoleChange!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure ConsoleChange!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure ConsoleChange!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		{
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			IBlockState _bs = BlockConsoleDepressurized.block.getDefaultState();
			IBlockState _bso = world.getBlockState(_bp);
			System.out.println("HELLOOOOOOOOOOOO");
			System.out.println(""+_bso);
			if ((""+_bso).contains("depressurize")) {
				System.out.println("Depressurize!");
				_bs = BlockConsolePressurized.block.getDefaultState();
				System.out.println("HELLOOOOO"+_bso);
			}
			else if ((""+_bso).contains("pressurize")) {
				System.out.println("Pressurize!");
			}
			for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getProperties().entrySet()) {
				IProperty _property = entry.getKey();
				if (_bs.getPropertyKeys().contains(_property))
					_bs = _bs.withProperty(_property, (Comparable) entry.getValue());
			}
			world.setBlockState(_bp, _bs, 3);
		}
	}
}
