#!/bin/bash

for i in `seq 1 10`;
do
	java Queens 4
done
python2 ../Sorting/mean.py queens_time.txt >> queens_avgtime.txt
python2 ../Sorting/mean.py queens_estimate.txt >> queens_eavg.txt
rm queens_time.txt
rm queens_estimate.txt

for i in `seq 1 10`;
do
	java Queens 20
done
python2 ../Sorting/mean.py queens_time.txt >> queens_avgtime.txt
python2 ../Sorting/mean.py queens_estimate.txt >> queens_eavg.txt
rm queens_time.txt
rm queens_estimate.txt

for i in `seq 1 10`;
do
	java Queens 35
done
python2 ../Sorting/mean.py queens_time.txt >> queens_avgtime.txt
python2 ../Sorting/mean.py queens_estimate.txt >> queens_eavg.txt
rm queens_time.txt
rm queens_estimate.txt


for i in `seq 1 10`;
do
	java Queens 55
done
python2 ../Sorting/mean.py queens_time.txt >> queens_avgtime.txt
python2 ../Sorting/mean.py queens_estimate.txt >> queens_eavg.txt
rm queens_time.txt
rm queens_estimate.txt


for i in `seq 1 10`;
do
	java Queens 100
done
python2 ../Sorting/mean.py queens_time.txt >> queens_avgtime.txt
python2 ../Sorting/mean.py queens_estimate.txt >> queens_eavg.txt
rm queens_time.tx
rm queens_estimate.txt