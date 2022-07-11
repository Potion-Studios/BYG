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