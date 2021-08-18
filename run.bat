@echo off

cd src

javac -d ../bin boot/chip8/main/Start.java

cd ../bin 

java boot.chip8.main.Start
