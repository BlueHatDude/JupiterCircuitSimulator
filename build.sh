#!/bin/bash 


cd src/
javac -d . jupiter/components/*.java\
            jupiter/logic/*.java\
            jupiter/ui/*.java
javac Main.java
java Main
