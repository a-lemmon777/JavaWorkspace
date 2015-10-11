#!/bin/bash

javaMain=$1 # The path of the main class, including .java extension
mainFileName=$(basename $javaMain .java) # The name of the main class, without .java extension
project=/home/lemmo031/JavaWorkspace/LemmonSort2015
destination=$project/bin
source=src
outputFile=$project/output.txt
dataFilePath=$project/DataFiles

javac -cp $project/$source $javaMain -d $destination
cd $destination
UNSORTED=(Unsorted_500k.txt Unsorted_2M.txt Unsorted_5M.txt)
SORTED=(Sorted_500k.txt Sorted_2M.txt Sorted_5M.txt)
for j in "${!UNSORTED[@]}"; do
	echo "starting ${UNSORTED[$j]}"
	cmd="taskset -c 0 java $mainFileName $dataFilePath/${UNSORTED[$j]} $outputFile"
	$cmd
	diff -q -s ../output.txt ../DataFiles/${SORTED[$j]}
done

