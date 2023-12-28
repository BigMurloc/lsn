# LSN tasks solutions

## How to run

The app expects to be provided with one of the flags (`task1`, `task2`, `task3`) to run appropriate task.  

Linux:  `mvn exec:java -Dexec.args="task1"`  
Windows: `mvn exec:java -D"exec.args"="task1"`
---
## Task 1

### The problem

The output of this app should be a list of distinct integers with basic measurement information about:
- number of elements in the source
- number of distinct elements
- min value
- max value

### The solution

For readability and preference reasons I decided to use Java Streams API.  

#### Sorting
The underlying algorithm for sorting integers is quite advanced `DualPivotQuicksort` which offers O(n log(n)) performance and O(n) memory complexity.

#### Distinct elements
Chaining `sorted().distinct()` offers O(1) memory complexity since the underlying `distinct()` does not need to build a HashSet.  
If there were lots of duplicated elements it would be considerable to reverse the order so the sorting algorithm would only receive distinct elements.

#### Min and max
Since the distinct elements are sorted in ascending order the first element is **min** and the last element is **max**.  
In this case the implementation of underlying `List` is `ArrayList` so the `get()` takes O(1) in terms of performance.

#### Overall time and memory complexity

Time complexity: O(n log(n))  
Memory complexity: O(n)
---
## Task 2

## Task 3