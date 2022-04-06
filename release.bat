rmdir -rf /Q /S "com/github/chrisofnormandy"

call gradlew build deobf

call mvn install:install-file ^
-DgroupId=com.github.chrisofnormandy ^
-DartifactId=conlib ^
-Dversion=%1 ^
-Dfile=build/libs/conlib-%1-deobf.jar ^
-Dpackaging=jar ^
-DlocalRepositoryPath=. ^
-DcreateChecksum=true ^
-Djar.finalName=${artifactId}-${version}-deobf

call runRename %1