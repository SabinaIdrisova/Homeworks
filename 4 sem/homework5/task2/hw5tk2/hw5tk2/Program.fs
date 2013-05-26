open System.Collections.Generic

type Node<'a when 'a : comparison> (value : 'a) =
    let mutable left : Node<'a> option = None
    let mutable right : Node<'a> option = None
    member this.getLeft = left
    member this.getRight = right
    member this.getValue = value
    member this.SetLeft value = left <- Some(Node<'a>(value))
    member this.SetRight value = right <- Some(Node<'a>(value))

type Enumerator<'a when 'a : comparison>(node: Node<'a> option) =
    let mutable current = node
    let stack = Stack<Node<'a> option>()
    do stack.Push(node)

    interface IEnumerator<Node<'a>> with

        member this.MoveNext() =
            if stack.Count = 0 then
                false
            else
                current <- stack.Pop()
                if current.Value.getRight <> None then
                    stack.Push current.Value.getRight
                if current.Value.getLeft <> None then
                    stack.Push current.Value.getLeft
                true
        member this.Reset() =  current <- node
        member this.Dispose() = ()
        member this.Current = current.Value
        member this.get_Current() = current :> obj

type Tree<'a when 'a : comparison>() =
    let mutable root : Node<'a> option = None    

    member this.getRoot = root

    member tris.addValue(value: 'a) =
        if root = None then
            root <- Some(Node<'a>(value))
        else 
            let rec addElement (node: Node<'a>) = 
                if value < node.getValue then
                    if node.getLeft = None then
                        node.SetLeft value
                    else addElement node.getLeft.Value
                else
                    if value > node.getValue then
                        if node.getRight = None then
                            node.SetRight value
                        else addElement node.getRight.Value
            addElement root.Value

    member this.elementExists(value: 'a) =
        let rec findElement (node: Node<'a> option) = 
            if node <> None then
                if value = node.Value.getValue then true
                else if value < node.Value.getValue && node.Value.getLeft <> None then
                    findElement node.Value.getLeft
                else if value > node.Value.getValue && node.Value.getRight <> None then
                    findElement node.Value.getRight
                else false
            else false
        findElement root
        
    interface IEnumerable<Node<'a>> with
        member this.GetEnumerator() =
            new Enumerator<'a>(root) :> IEnumerator<Node<'a>>
        member this.GetEnumerator() =
            new Enumerator<'a>(root) :> System.Collections.IEnumerator


let tree = Tree<int>()
tree.addValue 1
tree.addValue 2
tree.addValue 0
tree.addValue 8
printfn "%A" <| tree.elementExists 2
printfn "%A" <| tree.elementExists 11
for i in tree do printfn "%A" (i.getValue * 2)