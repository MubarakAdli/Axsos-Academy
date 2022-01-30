def average(arr):
    sum=0
    
    for x in range(0,len(arr),1):
        sum=sum+arr[x]
    return sum/len(arr)

print(average([2,4,6]))