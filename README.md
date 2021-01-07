# Setup Reference

Getting the information down because I know for a fact I'll forget it at some point.

# Maven

https://maven.apache.org/download.cgi
Uses Apache Maven 3.6.3

The directory used is ./com/github/chrisofnormandy/conlib/1.0 and can be imported using:
```
repositories{
    maven {
        url "https://raw.githubusercontent.com/ChrisOfNormandy/CoNLib/master"
    }
}
...
dependencies {
    minecraft 'net.minecraftforge:forge:1.16.4-35.1.4'
    compile 'com.github.chrisofnormandy:conlib:1.0:deobf'
}
```

When making edits to the library in development, push to the `dev` branch.
The master branch is used for full releases and referenced via the maven repo.

When releasing a new jar, the following commands need to be executed:
- `gradlew build deobf` -> Create the deobf version of the jar, placed in ./build/libs
- `run`                 -> Regenerates the Maven repo.

Here's where some manual editing needs to be done:
Rename all the files inside the verision directory (default ./1.0) from `conlib-#.#.jar` to `conlib-#.#-deobf.jar`.
In the future I'd like to use a `pom.xml` file to build, but I can't figure it out and need some time to sit down and really look it over.

# CoNLib

By my standard, the root class for each part is the `Main.java` file.
Example: Blocks = `import com.github.chrisofnormandy.conlib.block.Main;`

Registering content manually:
./registry/`ModRegister.java`