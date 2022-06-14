#!/bin/sh

set -e

cd src/
rm -rf ./**/*.class || true
find * -name "*.java" > sources.txt
javac @sources.txt && java simulation/App ../scenario.txt
rm -rf ./**/*.class sources.txt || true
