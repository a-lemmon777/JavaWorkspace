#!/bin/bash

# The name of the main class, including .java
javaMain=$1
projectSource=/home/lemmo031/JavaWorkspace/LemmonSort2015/src
javac -cp /home/lemmo031/JavaWorkspace/LemmonSort2015/src/ /home/lemmo031/JavaWorkspace/LemmonSort2015/src/TimSort.java -d /tmp/Sorting/
cd /tmp/Sorting
> times.txt
UNSORTED=(Unsorted_25k.txt)
SORTED=(Sorted_25k.txt)

for j in "${!UNSORTED[@]}"
do
cmd="taskset -c 0 java $1 ${UNSORTED[$j]} output.txt"; for i in $(seq 5); do ($cmd | ([ $i -lt 5 ] && tr '\n' '\t' || tr '\n' '\n') >> times.txt); sleep 1; done
diff -q -s output.txt ${SORTED[$j]}
done
