import numpy
import sys

filename = sys.argv[1]
lines = [int(line.strip()) for line in open(filename)]
print numpy.mean(lines)