# Print all integers from 0 to 150
for x in range(0, 151, 1):
    print(x)

#Multiples of Five
    for x in range(5, 1001, 1):
     if x%5==0:
        print(x)

#Counting, the Dojo Way
     for x in range(5, 101, 1):
      if x%10==0:
         print("Coding Dojo")
      elif x%5==0:
         print("Coding")


    #Whoa. That Sucker's Huge
     for x in range(0, 500001, 1):  
      if x%2!=0:
       sum=0+x 
       print(sum)

#Countdown by Fours
    for x in range(2018, 0, -4):
     print(x)


#Flexible Counter
lowNum=2
highNum=9
mult=3
for x in range(lowNum,highNum+1, 1):
 if x%mult==0:
    print(x)