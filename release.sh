#!/bin/bash

echo Release version: $1

if [[ $# -eq 0 ]] ; then
    echo 'You must provide a release version.'
    exit 0
fi

cwd=$(pwd)

./gradlew build deobf

rm -r com/github/chrisofnormandy

mvn install:install-file \
-DgroupId=com.github.chrisofnormandy \
-DartifactId=conlib \
-Dversion=$1 \
-Dfile=build/libs/conlib-$1-deobf.jar \
-Dpackaging=jar \
-DlocalRepositoryPath=. \
-DcreateChecksum=true \
-Djar.finalName=${artifactId}-${version}-deobf

cd com/github/chrisofnormandy/conlib/$1

mv conlib-$1.jar conlib-$1-deobf.jar
mv conlib-$1.jar.md5 conlib-$1-deobf.jar.md5
mv conlib-$1.jar.sha1 conlib-$1-deobf.jar.sha1
mv conlib-$1.pom conlib-$1-deobf.pom
mv conlib-$1.pom.md5 conlib-$1-deobf.pom.md5
mv conlib-$1.pom.sha1 conlib-$1-deobf.pom.sha1

cd $cwd