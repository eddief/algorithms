#!/bin/bash

javac *.java

for i in `seq 1 15`;
do
	python2 graphgen.py graph.txt 5
	java Djikstra graph.txt 5
done
python2 mean.py djikstra_time.txt >> dj_avg.txt
rm djikstra_time.txt

for i in `seq 1 15`;
do
	python2 graphgen.py graph.txt 15
	java Djikstra graph.txt 15
done
python2 mean.py djikstra_time.txt >> dj_avg.txt
rm djikstra_time.txt

for i in `seq 1 15`;
do
	python2 graphgen.py graph.txt 30
	java Djikstra graph.txt 30
done
python2 mean.py djikstra_time.txt >> dj_avg.txt
rm djikstra_time.txt

for i in `seq 1 15`;
do
	python2 graphgen.py graph.txt 50
	java Djikstra graph.txt 50
done
python2 mean.py djikstra_time.txt >> dj_avg.txt
rm djikstra_time.txt