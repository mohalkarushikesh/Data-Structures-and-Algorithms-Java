## Sorting Algorithms

- Merge sort
```
mergeSort(a, l, r)
  if(l < r)
    mid = (l+r)/2
    mergeSort(a, l, mid)
    mergeSort(a, mid+1, r)
    merge(a, l, mid, r)

merge(a, l, mid, r)
  copy a[l..mid] -> L[], a[mid+1..r] -> R[]
  i=0, j=0, k=l
  while(i<L.len && j<R.len)
    if(L[i] <= R[j]) a[k++] = L[i++]
    else             a[k++] = R[j++]
  copy leftover L[] then leftover R[]
```

- Quick sort
```
quickSort(a, low, high)
  if(low < high)
    p = partition(a, low, high)
    quickSort(a, low, p-1)
    quickSort(a, p+1, high)

partition(a, low, high)
  pivot = a[high]
  i = low-1
  for j = low to high-1
    if(a[j] < pivot)
      i++
      swap a[i], a[j]
  swap a[i+1], a[high]
  return i+1
```

## Array

- Insert at end
```
if(size==cap) full; return
a[size]=val
size++
```

- Insert by index
```
if(idx<0 || idx>size) invalid; return
for j=size down to idx+1  a[j]=a[j-1]   // shift right
a[idx]=val
size++
```

- Delete by index
```
if(idx<0 || idx>=size) invalid; return
for j=idx to size-2  a[j]=a[j+1]        // shift left
size--
```

- Delete by value
```
idx = search(val)
if(idx==-1) return
for j=idx to size-2  a[j]=a[j+1]
size--
```

- Search (by value)
```
for i=0 to size-1
  if(a[i]==val) return i
return -1
```

- Reverse
```
i=0, j=size-1
while(i<j)
  swap a[i], a[j]
  i++; j--
```

- Rotate left by k
```
k = k % size
reverse(a, 0, k-1)
reverse(a, k, size-1)
reverse(a, 0, size-1)
```

## Linked List

### Singly Linked List

- Insert by value (at end)
```
node = new(val)
if(head==null) head=node; return
temp=head
while(temp.next!=null) temp=temp.next
temp.next=node
```

- Insert by index
```
if(idx==0) node.next=head; head=node; return
temp=head
for 0 to idx-2  temp=temp.next   // stop at prev
node.next=temp.next
temp.next=node
```

- Delete by value
```
if(head.val==val) head=head.next; return
temp=head
while(temp.next!=null && temp.next.val!=val) temp=temp.next
if(temp.next!=null) temp.next=temp.next.next
```

- Delete by index
```
if(idx==0) head=head.next; return
temp=head
for 0 to idx-2  temp=temp.next   // stop at prev
temp.next=temp.next.next
```

- Search (by value)
```
temp=head, i=0
while(temp!=null)
  if(temp.val==k) return i
  temp=temp.next; i++
return -1
```

- Reverse
```
prev=null, curr=head
while(curr!=null)
  next=curr.next
  curr.next=prev
  prev=curr
  curr=next
head=prev
```

## Linked List

### Doubly Linked List

- Insert at end
```
node = new(val)
if(head==null) head=node; return
temp=head
while(temp.next!=null) temp=temp.next
temp.next=node
node.prev=temp
```

- Insert by index
```
if(idx==0) node.next=head; if(head!=null) head.prev=node; head=node; return
temp=head
for 0 to idx-1  temp=temp.next          // stop at target pos prev
node.next=temp.next
node.prev=temp
if(temp.next!=null) temp.next.prev=node
temp.next=node
```

- Delete by value
```
temp=head
while(temp!=null && temp.val!=val) temp=temp.next
if(temp==null) return
if(temp.prev!=null) temp.prev.next=temp.next
else head=temp.next
if(temp.next!=null) temp.next.prev=temp.prev
```

- Delete by index
```
temp=head
for 0 to idx-1  temp=temp.next           // reach node
if(temp.prev!=null) temp.prev.next=temp.next
else head=temp.next
if(temp.next!=null) temp.next.prev=temp.prev
```

- Search (by value)
```
temp=head, i=0
while(temp!=null)
  if(temp.val==k) return i
  temp=temp.next; i++
return -1
```

