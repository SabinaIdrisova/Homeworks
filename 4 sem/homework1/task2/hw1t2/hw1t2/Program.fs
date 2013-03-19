let rec fibonacci index = 
    match index with
    | 0 -> 1
    | 1 -> 1
    | _ -> fibonacci (index - 1) + fibonacci (index - 2)

System.Console.WriteLine(fibonacci 5)
System.Console.Read()

