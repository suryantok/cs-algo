##Search

### Sequential Search
* check array entry 0,1,2,3,... for match with search string
* if match found, retur index of matching string
* if not, return -1

### Binary Search
* Keep the array in sorted order
* Examine the middle key
* If matches return the index
* if it is larger, search the half with lower indices
* if it is smaller, search the half with higher indices

Notation a[lo, hi) => lo <= a < hi


### Mergesort Algorithm
* Divided array into two half
* recursively sort each half
* merge two halves to make sorted whole
