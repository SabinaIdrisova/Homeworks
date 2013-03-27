let isPalindrom (number: int) = 
    let str = number.ToString()
    let strArray = str.ToCharArray()
    strArray = Array.rev strArray

let multiplication =
    let rec newList lst1 lst2 acc = 
        match lst2 with
        | [] -> acc
        | _ -> List.map (fun x -> x * lst2.Head) lst1 @ newList lst1 lst2.Tail acc
    newList [100..999] [100..999] []

let maxPal = List.max (List.filter (fun x -> isPalindrom x) multiplication)

printfn "max palindrom = %A" (maxPal)

