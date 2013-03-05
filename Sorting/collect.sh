#!/bin/bash

echo "------------FOR N=10" >> $2
echo "" >> $2

for i in `seq 1 30`;
do
	python2 generate.py list.txt 10
	java $1 list.txt >> $2
done
python2 mean.py $3 >> $5
python2 mean.py $4 >> $6
rm $3 $4

echo "------------FOR N=100" >> $2
echo "" >> $2

for i in `seq 1 30`;
do
	python2 generate.py list.txt 100
	java $1 list.txt >> $2
done
python2 mean.py $3 >> $5
python2 mean.py $4 >> $6
rm $3 $4

echo "------------FOR N=1000" >> $2
echo "" >> $2

for i in `seq 1 30`;
do
	python2 generate.py list.txt 1000
	java $1 list.txt >> $2
done
python2 mean.py $3 >> $5
python2 mean.py $4 >> $6
rm $3 $4

echo "------------FOR N=5000" >> $2
echo "" >> $2

for i in `seq 1 30`;
do
	python2 generate.py list.txt 5000
	java $1 list.txt >> $2
done
python2 mean.py $3 >> $5
python2 mean.py $4 >> $6
rm $3 $4

echo "------------FOR N=10000" >> $2
echo "" >> $2

for i in `seq 1 30`;
do
	python2 generate.py list.txt 10000
	java $1 list.txt >> $2
done
python2 mean.py $3 >> $5
python2 mean.py $4 >> $6
rm $3 $4

echo "------------FOR N=50000" >> $2
echo "" >> $2

for i in `seq 1 30`;
do
	python2 generate.py list.txt 50000
	java $1 list.txt >> $2
done
python2 mean.py $3 >> $5
python2 mean.py $4 >> $6
rm $3 $4

echo "------------FOR N=100000" >> $2
echo "" >> $2

for i in `seq 1 30`;
do
	python2 generate.py list.txt 100000
	java $1 list.txt >> $2
done
python2 mean.py $3 >> $5
python2 mean.py $4 >> $6
rm $3 $4