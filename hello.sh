#!/bin/bash
for i in `seq 1 30`;
do
	python2 generate.py thelist.txt 10
	java ExchangeSort thelist.txt >> notes.txt
done