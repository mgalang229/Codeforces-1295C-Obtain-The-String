# Codeforces-1295C-Obtain-The-String
Link: https://codeforces.com/problemset/problem/1295/C
## Analysis
```

operation allowed:
- append any subsequence of string s at the end of string z

goal:
- string z turned to string t
- min no. of operations
- don't forget the impossible case (-1)

---------------------

1
aabce
ace

ans: 1

---------------------

1
abacaba
aax

no letter 'x'

it's only impossible if a letter in string t
does not exist in string s

ans: -1

---------------------

1
ty
yyt

y -> y -> t

every letter in string s can be reused

ans: 3

---------------------

1
inkoqhhkgugkwlf
lfghkouwf

lf -> g -> hk -> ouwf

1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
i n k o q h h k g  u  g  k  w  l  f

we can store the previous indices and 
compare it to the indices of the current character

sorted indices list
binary search the current index (greater than)

find the character closest to index 0

ArrayList<Integer>[] 

(greedy approach)
l = 14
14 < 15
f = 15

find prev < indices[t[i]-'a'][mid] and 
prev >= indices[t[i]-'a'][mid-1] (assuming mid-1 >= 0)

15 > 9
g = 9 11

9 > 7
h = 6 7
6 < 8
k = 3 8 12

8 > 4

o = 4
4 < 10
u = 10
10 < 13
w = 13
13 < 15
f = 15

the approach lies on the indices

ans: 4
```
