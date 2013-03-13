#!/bin/bash

javac *.java

for i in `seq 1 15`;
do
	python2 graphgen.py 5 > graph.txt
	java Djikstra graph.txt 5
done
python2 mean.py djikstra_time.txt >> dj_avg.txt
rm djikstra_time.txt

for i in `seq 1 15`;
do
	python2 graphgen.py 15 > graph.txt
	java Djikstra graph.txt 15
done
python2 mean.py djikstra_time.txt >> dj_avg.txt
rm djikstra_time.txt

for i in `seq 1 15`;
do
	python2 graphgen.py 30 > graph.txt
	java Djikstra graph.txt 30
done
python2 mean.py djikstra_time.txt >> dj_avg.txt
rm djikstra_time.txt

for i in `seq 1 15`;
do
	python2 graphgen.py 50 > graph.txt
	java Djikstra graph.txt 50
done
python2 mean.py djikstra_time.txt >> dj_avg.txt
rm djikstra_time.txt