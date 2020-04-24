package com.example.examplemod.items;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class Foods {
    private static int duration = 300;
    private static int hunger = 4;
    private static float probability = 1f;

    //Pizza
    public static final Food RAW_PLAIN_PIZZA = new Food.Builder().hunger(hunger).saturation(0.3F).build();
    public static final Food PLAIN_PIZZA = new Food.Builder().hunger(hunger).saturation(0.3F).build();

    public static final Food BEEF_PIZZA = new Food.Builder().hunger(hunger)
            .effect(new EffectInstance(Effects.STRENGTH, duration, 1), probability).saturation(0.3F).meat().build();

    public static final Food PORKCHOP_PIZZA = new Food.Builder().hunger(hunger)
            .effect(new EffectInstance(Effects.HEALTH_BOOST, duration, 1), probability).saturation(0.3F).meat().build();

    public static final Food MUTTON_PIZZA = new Food.Builder().hunger(hunger)
            .effect(new EffectInstance(Effects.INSTANT_HEALTH, duration, 1), probability).saturation(0.3F).meat().build();

    public static final Food MEAT_GALORE_PIZZA = new Food.Builder().hunger(hunger)
            .effect(new EffectInstance(Effects.HEALTH_BOOST, duration, 1), probability)
            .effect(new EffectInstance(Effects.INSTANT_HEALTH, duration, 1), probability)
            .effect(new EffectInstance(Effects.JUMP_BOOST, duration, 1), probability)
            .effect(new EffectInstance(Effects.SLOW_FALLING, duration, 1), probability)
            .effect(new EffectInstance(Effects.REGENERATION, duration, 1), probability)
            .saturation(0.3F).meat().build();

    public static final Food FISH_PIZZA = new Food.Builder().hunger(hunger)
            .effect(new EffectInstance(Effects.DOLPHINS_GRACE, duration, 1), probability).saturation(0.3F)
            .effect(new EffectInstance(Effects.WATER_BREATHING, duration, 1), probability).meat().build();

    public static final Food CHICKEN_PIZZA = new Food.Builder().hunger(hunger)
            .effect(new EffectInstance(Effects.SLOW_FALLING, duration, 1), probability).saturation(0.3F).meat().build();

    public static final Food RABBIT_PIZZA = new Food.Builder().hunger(hunger)
            .effect(new EffectInstance(Effects.JUMP_BOOST, duration, 1), probability).saturation(0.3F).meat().build();

    public static final Food CURRY_PIZZA = new Food.Builder().hunger(hunger)
            .effect(new EffectInstance(Effects.FIRE_RESISTANCE, duration, 1), probability).saturation(0.3F).meat().build();

    public static final Food VEGGIE_PIZZA = new Food.Builder().hunger(hunger)
            .effect(new EffectInstance(Effects.RESISTANCE, duration, 1), probability).saturation(0.3F).meat().build();

    public static final Food COD_PIZZA = new Food.Builder().hunger(hunger)
            .effect(new EffectInstance(Effects.DOLPHINS_GRACE, duration, 1), probability).saturation(0.3F).meat().build();

    public static final Food SALMON_PIZZA = (new Food.Builder()).hunger(hunger)
            .effect(new EffectInstance(Effects.WATER_BREATHING, duration, 1), probability).saturation(0.3F).meat().build();

    public static final Food CARROT_PIZZA = new Food.Builder().hunger(hunger)
            .effect(new EffectInstance(Effects.NIGHT_VISION, duration, 1), probability).saturation(0.3F).build();


}

