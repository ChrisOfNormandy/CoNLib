# Directory

* biome
* block
* collections
* common
* config
* crop
* event
* feature
* item
* itemgroup
* misc
* registry
* tool
* world

***

# Biome
A collection of biome related classes and methods.

::: `BiomeBase`
* Handles essential biome features such as the biome registry key, beach and river biomes, climates, rain type, client-side features and terrain settings.


::: `BiomeRegistration`\<`T` _extends_ `RegistrationBase`>
* Handles the registry function, data during the Forge registration process.
> See `Biomes`

::: `Biomes`
* Internal classes:
    * `Helpers`
    * _enum_ `RegistryType`
    * `RegistrationBase`
    * `GenericBiome` _extends_ `RegistrationBase`

* Used for biome registration.

::: `ModBiome` _extends_ `BiomeBase`
* A "wrapper" class used for handling biome creation and configuration.

::: `ModClimate`
* Defines the temperature and rainfall definitions used for biome placement in a generated world. See ~~`here`~~ for noise explanation.

::: `RegistryHelper`
* A "wrapper" class used for handling biome registration and configuration.

::: `Terrain`
* Defines surface generation for a biome - the block composition of the terrain at surface level.

***

# Block
A collection of block creation methods and custom block classes.

::: `ModBlock`
* Internal classes:
    * `Stone`
    * `Wood`
    * `Bricks`
    * `Ore`
    * ~~`Node`~~

* Used for creating and registering new block content.
* Contains simplified methods of registering a block and its generic products in a single method.
    * Slabs, stairs, walls, etc...

## Subsets
Methods for creating block products / subsets.
Currently:
* Slabs
* Stairs
* Walls
* Fences
* Fence Gates

## Types
"Wrapper" classes for simplified block registration based on type.

::: `BricksBase`
* Internal classes:
    * `Register`

* Creates a block with properties equal to vanilla bricks.

::: `OreBase`
* Internal classes:
    * `Register`

* **WIP**
* Creates a block with configurable ore properties.

::: `PlantBase`
* **WIP**
* Creates a plant block like flowers or tall grass.

::: `StoneBase`
* Internal classes:
    * `Register`

* Creates a block with properties equal to vanilla stone.

::: `WoodBase`
* Internal classes:
    * `Register`

* Creates a block with properties equal to vanilla wood.

***

# Collections
Classes used for grouping data. There are alternatives to these methods available as standard packages.

::: `JsonBuilder`
* Internal classes:
    * `JsonArray` - simplified as `Object[]`.
    * `JsonObject` - simplified as `HashMap<String, Object>`.

* Creates objects representative of JavaScript objects (JavaScript Object Notation - JSON).

::: `Quartet`
* Stores 4 generic values of any type.
* `Quartet<W, X, Y, Z> = new Quartet<W, X, Y, Z>`
* Example: `Quartet<String, String, Integer, Integer>`

::: `Triplet`
* Stores 3 generic values of any type.
* `Triplet<X, Y, Z> = new Triplet<X, Y, Z>`
* Example: `Quartet<String, String, Integer>`

::: `Tuple`
* Stores 2 generic values of any type. Comparable to a `Pair`.
* `Tuple<X, Y> = new Tuple<X, Y>`
* Example: `Tuple<String, Integer>`

***

# Common
A collection of "universal" classes.

::: `Files`
* Provides methods for writing data to a file.

::: `Noise`
* Improved Perlin Noise by Ken Perlin

::: `StringUtil`
* String manipulation methods, such as `wordCaps(str)` that converts text like "my text" to "My Text."

***

# Config
Handlers for TOML mod configuration files.

::: `Config`
* Config builders and compilers.

::: `ConfigGroup`
* Stores and manages config properties.
* Accepted property types:
    * Int Ranges
    * Strings
    * Integers
    * Doubles
    * Booleans (Flags)
    * Int Lists
    * String Lists
* Allows nested config groups: subgroups.

***

# Crop
Classes relating to crops, plantable items.

::: `CropBase` _extends_ `CropsBlock`
* Base definition of a standard crop.

::: `SeedBase` _extends_ `BlockNamedItem`
* Base definition of a standard seed.

***

# Event
Events that may be used by custom features.

::: `BlockBreak`
* **WIP**
* Event that handles block breaking.

