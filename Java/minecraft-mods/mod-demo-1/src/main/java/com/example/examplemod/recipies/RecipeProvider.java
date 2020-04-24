package com.example.examplemod.recipies;

import com.example.examplemod.items.Items;
import net.minecraft.data.*;

import java.io.IOException;
import java.util.function.Consumer;

public class RecipeProvider  implements IDataProvider {

    protected final DataGenerator generator;

    public RecipeProvider(DataGenerator generatorIn) {
        this.generator = generatorIn;
    }


    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        ShapedRecipeBuilder.shapedRecipe(Items.RAW_PLAIN_PIZZA, 3).key('#', net.minecraft.item.Items.WHEAT).patternLine("##").build(consumer);
    }


    @Override
    public void act(DirectoryCache cache) throws IOException {

    }

    @Override
    public String getName() {
        return "My RecipeProvider";
    }


}
