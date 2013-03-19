let rec factorial n = 
    match n with
    | 0 -> 1
    | _ -> factorial (n - 1) * n

System.Console.WriteLine(factorial 3)
System.Console.Read()
