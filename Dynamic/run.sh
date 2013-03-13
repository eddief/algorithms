#!/bin/bash

javac *.java
python2 graphgen.py out.txt 15
java DynTSP out.txt 15