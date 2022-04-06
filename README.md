# Setup Reference

Getting the information down because I know for a fact I'll forget it at some point.

If you would like to see examples of my other projects, come join my Discord - https://discord.gg/EW5JsGJfdt
Too, my website - The Syren Project / Syren Dev. Tech. - http://www.syren-dev.tech
Or take a look at my other repositories for other projects I work on in my free time.

# Maven

https://maven.apache.org/download.cgi
Uses Apache Maven 3.6.3

The directory used is ./com/github/chrisofnormandy/conlib/1.0 and can be imported using:
```
repositories{
    maven {
        url "https://raw.githubusercontent.com/ChrisOfNormandy/CoNLib/{BRANCH}"
    }
}
...
dependencies {
    minecraft 'net.minecraftforge:forge:1.16.5-36.1.0'
    compile 'com.github.chrisofnormandy:conlib:1.1:deobf'
}
```

Given Forge versioning and the frequent changes to this library, ensure the Forge version is correct in the dependencies. Too, that any mod referencing this library uses the same version.

When making edits to the library in development, push to the MC version branch. When using this branch during development, replace {BRANCH} with the Minecraft version (`1.16.5`) in the maven repo settings.
If you want to use this library locally as an in-dev release, you can replace the maven url with a direct path to the repository directory of this project.

The master branch is used for full releases and should be referenced by the maven repo.
Else, use the version number of the Minecraft release, such as `1.16.5`.

When releasing a new jar, run the `release.bat` script. It will build a deobf version of the mod using the version defined by the `build.gradle` file. When running the command `release` you must supply a version number equal to the one defined in the build script. For instance, `release 1.1` will run the deobf build, maven build, then rename the deobf files to version 1.1.

There should be a cleaner way of doing this, such as using a POM file, but I'm not bothered by doing such a thing and this hacky method works just fine for the limited scope of this project.

# CoNLib

By standard, the root class for each mod is the `Main.java` file.

Most things can be registered using a method defined in `conlib/registry/ModRegister.java`, but there are other areas that define more complex and / or refined methods.

For instance, `block/ModBlock.java` provides a handful of preset methods for registering new block types like stone, wood, bricks and ore. Too, some custom block types I developed are accessable via this interface. 

Some of these presets have even more generous registration capabilities, such as `Ore`, which allows the registration of various resources associated with ore blocks. Things like tools, ingots, nuggets, armour, the base item, etc...

# Configs

Given my dedication to provide avenues of Minecraft modding for less-technical Minecrafters, the classes `Config` and `ConfigGroup` provide fairly well-formed methods for generating config TOML files. These configs can contain subgroups and even be placed with their own directories within the `/config` folder. As such, registering unique configs for individual aspects of a mod is easily accomplished.

Furthermore, config properties are stored in a `HashMap` accessable by the `ConfigGroup` class, each defined by their data type. For example, boolean values (flags) are stored under the `flags` map.

Going beyond this, it is possible to define lists within configs, allowing the ability to generate new configs and resources based on definitions within a config. This should be used with caution, however, as registering new content using this method is dangerous if done impropperly. The methods are fairly simple, and they are easily modified. However, once a resource has been registered to the mod and loaded within a world, that resource cannot change without adverse affects to the save. As such, all configuration settings should be supplied **BEFORE** a new world is created.

***

Below is an example config that generates additional configs:
```java
    Config config = new Config(Main.MOD_ID);

    ConfigGroup gemGroup = new ConfigGroup();

    gemGroup.addFlag("allow_gems", true, "Should gems be a thing?");

    List<String> gemList = new ArrayList<String>();
    // A list should be generated here.
    gemGroup.addStringList("gem_list", gemList, "A list of default gem types. DO NOT MODIFY THIS LIST.");

    config.addSubgroup("Gems", gemGroup);

    config.Build();
    configs.put(Main.MOD_ID, config);

    gemGroup.getStringListValue("gem_list").forEach((String gem) -> {
        Config cfg = new Config("mymod/gems", gem);
        buildResourceCfg(gem, cfg); // A method that defines the content of each individual config.
        cfg.Build();
        gemConfigs.put("gems_" + gem, cfg);
    });
```

Line-by-line:
First we create a new config named after the mod. This ID should be defined in the `Main.java` file.

Next, we create a new subgroup for the main config named `gemGroup`. This will create a subsection of config values within the main config, better ordering our values.

We provide the new subgroup a property "allow_gems," a boolean to determine whether this config option should be used. We can refernce this value later during the registration process and not here, in case this value changes.

Next, we make a list of gems. This is just an example, meaning you can make a list of anything you would like.
I'm skipping the part about adding items to the list. It's just `gemList.add("myGem");` for each value.

Finally, we assign this list to a property named "gem_list" within our gem subgroup.

Now that we have finished composing our subgroup we can add it to the main config. We do this using the `addSubgroup` method in the main config.

Finally, we build the config using `Build` and place it in our configs map we define elsewhere. I typically place it as a public variable within a file `Mod_Config.json`, where all this code would be provided within a method `Init`. But this is up to the developer.

Now we can generate all our individual configs. Since we have a list of values, we an iterate over it using a forEach loop. For every item in the list we create a new config. There are two constructors for configs: one with just a name (placed in `/configs`) and one where we provide a folder. For this we'll place each config within `/configs/mymod/gems` and use the item name as the config name.

Next, we build our config similarly to the main config. You can create a helper method that does this for you.

Finally, we build the config and place it in a separate config map under a unique name. These configs can be placed within the same map as the previous, but for the sake of "cleanliness," I prefer placing registered objects within approprate, unique locations. This allows the ability to register multiple configs for a single reference element, such as individual configs for ore generation, tools, armour, etc...

***

# Public Usage

Anyone may use this library mod as long as they credit me in some manner. Throwing my name (ChrisOfNormandy) somewhere in the description is completely acceptable. Please do not redistribute this project or misrepresent its purpose - providing easier access to Minecraft modding.

If you would like to contribute to this project, I thank you. I am a fairly picky developer and prefer working on side projects on my own. I consider these things more as "passion projects" and "tinker tools" than something to release out into the public as a product. However, anyone may clone this repository and modify its code for personal use - please do not redistribute a modified version of this library unless you have my explicit consent.

Modification of this project includes, but is not limited to, renaming variables and properties; adding and / or removing classes; restructuring of package definitions by moving or renaming file structures; adding additional code or removing original code.

Please be an ethical and responsible developer and credit people where credit is due. Do not copy / paste my code as your own. If you would like to use this as a reference, go right on ahead. I am developing a tutorial on the basics of programming in various languages and how to apply these principles in things such as game modding and development. A source will be provided here when available.