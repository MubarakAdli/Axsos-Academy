def biggie_size(arr):
    for x in range(0,len(arr),1):
        if arr[x]>0:
            arr[x]="big"
    return arr


print(biggie_size([1,4,-5,6]))