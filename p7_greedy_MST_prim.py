import utility

inf = 1000 # Edge가 없는 곳
w = [[0, 1, 3, inf, inf], # Edge matrix
    [1, 0, 3, 6, inf],
    [3, 3, 0, 4, 2],
    [inf, 6, 4, 0, 5],
    [inf, inf, 2, 5, 0]]

F = set()
utility.printMatrix(w)
n = len(w)
nearest = n*[0]
distance = n*[0]
for i in range(1, n): # 가장 가까운 노드와 거리를 노드1로 초기화
    nearest[i] = 0
    distance[i] = w[0][i]

for _ in range(n-1):    # n-1번 반복 (한번에 하나의 노드 연결)
    min = inf
    for i in range(1,n):    # 거리가 가장 가까운 노드 선정
        if distance[i] >= 0 and distance[i] < min: 
            min = distance[i]
            vnear = i
    e = (vnear, nearest[vnear]) # 해당 edge 정보
    F.add(e)                    # F에 추가
    distance[vnear] = -1        # vnear노드는 이제 고려할 필요가 없으므로 -1로 설정함
    for i in range(1, n):       # 나머지 노드들에 대해 업데이트
        if w[i][vnear] < distance[i]:
            distance[i] = w[i][vnear]
            nearest[i] = vnear
print()
print(F)