type Tree<'a, 'b> = 
    | Tree of 'a * Tree<'a, 'b> * Tree<'a, 'b>
    | Leaf of 'b

let rec calculate tree = 
    match tree with
    | Leaf value -> value
    | Tree (operation, left, right) -> 
        match operation with
        | '+' -> calculate left + calculate right
        | '-' -> calculate left - calculate right
        | '*' -> calculate left * calculate right
        | '/' -> calculate left / calculate right
        | _ -> failwith "Invalid operation!"

let tree = Tree('*', Tree('+', Leaf(1), Leaf(2)), Tree('-', Tree('*', Leaf(3), Leaf(4)), Tree('+', Leaf(5), Leaf(6))))
System.Console.Write(calculate tree)
System.Console.Read() |> ignore
