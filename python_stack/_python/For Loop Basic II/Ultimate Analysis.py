def ultimate_analysis(arr):
    sum=0
    min=0
    max=0
    for x in range(0,len(arr),1):
        sum=sum+arr[x]
        if arr[x]<min:
            min=arr[x]
        
        if arr[x]>max:
            max=arr[x]

    return[sum,sum/len(arr),max,min,len(arr)]

print(ultimate_analysis([1,4,3,5,4]))

