def maximum(arr):
    max=arr[0]
    if len(arr)==0:
        return "flase"  
    elif len(arr)>0:
        for x in range(0,len(arr),1):
            if arr[x]>max:
                max=arr[x]
        return max


print(maximum([2,4,5,67,6]))
