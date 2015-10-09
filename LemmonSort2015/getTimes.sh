#!/bin/bash

cd /tmp/Sorting
> times.txt
cmd="taskset -c 0 java Group0 Unsorted_500k.txt output.txt >> times.txt"; for i in $(seq 5); do $cmd; sleep 1; done
#cmd="taskset -c 0 java Group0 Unsorted_4M.txt output.txt"; for i in $(seq 5); do $cmd; sleep 1; done
#cmd="taskset -c 0 java Group0 Unsorted_4M.txt output.txt"; for i in $(seq 5); do $cmd; sleep 1; done
#cmd="taskset -c 0 java Group0 Unsorted_4M.txt output.txt"; for i in $(seq 5); do $cmd; sleep 1; done
#cmd="taskset -c 0 java Group0 Unsorted_4M.txt output.txt"; for i in $(seq 5); do $cmd; sleep 1; done

