#!/bin/bash

javac *.java

for i in `seq 1 15`;
do
	python2 generate.py list.txt 10000
	java MergeSort list.txt
done
python2 mean.py m_counts.txt >> m_avgcounts.txt
python2 mean.py m_times.txt >> m_avgtimes.txt
rm m_counts.txt m_times.txt

for i in `seq 1 15`;
do
	python2 generate.py list.txt 50000
	java MergeSort list.txt
done
python2 mean.py m_counts.txt >> m_avgcounts.txt
python2 mean.py m_times.txt >> m_avgtimes.txt
rm m_counts.txt m_times.txt 
