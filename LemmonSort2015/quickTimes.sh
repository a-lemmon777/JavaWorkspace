#!/bin/bash

javaMain=$1 # The path of the main class, including .java extension
dataFileName=$2
mainFileName=$(basename $javaMain .java) # The name of the main class, without .java extension
project=/home/lemmo031/JavaWorkspace/LemmonSort2015
destination=$project/bin
source=src
outputFile=$project/output.txt
dataFilePath=$project/$dataFileName

javac -cp $project/$source $javaMain -d $destination
cd $destination


cmd="taskset -c 0 java $mainFileName $dataFilePath $outputFile"
	for i in $(seq 5); do
		$cmd
		sleep 1
	done
#diff -q -s $outputFile $dataDestination/${SORTED[$j]} >> $validityFile
#echo "done with ${UNSORTED[$j]}"


