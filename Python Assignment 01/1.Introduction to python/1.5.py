num1=int(input("enter first number"))
num2=int(input("enter second number"))
print (f"Numbers before swap : num1 ={num1}, num2:{num2}")
num1=num1-num2
num2=num2+num1
num1=num2-num1
print (f"Numbers after swap : num1 ={num1}, num2:{num2}")
