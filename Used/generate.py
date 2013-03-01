import random
import sys
import math

name = sys.argv[1]
num = sys.argv[2]

f = open(name, 'w')
for i in range(0, int(num)):
	n = random.choice(range(100))
	if random.random() > 0.49:
		n = n * -1
	f.write(str(n) + "\n")