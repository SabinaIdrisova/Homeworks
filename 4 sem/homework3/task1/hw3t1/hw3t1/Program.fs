let maxSum list = 
    let rec loop list max pos = 
        match list with
        | [] -> pos
        | _ -> 
            if list.Head = max then
                pos
            else 
                loop list.Tail max (pos + 1)
    loop (List.map2 (fun x y -> x + y) list (list.Tail @ [0])) (List.max (List.map2 (fun x y -> x + y) list (list.Tail @ [0]))) 1
System.Console.Write(maxSum [1; 5; 6; 2])
System.Console.Read()