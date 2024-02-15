# 4.0.1.1
* Add Soul Fire'd Support
* Remove Duplicate FruitBlock Code
* Prevent Fruits from generating under wrong leaves
* (Fabric) Remove use of LegacyMixinAP and use Tiny Remapper to remap Mixin classes in place

# 4.0.1.0
* Fix Broken Sandstone Recipes. Fixes #1204
* Fix Wall Sign Drops. Fixes #1240
* Fix Duplicate planks in planks block tag
* Fix a client Crash. Fixes #1224
* Add Hanging signs (Must have 1.20 Vanilla Data pack enabled)
* Fix Therium Lamp having same recipe of Therium Lantern. Fixes #1237
* Fix Hypogeal Imperium causing crash. Fixes #1231
* Fix EnderLily not being placeable on Water. Fixes #1258
* Make Wood Fence Gates Flammable
* Make NonFlammable woodtypes unable to be used as fuel. Fixes #1249
* Make Palo Verde Logs able to be used as fuel. Fixes #1250
* Make Prairie Grass grow when bone mealing grass blocks in the Prairie Biomes. Closes #1044
* Made non-BYG saplings usable in growth patterns
* Fix Broken Cut Sandstone Recipes. Fixes #1279
* New Wood Textures (Baobab, Cika, Cypress, Ether, Redwood, White Mangrove, Willow)
* Golden Apples from Green Apples Recipe
* Possible Ether grass crash fix. Fixes #1291

# 4.0.0.2
* Fix broken NBT files. Fixes #1206 and #1207
* Fix broken audio files.

# 4.0.0.1
* Fix Overworld Biome Configs.

# 4.0.0.0
* Update to 1.19.4.

# End 1.19.3, start 1.19.4
***

# 3.0.0.0
* Update to 1.19.3.

# End 1.19, start 1.19.3
***
# 2.0.1.5
* Fix Broken Sandstone Recipes
* Fix Wall Sign Drops. Fixes #1240

# 2.0.1.4
* Fix broken NBT files. Fixes #1206 and #1207
* Fix broken audio files.

# 2.0.1.3
* Fix Overworld Biome Configs.

# 2.0.1.2
## Biome Changes
### End Biomes
* Make Chorus fruits and end gateways generate last in BYG end biomes.
* Make Chorus fruits and End Gateways the final features to gen in BYG end biomes.

### Overworld Biomes
* Gave Red Oak Forest the Aspen Forest Surface Rules.
* Fixed Mob Spawns for various overworld biomes.
* Added more vanilla woodtypes to BYG biomes.
* New Maple, Cherry, & Witch Hazel particles.
  * Particles now fall from leaves as opposed to being an ambient particle in the biome.
* Bush Tree for forest biomes.
* Redid Clover & Flower Patches
* Increased & Decreased Clovers & Flower patches across various biomes.
* Changed Cherry Blossom Forests to be a bit more common
* Add oak bushes to various Overworld biomes
* Re-added firecracker bushes (oops!)
* Added sparse birch trees to the Cherry Blossom Forest
* Increased cherry foliage blocks in the Cherry Blossom Forest.
* Tulips & sunflowers now properly spawn in the Coconino Meadows.

