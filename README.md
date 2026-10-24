# Data Structures & Algorithms Lab (Java)

Lab work from the Data Structures and Algorithms course at SIIT (Year 2, Term 1).
Each lab implements a core data structure or algorithm from scratch in plain Java,
without relying on `java.util` collections, and includes a test program that prints
the result next to the expected answer.

## Labs

| Lab | Topic | What's implemented | Run |
|-----|-------|--------------------|-----|
| [01](Lab01-Recursion_Array) | Recursion & arrays | Recursive alternating sum, digit sum, even sum; fixed-capacity array list (insert/remove at front, back, index); two-pointer pair-sum search | `Recursion`, `Array` |
| [02](Lab02-Sorting_Hashing) | Sorting & hashing | Selection, insertion, merge and quick sort; hash table with division/folding hash functions and linear/quadratic probing (insert, search, delete) | `Sorting`, `HashTable` |
| [03](Lab03-SList) | Singly linked list | Generic linked list: add/remove at first, last and index; in-place reversal; search | `TestList` |
| [04](Lab04-Stack_Queue) | Stacks & queues | Linked-list stack and queue; decimal-to-binary conversion, palindrome check, postfix and prefix expression evaluation, round-robin CPU scheduling simulation | `TestStackQueue` |
| [05](Lab05-BinaryTree) | Binary trees | Height, balance check, inorder/preorder/postorder, depth-first and breadth-first traversal; building an expression tree from an infix expression | `TestBT` |
| [06](Lab06-BinarySearchTree) | Binary search trees | Insert, delete (leaf / one child / two children), search, min/max, closest-value search | `TestBST` |
| [07](Lab07-Heap) | Heaps & priority queues | Array-based max-heap (reheap up/down, heap sort, priority queue) and a min-heap priority queue | `TestHeap`, `TestMinHeap` |
| [08](Lab08-Graph) | Graphs | Weighted directed graph using adjacency lists: insert/delete vertices and edges | `TestGraph` |

Each lab folder is self-contained, so helper classes such as `SList`, `Stack` and
`Queue` are repeated where a later lab builds on them.

## Running a lab

You need JDK 8 or newer. From inside a lab folder:

```bash
javac -d out src/*.java
java -cp out TestBST
```

Swap `TestBST` for the class in the **Run** column. The projects also open
directly in Eclipse or IntelliJ as plain Java projects with `src/` as the source root.
