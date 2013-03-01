#!/bin/bash

echo "------------FOR N=10" >> $2
echo "" >> $2

for i in `seq 1 30`;
do
	python2 generate.py list.txt 10
	java $1 list.txt >> $2
done
mean.py $3 >> $5
mean.py $4 >> $6
rm $3 $4

echo "------------FOR N=100" >> $2
echo "" >> $2

for i in `seq 1 30`;
do
	python2 generate.py list.txt 100
	java $1 list.txt >> $2
done
mean.py $3 >> $5
mean.py $4 >> $6
rm $3 $4

echo "------------FOR N=1000" >> $2
echo "" >> $2

for i in `seq 1 30`;
do
	python2 generate.py list.txt 1000
	java $1 list.txt >> $2
done
mean.py $3 >> $5
mean.py $4 >> $6
rm $3 $4

echo "------------FOR N=10000" >> $2
echo "" >> $2

for i in `seq 1 30`;
do
	python2 generate.py list.txt 10000
	java $1 list.txt >> $2
done
mean.py $3 >> $5
mean.py $4 >> $6
rm $3 $4

echo "------------FOR N=100000" >> $2
echo "" >> $2

for i in `seq 1 30`;
do
	python2 generate.py list.txt 100000
	java $1 list.txt >> $2
done
mean.py $3 >> $5
mean.py $4 >> $6
rm $3 $4