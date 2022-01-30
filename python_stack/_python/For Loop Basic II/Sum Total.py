def sum_total(arr):
    sum=0
    for x in range(0,len(arr),1):
        sum=sum+arr[x]
    return sum

print(sum_total([2,6,7,5,4]))
