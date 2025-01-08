#!/bin/bash

./gradlew build

rm -r com/github/chrisofnormandy

VERSION="$(./gradlew projectVersion -q | grep 'VERSION:' | awk '{print $NF}' | head -n 1)"
BUILT_JAR="build/libs/conlib-${VERSION}.jar"
FINAL_NAME="conlib-${VERSION}"

echo $BUILT_JAR

mvn install:install-file \
-Dfile=$BUILT_JAR \
-DlocalRepositoryPath="." \
-DcreateChecksum=true \
-Djar.finalName=$FINAL_NAME \
-DgroupId=com.github.chrisofnormandy \
-DartifactId=conlib \
-Dversion=$VERSION \
-Dpackaging=jar