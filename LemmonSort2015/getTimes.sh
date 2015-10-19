#!/bin/bash

javaMain=$1 # The path of the main class, including .java extension
resultFileSuffix=$2 # Allows user to have a unique output file for each run
mainFileName=$(basename $javaMain .java) # The name of the main class, without .java extension
resultFile="${mainFileName}_${resultFileSuffix}.txt"
project=/home/lemmo031/JavaWorkspace/LemmonSort2015
destination=/tmp/Sorting/
dataDestination=DataFiles
dataDirectory=/home/lemmo031/JavaWorkspace/LemmonSort2015/DataFiles # It's important that this has no trailing slash
source=src
timeFile=times.txt
validityFile=validity.txt
outputFile=output.txt

rsync -r -u $dataDirectory $destination # only copies data files if they have been updated
javac -cp $project/$source $javaMain -d $destination
cd $destination
> $timeFile # clear results file
> $validityFile # clear validity file
UNSORTED=(Unsorted_500k.txt Unsorted_700k.txt Unsorted_1M.txt Unsorted_2M.txt Unsorted_3M.txt Unsorted_4M.txt Unsorted_5M.txt)
SORTED=(Sorted_500k.txt Sorted_700k.txt Sorted_1M.txt Sorted_2M.txt Sorted_3M.txt Sorted_4M.txt Sorted_5M.txt)
#UNSORTED=(Unsorted_25k.txt)
#SORTED=(Sorted_25k.txt)

for j in "${!UNSORTED[@]}"; do
	echo "starting ${UNSORTED[$j]}"
	cmd="taskset -c 0 java $mainFileName $dataDestination/${UNSORTED[$j]} $outputFile"
		for i in $(seq 5); do
			echo "on trial $i"
			$cmd | ([ $i -lt 5 ] && tr '\n' '\t' || tr '\n' '\n') >> $timeFile
			sleep 1
		done
	diff -q -s $outputFile $dataDestination/${SORTED[$j]} >> $validityFile
	echo "done with ${UNSORTED[$j]}"
done

cat $timeFile $validityFile > $resultFile
cp $resultFile $project/Times
rm $resultFile
