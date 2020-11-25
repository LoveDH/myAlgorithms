import queue

class Node:
    def __init__(self,level=-1,weight=0, profit=0, include=[]):
        self.level = level
        self.weight = weight
        self.profit = profit
        self.include = include

def kp_BFS():
    global maxProfit, bestset
        
    q = queue.Queue()
    v = Node()
    q.put(v)

    while q.empty() != True:
        v = q.get()
        u = Node()

        #alpha
        u.level = v.level + 1
        u.weight = v.weight + w[u.level]
        u.profit = v.profit + p[u.level]
        u.include = v.include[:] + [1]
        if u.weight <= W and u.profit > maxProfit:
            maxProfit = u.profit
            bestset = u.include[:]
        if compBound(u) > maxProfit:
            q.put(u)

        #not alpha
        u = Node()
        u.level = v.level + 1
        u.weight = v.weight
        u.profit = v.profit
        u.include = v.include[:] + [0]
        if compBound(u) > maxProfit:
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
n=4
W=16
p=[40,30,50,10]
w=[2,5,10,5]
include=[0]*n
maxProfit =0
bestset=n*[0]
kp_BFS()
print(bestset)
