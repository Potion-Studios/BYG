## 1.5.0
* Fix Broken Sandstone Recipes. Fixes #1204
* Fix Therium Lamp having same recipe of Therium Lantern. Fixes #1237
* Fix Broken Cut Sandstone Recipes. Fixes #1279
* Update Included Dependencies.
* Require Forge 40.2.0 or higher.
* Require TerraBlender 1.2.0.0 or higher.
* Make Prairie Grass grow when bone mealing grass blocks in the Prairie Biomes. Closes #1044
* Make Wood Fence Gates Flammable
* Make Ender and Embur Lily's Placeable
* Fixed a crash related to HypogealImperium
* Make saplings of all kinds usable in growth patterns
* Fix inventory book mixin being unable to apply
* Add Windswept Sandstone Pallet Recipes. Fixes #1278

## 1.4.7
* Update Chinese translation.
* Don't log every time biome parameter points are mapped.

## 1.4.6
* Withering Oak Logs should no longer burn.
* Water Silk can now be broken by boats.
* Yellow & Blue Nether Bricks now have correct mining time & sounds.
* Add Yellow & Blue Nether Bricks recipes.
* Orange Amaranth may now be composted.
* Fix Pendorite sword texture.

## 1.4.5
* Add Portuguese language.
* Make Embur Roots and Ether grass bonemeal action not throw errors.
* Two ether blocks don't grow large now.
* Fix flower dupe 1.18.
* Fix Nether terrablender surface rules, BOP surface rules should work now!
* Numerous Sythian Stalk Fixes.
* Some Sapling growth fixes.
* Fix Mahogany Boat Texture.
* Use Fabric's `StrippableBlockRegistry`. This should add compat with quilt.
* Add Forager's table to axe mineable tag.
* Cardinal Tundra is now actually snowy.
* Fix Mangrove Sapling's odd growing pattern.

## 1.4.4
* Strip trailing white space from configs when parsing.

# 1.4.3
* Fix errors when bonemealing ether root/ grass.
* LambdaBetterGrass support.
* Stop nether plants from burning.
* Fire forge tree growing event.
* Fix flower pots.
* Put wailing nylium in the shovel tag.
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

# 1.4.2
* Remove signs.

# 1.4.1
* Fire events dependent of registry objects(ie blocks & villager professions)
* Try and fix missing BYG sign models.

# 1.4
* Release
* Fix ocean biome selector from spawning lush stacks everywhere, `Lush Stacks` & `Dead Sea` should be much rarer. Changes apply after config update/reset.
* Fix some saplings not being growable & not displaying their growing pattern tooltip on the item.
* Add Yellow & Blue Nether brick slabs/stairs
* Prevent BYG from getting wrongfully blamed for game crashes/errors occurring during other events.
* Add signs

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