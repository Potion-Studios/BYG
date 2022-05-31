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