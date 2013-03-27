let rec supermap lst fun1 =
    match lst with
    | [] -> []
    | head :: tail -> fst(fun1 head) :: snd(fun1 head) :: supermap tail fun1 
    
let lst1 = supermap [1; 2; 3] (fun x -> x + 1, x + 2)
printfn "%A" (lst1)



