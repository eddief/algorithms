import random
import sys
import math

name = sys.argv[1]
num = sys.argv[2]

f = open(name, 'w')
for i in range(0, int(num)):

	for k in range(0, int(num)):

		c = random.choice(range(100))
		s = "" + str(i) + ", " + str(k) + ", " + str(c)
		f.write(s + "\n")