#!/bin/bash
set -e
export JAVA_HOME=$PWD/jdk-17.0.12
export PATH=$JAVA_HOME/bin:$PATH
java -jar target/ip-app-0.0.1-SNAPSHOT.jar --server.port=$PORT --server.address=0.0.0.0