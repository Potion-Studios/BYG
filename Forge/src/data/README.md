This sourceset holds datagen for BYG.
# Files generated:
- Assets, recipes, loot tables and tags for wood types from BYGWoodTypes. See `Common/src/main/resources/byg/textures/block/aspen`, which contains the textures needed for generating wood textures;
- The `minecraft:mineable/shovel` tag, which contains all BYG blocks that have one of the following materials:
  - DIRT
  - GRASS
  - SAND
  - CLAY
- The `minecraft:slabs`, `minecraft:buttons`, `minecraft:stairs`, `byg:mushrooms`, `minecraft:campfire`, `minecraft:wart_blocks` and `minecraft:wart_blocks` tags for both blocks and items, generated using an `block instanceof StairBlock` and `blockItem.getBlock() instanceof StairBlock` respectively;
- The `minecraft:leaves` tag containing all BYG blocks with the material `LEAVES`;
- The `minecraft:sand` tag containing all BYG blocks with the material `SAND`;
- The `byg:scaffolding`  tag containing all BYG blocks which are an instance of `BYGScaffoldingBlock`
- Biome tags based on `BYGBiomeTypes`.

(Note: The above list may not contain all files generated, see the sources for the "entire" list.)