## Misc Changes
* Finished "Cs" in the Biomepedia Biome Section for Descs. -Started "Ds" in the Biomepedia Biome Section for Descs.
* Re-add signs.
* Remove unused libraries and classes.
* Update zh_cn.json (#1171).
* Add Ukrainian translation from #1146.
* Update and require CorgiLib to `1.0.34`.
* Fabric Loom 1.1-SNAPSHOT, other Gradle tweaks/updates  (#1187)
* Add modded shears support, Fixes #1043 (#1196)
* Move Overworld surface rules registration after registries freeze.
* Add `/byg config validate` & `/byg config reset` commands.
* Move `/byg update_configs` -> `/byg config update`
* Move `/byg reload` -> `/byg config reload`

## Bug Fixes
* Fix typo in BYGOverworldTreeFeatures.java (#1130).
* Reduce performance footprint of Pumpkin Warden AI (#1140).
* Add Geckolib3 dependency to Forge & Fabric. Fixes #1163.
* Fix typo in BYGOverworldTreeFeatures.java (#1130).
* Reduce performance footprint of Pumpkin Warden AI (#1140).
* Do not crash BYG when configs fail to load. Log the errors instead and use defaults.
* Fix WoodType registration to use our namespace and to prevent mod conflicts. Fixes #1137 on 1.19.
* Use BlockPredicate for `HangingColumnWithBase` placement. Fixes some nether plants not spawning. Fixes #1061
* Removed empty shapeless recipe for brown dye (#1170).
* Use internal references for GrowingPatterns config. Fixes outdated sapling references. Fixes #1115
* Update and require CorgiLib to `1.0.34`, use better sapling patterns for Aspen Saplings. Fixes #1174.
* Fix Sandstone Recipes. Fixes #1190
* Drop 2 prairie grass items when using shears. Fixes #1104
* Fix Mason Villager Trades. Fixes #1109
* Fix Man O War bucket spawning. Fixes #1113
* Fix reversed door blockstates, fixes #1125
* Don't give biomepedia several times, only once. Fixes #1194

# 2.0.1.1

* ## Biome Changes
  * ### Aspen Forest
    * Biome generation overhaul.
    * Add Shelf fungi on the sides of Aspen Trees
    * New Aspen Trees
    * New Aspen Leaves textures
    * Add Spruce Trees

  * ### Redwood Forest
    * Redwood forest will now rarely generate an ancient sequoia tree.
      * This is a structure internally, can be found with `/locate structure byg:ancient_sequoia`.

  * ### Bayou & Cypress Swamplands
    * Add Vines & Moss to trees.

  * ### Overworld Forests
    * Add ambience audio.

  * ### End biomes
    * Add end gateways to all end biomes.
    * Remove endermite spawns.

  * ### Biome Distribution
    * Biome distribution should be more consistent. Reset configs to see this change.

  * ### Rainbow Eucalyptus Trees
    * Add vines to all Rainbow Eucalyptus trees.

* ## Misc Changes
  * Improve Sapling Pattern tooltip.

* ## Bug fixes
  * Fix crash with Terralith due to feature cycle. (#1105)
  * Add Imbued Nightshade logs to logs tags. Should fix instances of leaves decaying in the Nightshade forest.
  * Fix man o war spawning.


# 2.0.1.0
* New Dependencies
  * CorgiLib is now required for forge & fabric. You can get it here:
    * https://www.curseforge.com/minecraft/mc-mods/corgilib
    * https://modrinth.com/mod/corgilib
  * Geckolib is now required for forge & fabric. You can get it here:
    * https://www.curseforge.com/minecraft/mc-mods/geckolib
    * https://modrinth.com/mod/geckolib

* ## Mobs
  * ### Man O War!
    * These glowing aquatic mob spawns in the Lush Stacks!
    * Comes in the following colors:
        * Rainbow
        * Blue
        * Purple
        * Magenta
    * These ambient creatures will sting you if you get too close!
    * Pick up Baby Man O' Wars with a Water Bucket
  
  * ### Pumpkin Ward!
    * Pumpkin Wards can be exclusively found in **Pumpkin Patches**.
    * Pumpkin Wards will harvest pumpkins & melons and will drop it in front of a carved pumpkin (auto pumpkin & melon farming!).
    * Pumpkin Wards will stay within a 35 block radius of a Bell or wander till they find one
    * Pumpkin Wards will sleep at Night Time (No Bed Required)
    * Pumpkin Wards can be lured with Pumpkin Pie (They do not eat it!)
    * Pumpkin Wards Cannot be bred. So take special care of your pumpkin friends!
    * Playing a music disc within  a 10 block radius will cause them to rave into a dance party!
    * When threatened, the Pumpkin Ward will drop any items it's carrying and pretend to be a pumpkin.
    * Splashing a Baby Villager with Weakness then Right-clicking them with a Carved Pumpkin will produce a Pumpkin Ward

* ## Blocks 
  * Flowering & Ripe leave blocks. Flowering leaves have a rare chance of turning into their ripe counterpart. Ripe leaves have a rare chance of spawning a fruit block. The following species have flowering/ripe leaves: 
    * Skyris
    * Orchard
    * Baobab
    * Joshua
  * Apple fruit blocks - Can be found at the nearest Orchard biome growing/hanging from ripe orchard leaves!
  * Joshua fruit blocks - Can found at the nearest Mojave Desert growing/hanging from ripe Joshua fruit leaves!
  * Green Apple fruit blocks - Can found at the nearest Skyris Vale growing/hanging from green apple skyris leaves!
  * Blue rose bush.
  * Imbued green & blue enchanted logs.
    
* ## New Points of Interests
  * **_Pumpkin Patches_** - Home to the Pumpkin ward. Found in all autumnal biomes.
  * **_Salem Village_** - A new unique village found in Weeping Witch Forests

* ## Advancements
  * **_Rose Collector_**
    * Can be achieved when collecting the following items:
      * Blue Rose Bush
      * Black Rose
      * Winter Rose
      * Cyan Rose
      * Osiria Rose
      * Rose
      * Rose Bush
      * Wither Rose

* ## Reworks
  * **_New Textures_** 
    * New Green Enchanted textures.
    * New Maple textures.
    * New Cherry leave textures.
    * New Ametrine Block & Armor textures.
    * New Therium textures.
    * New Orchard textures
    * New Joshua Leaf textures

  * **_Therium Rework_**
    * Therium Deposits can now be found once again throughout BYG End Biomes.
    * Therium now functions exactly like Amethyst.
    * Therium is now very common and deposits are very large, the goal of this is to make Therium a more viable resource for decorations & lanterns (which still moisturize lush farmland!).
    * Therium has also received texture overhauls.
    * Therium Lanterns now have an animation.
    * With this revamp, old therium blocks have been removed. This includes 'Therium Crystal' & 'Therium Block' and Therium Shard have been renamed to 'Therium Crystal Shard'.
    * Therium Buds & Clusters, etc. are mineable at Iron Tier and higher.

* ## Biome Revamps
  * Araucaria Savanna 
    * Generation Tweaks
      * Remove Firecracker Shrub
      * Add Shrubs
    
  * Atacama Desert
    * Hostile Mobs + Husk can now spawn
    * Rabbits now can now spawn
    
  * Forgotten Forest
    * Generation overhaul:
      * New Trees
      * New Vegetation.
      * New Imbued green & blue enchanted logs spawn in the trunks of the enchanted trees.
      
  * Imparius Grove
    * Generation overhaul:
      * Deltas now spawn in place of the lakes which would cause eyesore cuts in the terrain.
      * Denser Vegetation.
      * No more floating tree trunks

  * Jacaranda Forest
    * Generation Overhauls:
      * New Trees & Vegetation.
      
  * Maple Taiga
    * Maple Taiga now has proper Mob Spawning parity to that of Taigas.
    * Generation Overhauls:
      * Add sparse spruce trees.
      * New vegetation.
      * New block textures.
    
  * Mojave Desert
    * Joshua trees now provide joshua fruit.

  * Orchard
    * Orchard trees now provide apples.
    
  * Rose fields
    * Lower flower spawn rates to reduce performance impact.
    * Add Blue Rose Bushes to world gen.
    * Add a mix of blue & red spruce trees.

  * Tropical Rainforest
    * Generation Tweaks
      * Vines are far denser & Cocoa beans now spawn on trees (thanks tree decorators). Should feel much more like a jungle.
    * Temporarily remove Tropical Village spawning.
    
  * Skyris Vale
    * Generation overhaul:
      * New Trees & Vegetation.
    * Skyris trees provide green apples.
  
  * Windswept Dunes
    * Hostile Mobs + Husk can now spawn
    * Rabbits now can now spawn
    * Generation Tweaks
      * Remove windswept lake. These need redesigning.
        
  * Weeping Witch Forest
    * New POI: Salem Village can be found here.
    * Generation overhaul:
      * New Trees & Vegetation

  * Swamp Biomes
    * Spawn delta features to flood the biomes more. This also means water will appear at elevations not at sea level.
    * Should now spawn swamp huts.
    
  * All Overworld & End Biomes
    * Floating tree/fungi/mushroom trunks should no longer occur. 
      * All trunks verify they are not on a cliff prior to placing blocks.
      * All trunks now fill to the ground and (random) tick their ground block.

  * Some Overworld biomes
    * More vanilla logs can be found in many of our biomes mixed with the other vegetation.
    * Increase grass spawns.
    * Add blueberry spawns to following biomes:
      * Autumnal Taiga
      * Black Forest
      * Canadian Shield
      * Cika Woods
      * Coconino Meadows
      * Coniferous Forest
      * Dacite Ridges
      * Howling Peaks
      * Maple Taiga
      * Rose Fields
      * Weeping Witch Forest
      * Zelkova Forest
    * Misc tweaks.

* ## Biomepedia
  * New biome descriptions(not all complete yet).
  * Biomepedia text now supports chat component formatting (internal change).
    * Bold biome names & information categories
    * Fix sky color using fog color.
    * Biome colors(sky, water, water fog, grass color, foliage color) will now have their text colored based off the color of the field.
  * Item page items are now alphabetically sorted.


* ## Removed Content
  * Remove Windswept lakes until they're redesigned/improved.
  * Temporarily remove Tropical Village spawning(it still exists in the registry to not break worlds) due to a broken NBT.


* ## Technical Changes
  * Datapacks
    * Any datapacks modifying trees are broken.
    * Trees now use CorgiLib's `tree_from_nbt` feature.
      * Allows to build trees with a trunk & canopy structure NBT parts.
      * Allows the use of vanilla & modded tree decorators. These include but are not limited to:
        * Vines
        * Cocoa Beans
        * Attached To Leaves blocks such as vanilla's propagules.
      * Calculates leave distance and avoids placing leaves that are too far away.
      * Much better control over tree height.
      * The ability to place other blocks found in the trunk & canopy NBTs.
      * The ability to filter what blocks may be replaced by leaves w/ vanilla & modded BlockPredicates.
      * The ability to filter what blocks the tree feature considers ground w/ vanilla & modded BlockPredicates.
    * Removed Biomepedia item advancement gift. Switched to config option.
    * Remove numerous configured features and features from the registry.

* ## Configs
  * **It is advised to delete your config directory and let your game regenerate them fresh.**
  * Overworld Biomes - `<gamedir>/config/byg-overworld-biomes.json5`
    * Added a global biome swapper which allows you to swap a biome of your choice to another for ALL Overworld regions. This is for those of you who don't want to edit numerous files.
    * The ability to disable Overworld biomes should now function.
      * Disable it by setting `"overworld_enabled": true`.
  * Biomepedia - `<gamedir>/config/biomepedia.json5`
    * Added the ability to disable the biomepedia item, it will no longer be gifted with an advancement.
      * Disable it by setting `"give_item": true`
  * Settings - `<gamedir>/config/settings.json5`
    * Logger settings
      * Added the ability to disable certain types of logging such as warnings, info, & debug. Errors cannot be hidden.
        * Warnings & info are disabled by default.
      * Added the ability to filter out specific terms, characters or phrases from logging in your `latest.log`
    * World Generation
      * The ability to disable BYG world gen altogether should now function.
        * Disable it by setting `"world_generation": true`.
  * Villager Trades - `<gamedir>/config/trades.json5`
    * Villager Trades config will no longer crash when a villager not existent in your game's registry is in the config. A warning will be logged instead.


* ## Bug Fixes
  * Fix floating trees in Overworld & End Dimensions. Trees will now check they're **not** on a cliff first & build logs until they hit the ground. Tree trunks will now always be in contact with the ground.
  * Add Bastion Remnants to BYG biomes. Fixes #1096
  * Villagers can now use Foragers table.
  * Fix Flat Vegetation Voxel Shapes. Don't random offset Ether Foliage texture.
  * Only create `LevelBiomeTracker` with BYG name space biomes. Fixes oversized packets when users have lots of biome mods.
  * Fix BYG Config world gen check.
  * Fixed Flower Patches not spawning.
  * Fixed Leaf Pile block.
  * Fixed Embur Gel Vines not being climbable.
  * Fix brimstone ore textures (#1076).
  * Fix Blueberry bush spawns, blueberries will now spawn in the following biomes:
    * Autumnal Taiga
    * Black Forest
    * Canadian Shield
    * Cika Woods
    * Coconino Meadows
    * Coniferous Forest
    * Dacite Ridges
    * Howling Peaks
    * Maple Taiga
    * Rose Fields
    * Weeping Witch Forest
    * Zelkova Forest
* Don't crash if the villager key doesn't exist in the Villager Trade's config, log a warning instead.
* Embur Lily now can be placed on lava.
* Fix Composting Items on Quilt. Fixes #987.
* BYG Sandstone Recipe Fixes (#1016).
* Fix lily pad placement bug (#1010).
* Fix Peat turning into farmland. Fixes #1051, Fixes #1045, Fixes #797.
* Add dependency for GeckoLib. Fixes issue #1053 (#1060)
* Remove tall flowers in `small_flowers` tag.
* Fix Lush Dirt & Lush Grass turning into Lush Farmland.
* Fix broken recipes.
* Fix witch hazel saplings.
* Fixed flower patch rendering issues.
* Removed large flowers and pollen block from small flowers tag.
* Fixed puffball stew stacking to 64.
* Flowering lilly's will now place with their item.
* Add Blue & Yellow Nether brick stairs/slabs to pickaxe mineable tag. Fixes #1057.
* Fix Upper and bottom layer swapping in NetherBiomesConfig, Fixes #1024.
* Allow invalid Villager Professions in the config and log each invalid Villager Profession. Addresses #1027.
* Fixed some Nether Biomes not spawning Ancient Debris..
* Swamps can now spawn Witch huts.
* Added chest recipe for conflicts and crafting table conversion.
* Fix sythian wart blocks not having a wart block loot table. Also fix flat vegetation having y height variation (#1040).
* Fix Blue Sage spawning.
* Fix sky color using fog color in the biomepedia.
* Set material color for numerous blocks to better match their textures.
* Other bugs *probably*.

# 2.0.0.13
* Fix broken red rock village structures.
* Fix bonemealing ether grass & Embur roots.

# 2.0.0.12
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
* Fix Missing Textures on Pendorite Sword.
* Orange Amaranth can now be composted.
* Blue Nether Brick can now be crafted into blocks.
* Fix Yellow Nether Brick Using incorrect sounds & time.
* Make Water Silk breakable by boats.
* Fix Lament blocks burning in nether.
* Fix seeds on modded farmland.
* Sythian Scaffolding fixes.

# 2.0.0.11
* Fix an if statement in Arch Piece config deserialization that was spamming logs when there was actually no error present.

# 2.0.0.10
* Strip trailing white space from configs when parsing.

# 2.0.0.9
* Add chest boat drops.

# 2.0.0.8
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
* Remove useless tinted overlays to simplify blocks.
* Add LambdaBetterGrass metadata for "grassy" block.
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

# 2.0.0.7
* Update to 1.19.2.

# 2.0.0.6
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