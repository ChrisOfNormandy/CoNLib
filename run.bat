mvn install:install-file ^
-DgroupId=com.github.chrisofnormandy ^
-DartifactId=conlib ^
-Dversion=1.0 ^
-Dfile=build/libs/conlib-1.0-deobf.jar ^
-Dpackaging=jar ^
-DlocalRepositoryPath=. ^
-DcreateChecksum=true ^
-Djar.finalName=${artifactId}-${version}-deobf