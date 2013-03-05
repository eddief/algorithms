#!/bin/bash

for i in `seq 1 10`;
do
	java Queens 4
done
python2 ../Sorting/mean.py queens_time.txt >> queens_avgtime.txt
python2 ../Sorting/mean.py queens_estimate.txt >> queens_eavg.txt
python2 ../Sorting/mean.py queens_visited.txt >> queens_visavg.txt
rm queens_visited.txt
rm queens_time.txt
rm queens_estimate.txt

for i in `seq 1 10`;
do
	java Queens 6
done
python2 ../Sorting/mean.py queens_time.txt >> queens_avgtime.txt
python2 ../Sorting/mean.py queens_estimate.txt >> queens_eavg.txt
python2 ../Sorting/mean.py queens_visited.txt >> queens_visavg.txt
rm queens_visited.txt
rm queens_time.txt
rm queens_estimate.txt

for i in `seq 1 10`;
do
	java Queens 8
done
python2 ../Sorting/mean.py queens_time.txt >> queens_avgtime.txt
python2 ../Sorting/mean.py queens_estimate.txt >> queens_eavg.txt
python2 ../Sorting/mean.py queens_visited.txt >> queens_visavg.txt
rm queens_visited.txt
rm queens_time.txt
rm queens_estimate.txt


for i in `seq 1 10`;
do
	java Queens 12
done
python2 ../Sorting/mean.py queens_time.txt >> queens_avgtime.txt
python2 ../Sorting/mean.py queens_estimate.txt >> queens_eavg.txt
python2 ../Sorting/mean.py queens_visited.txt >> queens_visavg.txt
rm queens_visited.txt
rm queens_time.txt
rm queens_estimate.txt