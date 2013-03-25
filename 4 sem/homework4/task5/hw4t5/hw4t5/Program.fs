type Tree = 
    | Node of int * Tree * Tree
    | Leaf of int

let rec map func tree = 
    match tree with
    | Leaf(value) -> Leaf(func value)
    | Node(value, left, right) -> Node(func value, map func left, map func right)

let tree = Node(1, Node(2, Leaf(3), Leaf(4)), Node(5, Leaf(6), Leaf(7)))
printfn "New tree %A" (map ((*) 2) tree)
System.Console.Read() |> ignore