- Reverse
```
curr=head, temp=null
while(curr!=null)
  temp=curr.prev
  curr.prev=curr.next
  curr.next=temp
  curr=curr.prev
if(temp!=null) head=temp.prev
```

### Circular Linked List (singly, tail-based)

- Insert at end
```
node = new(val)
if(tail==null) tail=node; node.next=node; return   // points to self
node.next=tail.next        // new -> head
tail.next=node             // old tail -> new
tail=node
```

- Insert at front
```
node = new(val)
if(tail==null) tail=node; node.next=node; return
node.next=tail.next
tail.next=node             // don't move tail
```

- Delete by value
```
if(tail==null) return
curr=tail.next, prev=tail
do
  if(curr.val==val)
    if(curr==tail && curr.next==curr) tail=null      // only node
    else
      prev.next=curr.next
      if(curr==tail) tail=prev
    return
  prev=curr; curr=curr.next
while(curr!=tail.next)
```

- Search (by value)
```
if(tail==null) return -1
curr=tail.next, i=0
do
  if(curr.val==k) return i
  curr=curr.next; i++
while(curr!=tail.next)
return -1
```

- Traverse
```
if(tail==null) return
curr=tail.next
do
  print curr.val
  curr=curr.next
while(curr!=tail.next)
```

## Stack

- Array-based
```
push(val)
  if(top==cap-1) full; return
  a[++top]=val

pop()
  if(top==-1) empty; return
  return a[top--]

peek()
  if(top==-1) empty; return
  return a[top]

isEmpty()  return top==-1
```

- Linked-list based
```
push(val)
  node=new(val); node.next=top; top=node

pop()
  if(top==null) empty; return
  v=top.val; top=top.next; return v

peek()  return top.val
```

## Queue

- Linear (array)
```
enqueue(val)
  if(rear==cap-1) full; return
  a[++rear]=val
  if(front==-1) front=0

dequeue()
  if(front==-1 || front>rear) empty; return
  return a[front++]

peek()  return a[front]
```

- Circular (array)
```
enqueue(val)
  if((rear+1)%cap==front) full; return
  if(front==-1) front=0
  rear=(rear+1)%cap
  a[rear]=val

dequeue()
  if(front==-1) empty; return
  v=a[front]
  if(front==rear) front=rear=-1        // last element
  else front=(front+1)%cap
  return v
```

- Linked-list based
```
enqueue(val)
  node=new(val)
  if(rear==null) front=rear=node; return
  rear.next=node; rear=node

dequeue()
  if(front==null) empty; return
  v=front.val; front=front.next
  if(front==null) rear=null
  return v
```

## Tree (Binary Search Tree)

- Insert
```
insert(root, val)
  if(root==null) return new(val)
  if(val < root.val) root.left = insert(root.left, val)
  else if(val > root.val) root.right = insert(root.right, val)
  return root
```

- Search
```
search(root, k)
  if(root==null) return false
  if(root.val==k) return true
  if(k < root.val) return search(root.left, k)
  else return search(root.right, k)
```

- Delete
```
delete(root, val)
  if(root==null) return null
  if(val < root.val) root.left = delete(root.left, val)
  else if(val > root.val) root.right = delete(root.right, val)
  else                               // found
    if(root.left==null) return root.right
    if(root.right==null) return root.left
    succ = min(root.right)           // inorder successor
    root.val = succ.val
    root.right = delete(root.right, succ.val)
  return root

min(node)  while(node.left!=null) node=node.left; return node
```

- Traversals
```
inorder(root)    // L Root R -> sorted
  if(root==null) return
  inorder(root.left); print root.val; inorder(root.right)

preorder(root)   // Root L R
  if(root==null) return
  print root.val; preorder(root.left); preorder(root.right)

postorder(root)  // L R Root
  if(root==null) return
  postorder(root.left); postorder(root.right); print root.val

levelorder(root) // BFS, uses queue
  if(root==null) return
  q.add(root)
  while(!q.empty)
    node=q.poll(); print node.val
    if(node.left!=null) q.add(node.left)
    if(node.right!=null) q.add(node.right)
```

