#!/bin/bash

for i in `seq 1 30`;
do
	python2 graphgen.py out.txt 10
	java $1 out.txt
done
python2 ../Sorting/mean.py $2 >> $3
rm $2

for i in `seq 1 30`;
do
	python2 graphgen.py out.txt 100
	java $1 out.txt
done
python2 ../Sorting/mean.py $2 >> $3
rm $2

for i in `seq 1 30`;
do
	python2 graphgen.py out.txt 500
	java $1 out.txt
done
python2 ../Sorting/mean.py $2 >> $3
rm $2

for i in `seq 1 30`;
do
	python2 graphgen.py out.txt 1000
	java $1 out.txt
done
python2 ../Sorting/mean.py $2 >> $3
rm $2

for i in `seq 1 30`;
do
	python2 graphgen.py out.txt 5000
	java $1 out.txt
done
python2 ../Sorting/mean.py $2 >> $3
rm $2
