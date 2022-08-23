## 2.0.0.8
### Thank you to everyone for the PRs w/ fixes!
* Put wailing nylium in the shovel tag.
* Fire tree grow event on forge.
* Fix button rendering.
* Fix potted blocks.
* Stop nether plants from burning.
* Fix wailing nylium spreading to netherrack.
* Add vietnamese translation.
* Bump pack version.
* Don't use unique paths for data files.
* Tweaks to recipes and tags.
  * Added a blasting recipe for budding ametrine ore.
  * Added some missing tags to ores, fixes compatibility with Tinker's Construct.
  * Added smelting and blasting recipes to nether gold and quartz ores.
  * Adjusted cryptic end rod recipe to be crafted from an end rod and redstone dust.
  * Adjusted lantern recipes to match the vanilla lantern recipes.
  * Removed some blocks from the netherrack Forge tag, as Forge does not include similar vanilla blocks.
  * Remove Forge tag references to lignite.
  * Remove recipe to smelt magmatic stone into magma blocks as this can cause duplication issues with any mods that interact with magma.
  * Remove second travertine crafting recipe and adjust its recipe to require calcite and cobblestone (rough equivalents of its real-world composition).
  * Add a recipe to create purpur stone from popped chorus fruits and cobblestone.
  * Make subzero crystal blocks drop some of their shards, similar to glowstone.
  * Make foragers table drop itself when broken.

## 2.0.0.7
* Update to 1.19.2.

## 2.0.0.6
* Remove signs.
* Fix BYG on Forge versions above `41.0.64`.

# 2.0.0.5
* Fix `/worldgenexport` command, should also resolve an incompatibility with `Memory Leak Fix` [#816](https://github.com/AOCAWOL/BYG/issues/816).

# 2.0.0.4
* Fix Eroded Badlands extensions in Shattered Glacier + Sierra Badland biomes.

# 2.0.0.3
* Fix stair recipes [#808](https://github.com/AOCAWOL/BYG/issues/808)
* Tag stuff

# 2.0.0.2
* Fire events dependent of registry objects(ie blocks & villager professions) after fabric mod initialization/registry freezing.
* Fix crashing signs.

# 2.0.0.1
* Tag related changes & additions.

# 2.0.0.0 - BREAKING CHANGES
* Port to 1.19..
* Add chest boats.
* Breaking changes:
    * Rename all mangrove blocks/items/world gen from `mangrove` -> `white_mangrove`.
    * Remove all mud blocks.
    * Remove all lignite blocks.
    * Remove Plant Stem & Petal blocks.
    * Remove Windswept Dunes & Windswept Beach.
    * Remove Holly Berries
    * Fix a spelling error related to mahogany boats, `mahagony` -> `mahagany`.
* Misc Changes worth mentioning:
  * Refactor world gen features to use suppliers.
  * Add data gen for resources & compress texture size [#758 by Matyrobbrt](https://github.com/AOCAWOL/BYG/pull/783)


# End 1.18, start 1.19
***

# 1.4
* Release
* Fix ocean biome selector from spawning lush stacks everywhere, `Lush Stacks` & `Dead Sea` should be much rarer. Changes apply after config update/reset.
* Fix some saplings not being growable & not displaying their growing pattern tooltip on the item.
* Add Yellow & Blue Nether brick slabs/stairs.
* Prevent BYG from getting wrongfully blamed for game crashes/errors occurring during other events.
* Add signs.

# 1.4-RC-24
* Add mob spawns, color settings, and biome tags (required advanced tool tips to be enabled (F3+H) to show) to biome about pages.

# 1.4-RC-23
* Add config loading failure screen that should appear in place of crashing(doesn't work for all configs, but should reduce game exits).
* Fix a bug where a biome that doesn't generate would crash in the biomepedia dimensions list, add a component that tells the user that the biome in question doesn't spawn anywhere instead.
* Add translation components for numerous components that were hardcoded to english.
* Much better and informative error in relation to biomes occurring in both biome selectors and biome swapper for `TerraBlenderRegion`/`OverworldRegion`.

# 1.4-RC-22
* Fix feature order cycle crash.
* Biome list in w/ search bar in biomepedia.
* Biomepedia tweaks.
* Bug fixes.
* Fix forager XP progression.
* Reworked `Sythian Scaffolding` to be more parity with vanilla Scaffolding (can now be used with each other!!).
* Add `translate` button that links to our [Crowdin](https://crowdin.com/project/oh-the-biomes-youll-go) in the biomepedia!
* Fixed travertine crafting recipe conflicting with Red Rock crafting recipe.
* Fixed Weeping Mire biome color.
* Tweaked Lament Sprouts texture.
* Revamped some block textures.
* Add sign block textures.
* Lower Required Terrablender version to `1.1.0.99` due to client packet issue that occurs in `1.1.0.101`.
* Fix Registry Codecs(ie: non-existing villager professions defaulting to villager profession of `none`), should fix the inputting of non-existent villager professions and should now properly error instead. Fixes [#727](https://github.com/AOCAWOL/BYG/issues/727).

# 1.4-RC-21
* Remove Travertine from world gen.

# 1.4-RC-20
* Add Travertine + Soapstone world gen.

# 1.4-RC-19 
* Fix `StackOverflowError` in relation to growing patterns config.

# 1.4-RC-18
* Much more informative exceptions in relation to configs.
* Saplings Pattern Config is now referred to as Growing Patterns.
* Add Comments to Growing Patterns config.
* Don't crash if a dimension is not present when attempting to append surface rules or replace biome sources.

# 1.4-RC-17
* Add curseforge/modrinth upload tasks to build.gradle, no gameplay changes.