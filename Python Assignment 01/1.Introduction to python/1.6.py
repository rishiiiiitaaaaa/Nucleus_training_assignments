expression = input("Enter an expression (e.g., 10 + 5): ")
parts = expression.split()

if len(parts) != 3:
    print("Invalid format. Use: number operator number (e.g., 10 + 5)")
else:
    num1 = float(parts[0])
    operator = parts[1]
    num2 = float(parts[2])

    if operator == '+':
        result = num1 + num2
    elif operator == '-':
        result = num1 - num2
    elif operator == '*':
        result = num1 * num2
    elif operator == '/':
        if num2 != 0:
            result = num1 / num2
        else:
            result = "Error: Division by zero"
    else:
        result = "Invalid operator"

    print("Result:", result)
