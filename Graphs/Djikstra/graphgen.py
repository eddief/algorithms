import random
import sys
import math

num = sys.argv[1]

for i in range(1, int(num)+1):

	for k in range(1, int(num)+1):

		c = 0
		while c == 0: c = random.choice(range(100))

		if k != i:
			if k != int(num):
				s = str(c) + ", "
				sys.stdout.write(s)
			else:
				s = str(c)
				sys.stdout.write(s)
		else:
			if k != int(num):
				s = str(-1) + ", "
				sys.stdout.write(s)
			else:
				s = str(-1)
				sys.stdout.write(s)
	sys.stdout.write("\n")

