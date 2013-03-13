#!/bin/bash

javac *.java

for i in `seq 1 15`;
do
	python2 generate.py graph.txt 10
	java MinMax graph.txt
done
python2 mean.py mimx_comp.txt >> hcomp_avg.txt
python2 mean.py mimx_time.txt >> htime_avg.txt
rm mimx_time.txt mimx_comp.txt

for i in `seq 1 15`;
do
	python2 generate.py graph.txt 100
	java MinMax graph.txt
done
python2 mean.py mimx_comp.txt >> hcomp_avg.txt
python2 mean.py mimx_time.txt >> htime_avg.txt
rm mimx_time.txt mimx_comp.txt

for i in `seq 1 15`;
do
	python2 generate.py graph.txt 1000
	java MinMax graph.txt
done
python2 mean.py mimx_comp.txt >> hcomp_avg.txt
python2 mean.py mimx_time.txt >> htime_avg.txt
rm mimx_time.txt mimx_comp.txt

for i in `seq 1 15`;
do
	python2 generate.py graph.txt 5000
	java MinMax graph.txt
done
python2 mean.py mimx_comp.txt >> hcomp_avg.txt
python2 mean.py mimx_time.txt >> htime_avg.txt
rm mimx_time.txt mimx_comp.txt

for i in `seq 1 15`;
do
	python2 generate.py graph.txt 10000
	java MinMax graph.txt
done
python2 mean.py mimx_comp.txt >> hcomp_avg.txt
python2 mean.py mimx_time.txt >> htime_avg.txt
rm mimx_time.txt mimx_comp.txt

for i in `seq 1 15`;
do
	python2 generate.py graph.txt 50000
	java MinMax graph.txt
done
python2 mean.py mimx_comp.txt >> hcomp_avg.txt
python2 mean.py mimx_time.txt >> htime_avg.txt
rm mimx_time.txt mimx_comp.txt

for i in `seq 1 15`;
do
	python2 generate.py graph.txt 100000
	java MinMax graph.txt
done
python2 mean.py mimx_comp.txt >> hcomp_avg.txt
python2 mean.py mimx_time.txt >> htime_avg.txt
rm mimx_time.txt mimx_comp.txt