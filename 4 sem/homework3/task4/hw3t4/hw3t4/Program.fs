type Tree = 
    | Node of int * Tree * Tree
    | Leaf of int

let rec height tree = 
    match tree with
    | Leaf _ -> 1
    | Node(_, left, right) -> 1 + max (height left) (height right)

let tree = Node(1, Node(2, Leaf(3), Leaf(4)), Node(5, Leaf(6), Leaf(7)))
System.Console.Write(height tree)
System.Console.Read() |> ignore

