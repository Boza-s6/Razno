#!/usr/bin/python


with open("razno.txt", 'r') as fajl, open("indetifikatori.txt", "w") as izlaz:
	#read file, make list of lines (without '\n'), join with space between, split by spaces to get words
	reci = " ".join([x for x in fajl.read().splitlines()]).split()
	iden = [x for x in reci if x[:1].isalpha() or x.startswith("_")]
	izlaz.write(" ".join(iden))
