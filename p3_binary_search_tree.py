# 비내림차순으로 정렬된 배열에서 주어진 값 찾기

def bs (data, item, low, high):

    if low > high:
        # 찾지 못했을 경우
        return 0 

    else:
        # 가운데 지점 찾기
        mid = int((low + high) / 2)

        # 가운데 지점일 경우
        if (item == data[mid]):
            return mid
        elif item < data[mid]:
            return bs(data, item, low, mid-1)
        else:
            return bs(data, item, low+1, high)



data=[1,3,5,6,7,9,10,14,17,19]
n=10
location = bs(data,17,0,n-1)

print(location)