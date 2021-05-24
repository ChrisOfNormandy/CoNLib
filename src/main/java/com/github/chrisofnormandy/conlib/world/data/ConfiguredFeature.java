package com.github.chrisofnormandy.conlib.world.data;

import com.github.chrisofnormandy.conlib.collections.JsonBuilder;
import com.github.chrisofnormandy.conlib.collections.JsonBuilder.JsonObject;

import net.minecraft.block.Block;

public class ConfiguredFeature {
    private JsonBuilder builder = new JsonBuilder();

    public ConfiguredFeature() {
    }

    public JsonObject oreConfig(Block block, String tag, Integer size, Integer minHeight, Integer maxHeight) {
        JsonObject json = builder.createJsonObject();

        // A
        JsonObject a1 = json.addObject("config");
        json.set("type", "minecraft:decorated");

        // B
        JsonObject b1 = a1.addObject("feature");
        JsonObject b2 = a1.addObject("decorator");
        JsonObject count = b2.addObject("config");
        count.set("count", 20);
        b2.set("type", "minecraft:count");

        // C
        JsonObject c1 = b1.addObject("config");
        b1.set("type", "minecraft:decorated");

        // D
        JsonObject d1 = c1.addObject("feature");
        JsonObject d2 = c1.addObject("decorator");
        d2.addObject("config");
        d2.set("type", "minecraft:square");

        // E
        JsonObject e1 = d1.addObject("config");
        d1.set("type", "minecraft:decorated");

        // F
        JsonObject f1 = e1.addObject("feature");
        JsonObject f2 = e1.addObject("decorator");
        JsonObject heights = f2.addObject("config");
        heights.set("bottom_offset", minHeight);
        heights.set("top_offset", 0);
        heights.set("maximum", maxHeight);
        f2.set("type", "minecraft:range");

        // G
        JsonObject g1 = f1.addObject("config");
        f1.set("type", "minecraft:ore");

        // H
        JsonObject target = g1.addObject("target");
        target.set("tag", tag);
        target.set("predicate_type", "minecraft:tag_match");
        JsonObject state = g1.addObject("state");
        state.set("Name", block.getRegistryName().toString());
        g1.set("size", size);

        return json;
    }
}
