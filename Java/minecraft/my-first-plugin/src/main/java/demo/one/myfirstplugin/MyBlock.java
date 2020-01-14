package demo.one.myfirstplugin;

import org.bukkit.Material;
import org.bukkit.block.data.BlockData;

public class MyBlock implements BlockData{

    public MyBlock() {
    }

    @Override
    public Material getMaterial() {
        return Material.IRON_BLOCK;
    }

    @Override
    public String getAsString() {
        return "my block";
    }

    @Override
    public String getAsString(boolean hideUnspecified) {
        return "my block";
    }

    @Override
    public BlockData merge(BlockData data) {
        return this;
    }

    @Override
    public boolean matches(BlockData data) {
        return false;
    }

    @Override
    public BlockData clone() {
        return this;
    }
}
