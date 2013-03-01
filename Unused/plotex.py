import matplotlib.pyplot as plt
import sys

filename = sys.argv[1]
output = sys.argv[2]

a = [int(line.strip()) for line in open(filename)]
size = [10,100,1000,10000,100000]

if sys.argv[3] is "C":
	ax = "Number of Comparisons"
else:
	ax = "Time Taken"

plt.plot(size, a, label='ExchangeSort')

plt.legend(loc='upper left')
plt.ylabel(ax)
plt.xlabel("Input Size")

s = "" + output + "plot.png"
plt.savefig(s)