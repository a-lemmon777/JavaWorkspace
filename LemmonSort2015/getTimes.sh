#!/bin/bash

cd /tmp/Sorting
> times.txt
UNSORTED=(Unsorted_25k.txt Unsorted_500k.txt)
SORTED=(Sorted_25k.txt Sorted_500k.txt)

for j in "${!UNSORTED[@]}"
do
cmd="taskset -c 0 java Group0 ${UNSORTED[$j]} output.txt"; for i in $(seq 5); do ($cmd | ([ $i -lt 5 ] && tr '\n' '\t' || tr '\n' '\n') >> times.txt); sleep 1; done
diff -q -s output.txt ${SORTED[$j]}
done
