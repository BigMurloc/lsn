# LSN tasks solutions

## How to run

The app expects to be provided with one of the flags (`task1`, `task2`, `task3`) to run appropriate task.  

---
## Task 1

Linux: `mvn exec:java -Dexec.args="task1"`  
Windows: `mvn exec:java -D"exec.args"="task1"`

### The problem

The output of this app should be a list of distinct integers with basic measurement information about:
- number of elements in the source
- number of distinct elements
- min value
- max value

### The solution

For readability and preference reasons I decided to use Java Streams API.  

#### Sorting
The underlying algorithm for sorting integers is quite advanced `DualPivotQuicksort` which offers O(n log(n)) performance and O(log(n)) memory complexity.

#### Distinct elements
Chaining `sorted().distinct()` offers O(1) memory complexity since the underlying `distinct()` does not need to build a HashSet.  
If there were lots of duplicated elements it would be considerable to reverse the order so the sorting algorithm would only receive distinct elements.

#### Min and max
Since the distinct elements are sorted in ascending order the first element is **min** and the last element is **max**.  
In this case the implementation of underlying `List` is `ArrayList` so the `get()` takes O(1) in terms of performance.

#### Overall time and memory complexity

Time complexity: O(n log(n))  
Memory complexity: O(log (n))
---
## Task 2

Linux: `mvn exec:java -Dexec.args="task2"`   
Windows: `mvn exec:java -D"exec.args"="task2"`

### The problem

The output of this app should be a list of pairs making up to a target sum sorted in ascending order.  
If there are duplicated numbers e.g. `[1, 1, 2, 2]` and a target sum `3` the output should be 4 pairs `[(1,2), (1,2), (1,2), (1,2)]`  
The target sum should be a `odd` number, so the input `[1, 1, 1]` with a target sum `2` is invalid.

### The solution

For readability and preference reasons I decided to use Java Streams API.  
I treat each pair uniquely as object which affects time performance due to the need to generate combinations.  
This could be tweaked if each of the pairs would only store an information about how many of such pairs exist.  

#### Precomputing values
So in order to generate combinations we need the information about how many of such pairs exist in the first place. 
Imagine we have two sets `A` and `B` with `m` and `n` elements correspondingly.  
The amount of possible pairs is `m * n`.

The algorithm goes over all numbers, finds complementary numbers and stores them in a HashMap.  
The formula for complementary number is `complement = sum - current_value`

However, there is an edge case if we wanted to generate pairs from the same set.  
If we had a set `A` with `n` elements in it, the `n * n` would generate pairs containing exactly the same elements.  
Since the target sum is `odd` this edge case does not apply, but for the future reference the correct formula is `n * (n - 1)` 

This step is O(n) in both time and memory complexity. 

#### Filtering non-complementary values & mapping to Pair object
After precomputing values the first step is to filter out numbers that are not part of the solution (i.e. a number that is not a part of the resulting pairs).  
To filter out non-complementary values we look at the precomputed `Map` to see if it contains the `complement`.  

Then each of the number that passed the filter is mapped to a `Pair` object containing both numbers that add up to the `target sum`.  
This creates a duplicated pairs which is the reason why later on in the pipe we call `distinct()`.  

#### Sorting and eliminating duplicates
The output list should be sorted in ascending order. To achieve that we sort `Pairs` by looking at its smaller number.  
At this point the list contains duplicated pairs, so we also call `distinct()` leveraging chaining mechanism with cost of O(1) memory.

This step takes O(p log(p)) in terms of time complexity and O(log (p)) in terms of memory complexity where p - pair. 

#### Generating combinations
We have a list of distinctly sorted pairs in ascending order, now we need to generate combinations based on logic explained in the **Precomputed values** section

This step takes O(p * total_occurrence) in terms of time complexity

#### Summary
Time complexity: O(n + p * (log(p) + total_occurrence))  
Memory complexity: O(n + log(p))
## Task 3

Linux: `mvn exec:java -Dexec.args="task3"`  
Windows: `mvn exec:java -D"exec.args"="task3"`

### The problem

Given a list of integers that make up a graph - find the number of components.

The first number in array is a single vertex, the remaining pairs are the connections between vertices.  
Example: `1 2 3 3 4 5 6` translates to graph of: `[1 2-3-4 5-6]` with `3` components.

### The solution

As far as I know the core java does not have implantation of a graph, nor does it have graph traversal algorithms like BFS or DFS.  
This is why I decided to use `JGraphT` library which as both.  
Additionally it has a `ConnectivityInspector` class which has method `connectedSets()` and the size of these sets is the answer to the given problem.  
However, it has greater memory usage hence the custom implementation.

The idea is very simple: 

1. We create graph of given vertices
2. Once we have the graph, we traverse all vertices in it and check whether the vertex is marked as seen or not
3. If the vertex was not seen we increment the number of components and perform DFS on this vertex, marking all visited vertices in the process (but not incrementing the counter)
4. Once the DFS is done, we traverse remaining vertices and repeat the process for every vertex that was not marked by DFS

The result of this algorithm is a number of components.