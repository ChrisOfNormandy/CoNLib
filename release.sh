#!/bin/bash

echo Release version: $1

if [[ $# -eq 0 ]] ; then
    echo 'You must provide a release version.'
    exit 0
fi

cwd=$(pwd)

./gradlew build

rm -r com/github/chrisofnormandy

mvn install:install-file \
-DgroupId=com.github.chrisofnormandy \
-DartifactId=conlib \
-Dversion=$1 \
-Dfile=build/libs/conlib-$1.jar \
-Dpackaging=jar \
-DlocalRepositoryPath=. \
-DcreateChecksum=true \
-Djar.finalName=${artifactId}-${version}