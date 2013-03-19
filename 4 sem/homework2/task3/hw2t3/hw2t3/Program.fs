let rec multiplication number = 
    if number < 10 then 
        number
    else 
        number % 10 * multiplication(number / 10)
System.Console.Write(multiplication 1234)
System.Console.Read()

