import queue

class Node:
    def __init__(self,level=-1,weight=0, profit=0, bound=0.0, include=[]):
        self.level = level
        self.weight = weight
        self.profit = profit
        self.bound = bound
        self.include = include
    def __lt__(self, other):
        return cmp(self.bound, other.bound)

def cmp(a,b):
    return a>b

def kp_Best_FS():
    global maxProfit, bestset
    v = Node()
    q = queue.PriorityQueue()

    v.bound = compBound(v)
    q.put(v)

    while q.empty() != True:
        v = q.get()
        if v.bound > maxProfit:
            u = Node()
            u.level = v.level + 1
            u.weight = v.weight + w[u.level]
            u.profit = v.profit + p[u.level]
            u.include = v.include[:] + [1]
            if u.weight <= W and u.profit > maxProfit:
                maxProfit = u.profit
                bestset = u.include[:]
            u.bound = compBound(u)
            if u.bound > maxProfit :
                q.put(u)
            
            u = Node()
            u.level = v.level + 1
            u.weight = v.weight
            u.profit = v.profit
            u.include = v.include[:] + [0]
            u.bound = compBound(u)
            if u.bound > maxProfit:
                q.put(u)

def compBound(u):
    if u.weight >= W:
        return 0
    else:
        result = u.profit
        j = u.level+1
        totweight = u.weight
        while j<n and (totweight + w[j]) <= W:
            totweight = totweight + w[j]
            result = result + p[j]
            j+=1
        k=j
        if k<n:
            result = result + (W-totweight)*p[k]/w[k]
        return result


# heap이 minheap이라 bound를 계산하여 -를 하여 리턴한다. 비교를 < maxProfit으로 수행한다.
n=4
W=16
p=[40,30,50,10]
w=[2,5,10,5]
include=[0]*n
maxProfit =0
bestset=n*[0]
kp_Best_FS()
print(bestset)
print(maxProfit)
