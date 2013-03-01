#!/bin/bash

python2 calc.py counts.txt >> avgcomp.txt
python2 calc.py times.txt >> avgtime.txt

python2 plotvals.py