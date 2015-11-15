#!/usr/bin/python
import collections
import re
with open("reci.txt") as ulaz:
	#split by lines, then join, then split by space, then remove non alpha chars
	lista_reci = [re.sub('\W+', '', x) for x in (" ".join([x for x in ulaz.read().splitlines()]).split())]
	#print lista_reci
	mapa_reci = collections.Counter(lista_reci)
	#print mapa_reci
	sortirana_lista_reci = sorted(mapa_reci.items(), key=lambda x: x[1], reverse=True)

while True:
	trazena_rec = raw_input(">> ").lower()
	for x in sortirana_lista_reci:
		if x[0].lower().startswith(trazena_rec):
			print x[0]
			break
