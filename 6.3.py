#!/usr/bin/python

dat1 = open("dat1.txt").read().splitlines()
dat2 = open("dat2.txt").read().splitlines()
dat1_set = set(dat1)
dat2_set = set(dat2)
dat1_bez_dat2 = dat1_set - dat2_set
dat2_bez_dat1 = dat2_set - dat1_set

izlaz = open("izlaz_razlika.txt", "w")
izlaz.write("//dat1\n")
for x in dat1:
	if x in dat1_bez_dat2:
		izlaz.write(x+"\n")

izlaz.write("//dat2\n")
for x in dat2:
	if x in dat2_bez_dat1:
		izlaz.write(x+"\n")

izlaz.close()
