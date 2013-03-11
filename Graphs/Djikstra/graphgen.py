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
	
		if c > 90:
			if i != k:
				if k == int(num):
					s = str(k)
					f.write(s)
				else:
					s = str(k) + ", "
					f.write(s)

		else:
			if i != k:
				if k == int(num):
					s = str(-1)
					f.write(s)
				else:
					s = str(-1) + ", "
					f.write(s)

	f.write(s + "\n")