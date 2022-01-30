def minimum(arr):
    min=arr[0]
    if len(arr)==0:
        return "flase"  
    elif len(arr)>0:
        for x in range(0,len(arr),1):
            if arr[x]<min:
                min=arr[x]
        return min


print(minimum([2,4,5,67,6]))
