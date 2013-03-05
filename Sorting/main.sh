#!/bin/bash

sh collect.sh ExchangeSort e_log.txt e_counts.txt e_times.txt e_avgcounts.txt e_avgtimes.txt
sh collect.sh InsertionSort i_log.txt i_counts.txt i_times.txt i_avgcounts.txt i_avgtimes.txt
sh collect.sh MergeSort m_log.txt m_counts.txt m_times.txt m_avgcounts.txt m_avgtimes.txt
sh collect.sh QuickSort q_log.txt q_counts.txt q_times.txt q_avgcounts.txt q_avgtimes.txt