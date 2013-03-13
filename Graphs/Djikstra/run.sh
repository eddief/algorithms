#!/bin/bash

javac *.java

for i in `seq 1 15`;
do
	python2 graphgen.py 15 > graph.txt
	java Djikstra graph.txt 15
done
python2 mean.py djikstra_time.txt >> dj_avg.txt
rm djikstra_time.txt

for i in `seq 1 15`;
do
	python2 graphgen.py 100 > graph.txt
	java Djikstra graph.txt 100
done
python2 mean.py djikstra_time.txt >> dj_avg.txt
rm djikstra_time.txt

for i in `seq 1 15`;
do
	python2 graphgen.py 200 > graph.txt
	java Djikstra graph.txt 200
done
python2 mean.py djikstra_time.txt >> dj_avg.txt
rm djikstra_time.txt

for i in `seq 1 15`;
do
	python2 graphgen.py 500 > graph.txt
	java Djikstra graph.txt 500
done
python2 mean.py djikstra_time.txt >> dj_avg.txt
rm djikstra_time.txt

for i in `seq 1 15`;
do
	python2 graphgen.py 1000 > graph.txt
	java Djikstra graph.txt 1000
done
python2 mean.py djikstra_time.txt >> dj_avg.txt
rm djikstra_time.txt

for i in `seq 1 15`;
do
	python2 graphgen.py 5000 > graph.txt
	java Djikstra graph.txt 5000
done
python2 mean.py djikstra_time.txt >> dj_avg.txt
rm djikstra_time.txt