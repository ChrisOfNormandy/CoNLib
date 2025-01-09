#!/bin/bash

rm -r com
rm -r mcmodsrepo

./gradlew publish

mv mcmodsrepo/com com
rm -r mcmodsrepo
