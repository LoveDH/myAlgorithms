def promising(i, col):
    k=0
    switch = True
    while k<i and switch:
        if col[i] == col[k] or abs(col[i]-col[k]) == i-k:
            switch = False
        k+=1
    return switch


def queens(n, i, col):
    if promising(i,col):
        if i==(n-1):
            print(col)
        else:
            for j in range(n):
                col[i+1] = j
                queens(n, i+1, col)

n = 5
col = n*[0]
queens(n, -1, col)