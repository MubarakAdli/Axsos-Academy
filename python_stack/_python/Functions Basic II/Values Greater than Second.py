def values_greater_than_second(arr):
    newarr=[]
    count=0
    for x in range (0,len(arr),1):
        if len(arr)<2:
            return "false"

        elif arr[x]>arr[1]:
            newarr.append(arr[x])
            count=count+1
    print(count) 
    return newarr

print(values_greater_than_second([4,4,2,6,5]))
