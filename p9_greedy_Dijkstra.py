inf = 1000
w = [[0, 7, 4, 6, 1],
    [inf, 0, inf, inf, inf],
    [inf, 2, 0, 5, inf],
    [inf, 3, inf, 0, inf],
    [inf, inf, inf, 1, 0]]

n = 5
f = set()
touch = n*[0]
length = n*[0]
save_length = n*[0]     # 각 노드별 최단 거리 저장 리스트

for i in range(1,n):    # 초기화
    length[i] = w[0][i]

for _ in range(n-1):    # n-1번 반복
    min = inf

    for i in range(1,n):    # 가장 가까운 arc 찾기
        if length[i] >= 0 and length[i] < min:
            min = length[i]
            vnear = i

    save_length[vnear] = min    # 최단거리 저장

    e = (touch[vnear], vnear)   # 해당 아크 F에 추가
    f.add(e)

    for i in range(1,n):    # 거리 업데이트
        if length[vnear] + w[vnear][i] < length[i]:
            length[i] = length[vnear] + w[vnear][i]
            touch[i] = vnear

    length[vnear] = -1  # 더이상 고려하지 않음

print(f)
print(save_length)
