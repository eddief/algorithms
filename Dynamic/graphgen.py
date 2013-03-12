import random
import sys
import math

name = sys.argv[1]
num = sys.argv[2]

f = open(name, 'w')
for i in range(1, int(num)+1):

	for k in range(1, int(num)+1):

		c = 0
		while c == 0:
			c = random.choice(range(100))
		if i != k:
			s = "" + str(i) + ", " + str(k) + ", " + str(c)
			f.write(s + "\n")