***

# Feature
Game and mod features, such as world generation elements.
**These elements are outdated and have not been implemented yet.**

::: `PlantFeature` _extends_ `PlantFeatureNoConfig`
* **WIP**
* World generation feature for a plant block.

::: `PlantFeatureNoConfig` _extends_ `FlowersFeature<NoFeatureConfig>`

***

# Item
A collection of item creation methods.

::: `Fuel` _extends_ `Item`
* A generic class for declaring an item as a fuel.

::: `ModItem`
* Handles item creation and registration.

***

# ItemGroup
Handlers for creative tabs.

::: `GroupList`
* **WIP**
* Used for grouping creative tab groups by type.
* Not required and completely optional.

::: `Groups` _extends_ `ItemGroup`
* A base for creating custom creative tabs.

***

# Misc
Content creation and registration that isn't easily classified elsewhere.

::: `ModPainting`
* Handles registering new paintings to the game.

***

# Registry
Methods defining registration methods of various types and implementations.

::: `ModRegister`
* Implements methods of registering content supported elsewhere in this library.

***

# Tool
Classes representative of tools and tool-like items.

::: `CraftingTool` _extends_ `Item`
* Registers a new tool as "craftable," meaning it is used in crafting and is returned after the crafting operation is completed - like buckets.

::: `ToolBase` _extends_ `Item`
* **WIP**
* Creates an item with properties relative to a tool based on type and material.

::: `ToolMaterial`
* **WIP**
* Represents typical properties of tools like rarity, repair and fire immunity.

***

# World
Content defined in custom world types and world generation.
**All content within is entirely WIP**

::: `ModBiomeProvider` _extends_ `BiomeProvider`
* Used for defining biome spread, generation in a world.

::: `ModDimension` _extends_ `DimensionType`
* Defines a generation supplier for a custom dimension. This is required by new world types.

::: `ModNetherBiomeProvider` _extends_ `BiomeProvider`
* Similar to `ModBiomeProvider` but for use in Nether generation.

::: `ModWorldType` _extends_ `ForgeWorldType`
* Defines a custom world generation type. Some assembly required ;).

*** 

**The following are still very raw and I won't include descriptions until they are well established.**

***
## Factories
Factories are used in defining regions of generation for biome spread and ordering, among other things.

::: _interface_ `AreaInterface` <`T` _extends_ `IArea`> _extends_ `IExtendedNoiseRandom`<`T`> 

::: `ContextFactory` _extends_ `LazyAreaLayerContext` _implements_ `AreaInterface`<`LazyArea`>

::: `ModFactories`

## Generators
Used for defining generation methods based on noise values given layer data.

::: `GeneratorSettings`

::: `ModGenerator`

## Layers
Layers define noise values given their properties. For instance, rainfall and temperature data, among other things, defines biome generation.

::: `LayerHelper`

::: _enum_ `ModClimateLayer` _implements_ `IAreaTransformer2`, `IDimOffset0Transformer`

::: `RainfallLayer` _implements_ `AreaTransformer0`

::: `TemperatureLayer` _implements_ `AreaTransformer0`

### Nether

::: _enum_ `ModNetherLayer` _implements_ `IAreaTransformer0`, `IDimOffset0Transformer`

### Overworld

::: _enum_ `ModBeachLayer` _implements_ `ICastleTransformer`

::: _enum_ `ModBiomeLayer` _implements_ `IAreaTransformer2`, `IDimOffset0Transformer`

::: _enum_ `ModEdgeBiomeLayer` _implements_ `ICastleTransformer`

::: _enum_ `ModIslandLayer` _implements_ `IAreaTransformer2`, `IDimOffset1Transformer`

::: _enum_ `ModOceanLayer` _implements_ `AreaTransformer3`, `IDimOffset0Transformer`

::: _enum_ `ModRiverLayer` _implements_ `IAreaTransformer2`, `IDimOffset0Transformer`

::: _enum_ `ModSubBiomeLayer` _implements_ `IAreaTransformer2`, `IDimOffset1Transformer`

## Transformers
Transformers are responsible for manipulating data values based on a specified function, such as applying randomization or amplification.

::: _interface_ `AreaTransformer0`

::: _interface_ `AreaTransformer3` _extends_ `IDimTransformer`