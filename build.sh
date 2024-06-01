#!/bin/bash 


cd src/
javac -d . jupiter/components/*.java\
            jupiter/logic/*.java\
            jupiter/ui/*.java\
            jupiter/utils/*.java
javac Main.java
java Main
