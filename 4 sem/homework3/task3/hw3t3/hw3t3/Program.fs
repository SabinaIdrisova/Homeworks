let first list = List.length (List.filter (fun x -> x % 2 = 0) list)

let second list = List.length (List.filter (fun x -> x = 0) (List.map (fun x -> x % 2) list))
    
let third list = List.fold (fun acc x -> acc + x) 0 (List.map (fun x -> x / 2) list)

System.Console.WriteLine(first [1; 2; 3; 4])
System.Console.WriteLine(second [1; 2; 3; 4; 8; 12; 100])
System.Console.WriteLine(second [1; 2; 3; 4; 1; 6; 7; 8])
System.Console.Read()  

