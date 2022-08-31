package main

import (
	"bufio"
	"fmt"
	"io"
	"log"
	"os"
	"strconv"
	"time"
)

func main() {
	start := time.Now()
	file, err := os.Open(os.Args[1])
	if err != nil {
		log.Fatal(err)
	}
	defer file.Close()
	var w io.Writer
	if len(os.Args) > 2 {
		w, err = os.Create(os.Args[2])
		if err != nil {
			log.Fatal(err)
		}
	} else {
		w = os.Stdout
	}
	scanner := bufio.NewScanner(file)
	scanner.Split(bufio.ScanWords)
	t := mustScanInt(scanner)
	for i := 1; i <= t; i++ {
		scanAndSolve(i, scanner, w)
	}
	fmt.Printf("%dms\n", time.Now().Sub(start).Milliseconds())
}

func mustScanInt(scanner *bufio.Scanner) int {
	if !scanner.Scan() {
		log.Fatal("Wrong input!")
	}
	i, err := strconv.Atoi(scanner.Text())
	if err != nil {
		log.Fatal(err)
	}
	return i
}

func scanAndSolve(caseNumber int, scanner *bufio.Scanner, w io.Writer) {
	n := mustScanInt(scanner)
	m := mustScanInt(scanner)
	q := mustScanInt(scanner)

	flights := make(map[int]map[int]int, n)
	for i := 0; i < m; i++ {
		a := mustScanInt(scanner)
		b := mustScanInt(scanner)
		c := mustScanInt(scanner)
		aConnections, ok := flights[a]
		if !ok {
			aConnections = make(map[int]int)
			flights[a] = aConnections
		}
		aConnections[b] = c
		bConnections, ok := flights[b]
		if !ok {
			bConnections = make(map[int]int)
			flights[b] = bConnections
		}
		bConnections[a] = c
	}
	queries := make([][2]int, q)
	for i := 0; i < q; i++ {
		queries[i][0] = mustScanInt(scanner)
		queries[i][1] = mustScanInt(scanner)
	}
	result := solve(flights, queries)
	fmt.Fprintf(w, "Case #%d:", caseNumber)
	for _, v := range result {
		fmt.Fprintf(w, " %d", v)
	}
	fmt.Fprintln(w)
}

func solve(flights map[int]map[int]int, queries [][2]int) []int64 {
	result := make([]int64, len(queries))

	for i, query := range queries {
		x := query[0]
		y := query[1]

		for a, c := range flights[x] {
			if a == y {
				result[i] += int64(c) * 2
				continue
			}
			if c2, ok := flights[a][y]; ok {
				result[i] += min(int64(c), int64(c2))
			}
		}
	}

	return result
}

func min(a int64, b int64) int64 {
	if a <= b {
		return a
	} else {
		return b
	}
}
