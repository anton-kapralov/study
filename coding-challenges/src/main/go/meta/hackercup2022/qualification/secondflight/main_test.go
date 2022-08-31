package main

import (
	"github.com/google/go-cmp/cmp"
	"strconv"
	"testing"
)

func Test(t *testing.T) {
	tests := []struct {
		flights map[int]map[int]int
		queries [][2]int
		want    []int64
	}{
		{
			flights: map[int]map[int]int{
				1: {
					2: 10,
					3: 5,
				},
				2: {
					1: 10,
					3: 15,
					4: 10,
				},
				3: {
					1: 5,
					2: 15,
					4: 7,
				},
				4: {
					2: 10,
					3: 7,
				},
			},
			queries: [][2]int{
				{1, 2},
				{1, 3},
				{2, 3},
				{2, 4},
				{3, 4},
				{4, 1},
			},
			want: []int64{25, 20, 42, 27, 24, 15},
		},
	}
	for i, tt := range tests {
		t.Run(strconv.Itoa(i), func(t *testing.T) {
			result := solve(tt.flights, tt.queries)
			if diff := cmp.Diff(result, tt.want); len(diff) > 0 {
				t.Fatal(diff)
			}
		})
	}
}
