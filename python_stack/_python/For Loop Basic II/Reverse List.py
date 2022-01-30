def reverse_list(arr):
    arrnew=[]
    for x in range(len(arr)-1,-1,-1):
        arrnew.append(arr[x])
    return arrnew

print(reverse_list([1,5,4,3,7]))