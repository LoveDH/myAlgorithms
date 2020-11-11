# 분할정복식 방법 -> 중복 호출이 많음
def bin(n,k):
    if k==0 or n==k:
        return 1
    else:
        return bin(n-1, k-1) + bin(n-1,k)

# 동적계획식 방법
def bin2(n,k):
    B = [[0 for _ in range(k+1)] for _ in range(n+1)] # 빈 배열 선언

    for i in range(0,n+1):
        for j in range(0,min(i,k)+1):
            if j==0 or j==i:
                B[i][j] = 1
            else:
                B[i][j] = B[i-1][j-1] + B[i-1][j]
    return B[n][k]

print(bin(10,5), bin2(10,5))