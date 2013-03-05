#!/bin/bash

for i in `seq 1 30`;
do
	java Queens 4
done
python2 ../Sorting/mean.py queens_time.txt >> queens_avg.txt
rm queens_time.txt

for i in `seq 1 30`;
do
	java Queens 20
done
python2 ../Sorting/mean.py queens_time.txt >> queens_avg.txt
rm queens_time.txt

for i in `seq 1 30`;
do
	java Queens 35
done
python2 ../Sorting/mean.py queens_time.txt >> queens_avg.txt
rm queens_time.txt

for i in `seq 1 30`;
do
	java Queens 55
done
python2 ../Sorting/mean.py queens_time.txt >> queens_avg.txt
rm queens_time.txt

for i in `seq 1 30`;
do
	java Queens 100
done
python2 ../Sorting/mean.py queens_time.txt >> queens_avg.txt
rm queens_time.txt