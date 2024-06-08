# a=[1,2,3,4,5]
a=list(input("Enter number for list:").split(","))
sum=0
for i in a:
  sum=sum+int(i)
print (sum)