- Height
```
height(root)
  if(root==null) return 0
  return 1 + max(height(root.left), height(root.right))
```

## Heap (Min-Heap, array-based)

```
// parent=(i-1)/2, left=2i+1, right=2i+2

insert(val)
  a[size]=val; i=size; size++
  while(i>0 && a[(i-1)/2] > a[i])     // heapify up
    swap a[i], a[(i-1)/2]
    i=(i-1)/2

extractMin()
  if(size==0) empty; return
  min=a[0]
  a[0]=a[--size]
  heapifyDown(0)
  return min

heapifyDown(i)
  while(true)
    l=2i+1, r=2i+2, small=i
    if(l<size && a[l]<a[small]) small=l
    if(r<size && a[r]<a[small]) small=r
    if(small==i) break
    swap a[i], a[small]; i=small
```

## Graph (adjacency list)

- BFS
```
bfs(start)
  visited[] = false
  q.add(start); visited[start]=true
  while(!q.empty)
    node=q.poll(); print node
    for nb in adj[node]
      if(!visited[nb]) visited[nb]=true; q.add(nb)
```

- DFS (recursive)
```
dfs(node, visited)
  visited[node]=true; print node
  for nb in adj[node]
    if(!visited[nb]) dfs(nb, visited)
```

- DFS (iterative, stack)
```
dfs(start)
  st.push(start)
  while(!st.empty)
    node=st.pop()
    if(!visited[node])
      visited[node]=true; print node
      for nb in adj[node]
        if(!visited[nb]) st.push(nb)
```

## Hashing (chaining)

```
hash(key)  return key % capacity

put(key, val)
  idx = hash(key)
  for node in bucket[idx]
    if(node.key==key) node.val=val; return   // update
  bucket[idx].add(new(key, val))              // insert at head

get(key)
  idx = hash(key)
  for node in bucket[idx]
    if(node.key==key) return node.val
  return -1

remove(key)
  idx = hash(key)
  remove node with node.key==key from bucket[idx]
```

- Linear probing (open addressing)
```
put(key, val)
  idx = hash(key)
  while(a[idx]!=null && a[idx].key!=key)
    idx=(idx+1)%capacity
  a[idx]=new(key, val)

get(key)
  idx = hash(key)
  while(a[idx]!=null)
    if(a[idx].key==key) return a[idx].val
    idx=(idx+1)%capacity
  return -1
```

## Complexity Cheat-Sheet

- Sorting
```
Bubble        Best O(n)     Avg/Worst O(n^2)     Space O(1)   stable
Selection     All O(n^2)                         Space O(1)   not stable
Insertion     Best O(n)     Avg/Worst O(n^2)     Space O(1)   stable
Merge         All O(n log n)                     Space O(n)   stable
Quick         Best/Avg O(n log n)  Worst O(n^2)  Space O(log n) not stable
Heap          All O(n log n)                     Space O(1)   not stable
```

- Searching
```
Linear        O(n)
Binary        O(log n)     (sorted array only)
```

- Data structures (avg)
```
                Access   Search   Insert   Delete
Array           O(1)     O(n)     O(n)     O(n)
Linked List     O(n)     O(n)     O(1)*    O(1)*     (*at known node/head)
Stack/Queue     O(n)     O(n)     O(1)     O(1)
BST (balanced)  O(log n) O(log n) O(log n) O(log n)  (worst O(n) if skewed)
Heap            O(1)peek O(n)     O(log n) O(log n)
Hash Table      -        O(1)     O(1)     O(1)      (worst O(n) on collisions)
```

- Graph (V vertices, E edges)
```
BFS / DFS     O(V + E)      Space O(V)
Dijkstra      O((V+E) log V) with min-heap
Prim          O((V+E) log V) with min-heap
```

## Recursion Basics

```
// every recursion needs: base case + recursive call moving toward base

factorial(n)
  if(n<=1) return 1
  return n * factorial(n-1)

fibonacci(n)
  if(n<=1) return n
  return fib(n-1) + fib(n-2)

power(x, n)
  if(n==0) return 1
  return x * power(x, n-1)
```

## Two-Pointer

- Pair sum (sorted array)
```
i=0, j=n-1
while(i<j)
  sum = a[i]+a[j]
  if(sum==target) return (i, j)
  else if(sum < target) i++
  else j--
return none
```

