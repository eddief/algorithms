#!/bin/bash

javac *.java

for i in `seq 1 15`;
do
	python2 graphgen.py g.txt 5
	java DynTSP g.txt 5
done
python2 mean.py dyntsp_time.txt >> dyn_avg.txt
rm dyntsp_time.txt

for i in `seq 1 15`;
do
	python2 graphgen.py g.txt 15
	java DynTSP g.txt 15
done
python2 mean.py dyntsp_time.txt >> dyn_avg.txt
rm dyntsp_time.txt

for i in `seq 1 15`;
do
	python2 graphgen.py g.txt 30
	java DynTSP g.txt 30
done
python2 mean.py dyntsp_time.txt >> dyn_avg.txt
rm dyntsp_time.txt

for i in `seq 1 15`;
do
	python2 graphgen.py g.txt 50
	java DynTSP g.txt 50
done
python2 mean.py dyntsp_time.txt >> dyn_avg.txt
rm dyntsp_time.txt