#!/bin/bash
set -e
# Download Java 17
wget -q https://download.oracle.com/java/17/latest/jdk-17_linux-x64_bin.tar.gz
tar -xzf jdk-17_linux-x64_bin.tar.gz
export JAVA_HOME=$PWD/jdk-17.0.12
export PATH=$JAVA_HOME/bin:$PATH
# Build app
mvn clean install -DskipTests