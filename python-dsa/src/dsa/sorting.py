def bubble_sort(x):
    i=0
    swapped=True
    while swapped and i < len(x)-1:
        swapped=False
        for j in range(0,len(x)-i-1):
            if x[j]>x[j+1]:
                temp=x[j]
                x[j]=x[j+1]
                x[j+1]=temp
                swapped=True
        i+=1

def merge_sort(arr):
    if len(arr)<=1:
        return arr
    mid = len(arr) // 2

    left = merge_sort(arr[:mid])
    right = merge_sort(arr[mid:])

    return merge(left,right)

def merge(left,right):
    array=[]
    i=j=0
    while i<len(left) and j<len(right):
        if left[i]<=right[j]:
            array.append(left[i])
            i+=1
        else:
            array.append(right[j])
            j+=1

    array.extend(left[i:])
    array.extend(right[j:])

    return array

if __name__ == "__main__":
    x = [5, 3, 8, 4, 2]
    print(merge_sort(x))



