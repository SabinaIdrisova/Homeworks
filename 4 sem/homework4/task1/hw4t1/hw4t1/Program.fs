open System

let rec checkBrackets (input: char[]) list i length =
    if i <= length then
        if input.[i] = '[' || input.[i] = '(' || input.[i] = '{' then
            checkBrackets input (input.[i] :: list) (i + 1) length
        else if input.[i] = ']' || input.[i] = ')' || input.[i] = '}' then
            match input.[i] with
            | ']' when List.head list = '[' -> checkBrackets input (List.tail list) (i + 1) length
            | ')' when List.head list = '(' -> checkBrackets input (List.tail list) (i + 1) length 
            | '}' when List.head list = '{' -> checkBrackets input (List.tail list) (i + 1) length 
            | _ -> printfn "False"
    else 
        if List.length list = 1 then 
            printfn "True"
        else printfn "False"

printfn "Введите строку "
let str = Console.ReadLine()
let inputString = str.ToCharArray()
checkBrackets inputString ['%'] 0 (inputString.Length - 1)

