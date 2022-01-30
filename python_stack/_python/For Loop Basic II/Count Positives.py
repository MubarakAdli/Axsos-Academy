def count_positives(arr):
    count=0
    arrnew=[]
    for x in range(0,len(arr),1):
        if arr[x]>0:
            count=count+1
    arr[len(arr)-1]=count
    return arr

print(count_positives([1,1,1,-1]))