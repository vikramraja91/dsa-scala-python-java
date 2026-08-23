# Scala DSA — 

Sorting algorithm implementations in Scala,
## Algorithms

| Algorithm | Time (avg / worst) | Space | Stable | In-place |
|---|---|---|---|---|
| Bubble Sort | O(n²) / O(n²) | O(1) | Yes | Yes |
| Merge Sort | O(n log n) / O(n log n) | O(n) | Yes | No |
| Quick Sort | O(n log n) / O(n²) | O(log n) | No | Yes |

> Add a row here for every new algorithm.

## Notes

- **Bubble Sort** — early exit when a pass makes no swaps. Teaching only, not used in practice.
- **Merge Sort** — pure function, returns a new list. Use when stability or guaranteed O(n log n) matters.
- **Quick Sort** — last-element pivot (Lomuto). Worst case O(n²) on sorted/reverse-sorted input; fix with random or median-of-3 pivot.

## Running tests

```bash
mvn test
```