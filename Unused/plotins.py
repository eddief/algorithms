import matplotlib.pyplot as plt
import sys

filename = sys.argv[1]
output = sys.argv[2]

if sys.argv[3] is "C":
	ax = "Number of Comparisons"
else:
	ax = "Time Taken"

lines = [int(line.strip()) for line in open(filename)]

sizes = [10,100,1000,10000,100000]

plt.plot(, lines)
plt.ylabel(ax)
plt.xlabel("Input Size")

s = "" + output + "plot.png"
plt.savefig(s)



 la = plt.plot(x,a,'b-',label='cosine')
>>> lb = plt.plot(x,b,'r--',label='sine')
>>> lc = plt.plot(x,c,'gx',label='exp(+x)')
>>> ld = plt.plot(x,d,'y-', linewidth = 5,label='exp(-x)')
>>> ll = plt.legend(loc='upper left')