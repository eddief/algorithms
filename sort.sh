#!/bin/bash
echo "------------FOR N=10" >> labbook.txt
echo "" >> labbook.txt

for i in `seq 1 30`;
do
	python2 generate.py list.txt 10
	java InsertionSort list.txt >> labbook.txt
done

echo "------------FOR N=100" >> labbook.txt
echo "" >> labbook.txt

for i in `seq 1 30`;
do
	python2 generate.py list.txt 100
	java InsertionSort list.txt >> labbook.txt
done

echo "------------FOR N=1000" >> labbook.txt
echo "" >> labbook.txt

for i in `seq 1 30`;
do
	python2 generate.py list.txt 1000
	java InsertionSort list.txt >> labbook.txt
done

echo "------------FOR N=10000" >> labbook.txt
echo "" >> labbook.txt

for i in `seq 1 30`;
do
	python2 generate.py list.txt 10000
	java InsertionSort list.txt >> labbook.txt
done

echo "------------FOR N=100000" >> labbook.txt
echo "" >> labbook.txt

for i in `seq 1 30`;
do
	python2 generate.py list.txt 100000
	java InsertionSort list.txt >> labbook.txt
done