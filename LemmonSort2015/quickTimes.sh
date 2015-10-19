#!/bin/bash

javaMain=$1 # The path of the main class, including .java extension
dataFileIndex=$2
mainFileName=$(basename $javaMain .java) # The name of the main class, without .java extension
project=/home/lemmo031/JavaWorkspace/LemmonSort2015
destination=$project/bin
source=src
outputFile=$project/output.txt
dataFilePath=$project/DataFiles

javac -cp $project/$source $javaMain -d $destination
cd $destination
UNSORTED=(Unsorted_25k.txt Unsorted_500k.txt Unsorted_700k.txt Unsorted_1M.txt Unsorted_2M.txt Unsorted_3M.txt Unsorted_4M.txt Unsorted_5M.txt)
SORTED=(Sorted_25k.txt Sorted_500k.txt Sorted_700k.txt Sorted_1M.txt Sorted_2M.txt Sorted_3M.txt Sorted_4M.txt Sorted_5M.txt)
echo "running ${UNSORTED[$dataFileIndex]}"
cmd="taskset -c 0 java $mainFileName $dataFilePath/${UNSORTED[$dataFileIndex]} $outputFile"
	for i in $(seq 5); do
		$cmd
		sleep 1
	done
cd $project
diff -q -s output.txt DataFiles/${SORTED[$dataFileIndex]}