- Remove duplicates (sorted, in place)
```
if(n==0) return 0
k=0                       // slow pointer
for i=1 to n-1            // fast pointer
  if(a[i]!=a[k]) k++; a[k]=a[i]
return k+1                // new length
```

## Sliding Window

- Max sum of subarray size k
```
sum=0
for i=0 to k-1  sum+=a[i]
best=sum
for i=k to n-1
  sum += a[i] - a[i-k]    // slide: add new, drop old
  best = max(best, sum)
return best
```

## Dijkstra (shortest path, min-heap)

```
dist[] = infinity; dist[src]=0
pq.add((0, src))                       // (distance, node)
while(!pq.empty)
  (d, u) = pq.poll()
  if(d > dist[u]) continue             // stale
  for (v, w) in adj[u]                 // w = edge weight
    if(dist[u]+w < dist[v])
      dist[v] = dist[u]+w
      pq.add((dist[v], v))
return dist
```

## Prim (min spanning tree, min-heap)

```
inMST[] = false
pq.add((0, src))                       // (weight, node)
cost=0
while(!pq.empty)
  (w, u) = pq.poll()
  if(inMST[u]) continue
  inMST[u]=true; cost+=w
  for (v, wt) in adj[u]
    if(!inMST[v]) pq.add((wt, v))
return cost
```

## Backtracking

- Subsets (all combinations)
```
subsets(a, idx, curr)
  if(idx==n) print curr; return
  curr.add(a[idx])              // include
  subsets(a, idx+1, curr)
  curr.remove(last)             // exclude (backtrack)
  subsets(a, idx+1, curr)
```

- Permutations
```
permute(a, start)
  if(start==n) print a; return
  for i=start to n-1
    swap a[start], a[i]
    permute(a, start+1)
    swap a[start], a[i]         // backtrack
```

- N-Queens
```
solve(board, row)
  if(row==n) print board; return
  for col=0 to n-1
    if(isSafe(board, row, col))
      board[row][col]=Q
      solve(board, row+1)
      board[row][col]=.         // backtrack

isSafe(board, row, col)
  check column above
  check upper-left diagonal
  check upper-right diagonal
  return true if all clear
```

## Dynamic Programming

- 0/1 Knapsack
```
// wt[], val[], W capacity, n items
knapsack()
  dp[n+1][W+1] = 0
  for i=1 to n
    for w=0 to W
      if(wt[i-1] <= w)
        dp[i][w] = max(val[i-1] + dp[i-1][w - wt[i-1]],  // take
                       dp[i-1][w])                        // skip
      else
        dp[i][w] = dp[i-1][w]
  return dp[n][W]
```

- Longest Common Subsequence
```
// strings s1 (len m), s2 (len n)
lcs()
  dp[m+1][n+1] = 0
  for i=1 to m
    for j=1 to n
      if(s1[i-1]==s2[j-1]) dp[i][j] = 1 + dp[i-1][j-1]
      else                 dp[i][j] = max(dp[i-1][j], dp[i][j-1])
  return dp[m][n]
```

- Fibonacci (memoized)
```
fib(n, memo)
  if(n<=1) return n
  if(memo[n]!=-1) return memo[n]
  memo[n] = fib(n-1, memo) + fib(n-2, memo)
  return memo[n]
```

## Union-Find (Disjoint Set)

```
parent[i]=i, rank[i]=0        // init: each node own parent

find(x)                        // with path compression
  if(parent[x]!=x) parent[x]=find(parent[x])
  return parent[x]

union(x, y)                    // by rank
  rx=find(x), ry=find(y)
  if(rx==ry) return false      // already connected (cycle)
  if(rank[rx]<rank[ry]) parent[rx]=ry
  else if(rank[rx]>rank[ry]) parent[ry]=rx
  else parent[ry]=rx; rank[rx]++
  return true
```

## Kruskal (min spanning tree)

```
// edges = list of (weight, u, v)
kruskal()
  sort edges by weight
  init Union-Find
  cost=0
  for (w, u, v) in edges
    if(union(u, v))            // no cycle -> add edge
      cost += w
  return cost
```

