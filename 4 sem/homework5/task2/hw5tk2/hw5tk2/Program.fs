type Tree<'a when 'a : comparison> =
    | Tree of 'a * 'a Tree * 'a Tree
    | Nil

    member tree.AddValue(value: 'a) =
        match tree with
        | Nil -> Tree(value, Nil, Nil)
        | Tree(data, left, right) when data < value -> Tree(data, left, right.AddValue(value))
        | Tree(data, left, right) -> Tree(data, left.AddValue(value), right)

    member tree.Split() =
        match tree with
        | Tree(data, left, right) -> left.Split() @ [data] @ right.Split()
        | Nil -> []

    member tree.ElementExists(value: 'a) =
        match tree with
        | Nil -> printfn " Element doesn't exist"
        | Tree(data, left, right) when data = value -> printfn " Element exists"
        | Tree(data, left, right) when data < value -> right.ElementExists(value)
        | Tree(data, left, right) when data > value -> left.ElementExists(value)
        
    member tree.Print() = 
        match tree with
        | Tree(data, left, right) -> printf " %A" data
                                     left.Print()
                                     right.Print()
        | Nil -> () 

    member tree.Iterator(func) =
        let list = tree.Split()
        let iterList = List.iter(func) list
        printfn ""

let mutable tree = Tree(1, Nil, Nil)
tree <- tree.AddValue(1)
tree <- tree.AddValue(2)
tree <- tree.AddValue(0)
tree <- tree.AddValue(8)
tree.ElementExists(2)
tree.ElementExists(11)
tree.Print()

let mutable acc = 0
tree.Iterator(fun x-> acc <- acc + x)
printfn " %A" acc

