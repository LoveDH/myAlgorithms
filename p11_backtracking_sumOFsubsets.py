# 1
print('=============과제1 결과=============')
def promising(i,weight, total):
    return (weight+total>=W) and (weight == W or weight+w[i+1]<=W)

def s_s(i, weight, total, include):
    if promising(i, weight, total):
        if weight == W:
            print('sol', include)
        else:
            include[i+1] = 1
            s_s(i+1, weight+w[i+1], total-w[i+1], include)
            include[i+1] = 0
            s_s(i+1, weight, total-w[i+1], include)

n=4
w=[1,4,2,6]
W=6
print("items =",w, "W =", W)
include = n*[0]
total=0
for k in w:
    total+=k
s_s(-1,0,total,include)

# 2
print('\n=============과제2 결과=============')
def color(i,vcolor):

    if promising(i,vcolor):
        if (i+1)==n:
            print(vcolor)
        else:
            for clr in range(1,m+1):
                vcolor[i+1] = clr
                color(i+1,vcolor)

def promising(I,vcolor):

    switch = True
    j = 0
    while j<I and switch:
        if  W[I][j] and vcolor[I]==vcolor[j]:
            switch = False
        j+=1
    return switch

n=4
W=[[0,1,1,1],[1,0,1,0],[1,1,0,1],[1,0,1,0]]
vcolor=n*[0]
m=3
color(-1,vcolor)
