# Data Structures and Algorithms Java

## Sorting Algorithms
- Bubble sort
```
0 to n-1
  0 to n-i-1
    if(a[i]==b[i]
      swap
```
- Selection sort
```
0 to n-1
  min = i // find min
  i+1 to n-1
    if(a[j]<arr[min]
    min = j
  swap a[i], a[min]
```
- Insertion sort
```
1 to n
  temp = a[i]
  j = i-1
  while(j>=0 && arr[j]>temp)
    a[j+1]=a[j]
    j--
  a[j+1]=temp
```
- Merge sort
- Quick sort

## Searching Algorithms
- Binary Search
```
n=a.length
start=0
end=n-1
while(start<=end)
mid=start+(end-start)/2
  if(a[mid]==k)
    return mid
  else if(a[mid]>k)
    start=mid-1
  else
    end=a[mid]+1
```
- Linear Search
```
for 0 to n
  if(ar[i]==k)
    return i
```

## Array

## Linked List
  ### Singly Linked List
  - Insertion(By Index, By value), Delete(By Index, By Value), Search, Reverse
