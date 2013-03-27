open System.Collections.Generic

exception InvalidOperation of string

type Queue<'a>(lst: List<'a>) = 
    let mutable queue = lst
    let mutable count = 0

    member this.Enqueue(value) = 
        queue.Add(value)
        count <- count + 1

    member this.Dequeue() = 
        match count with
        | 0 -> raise (InvalidOperation ("Invalid operation!"))
        | _ -> 
            let head = queue.[0]
            queue.RemoveAt(0)
            count <- count - 1
            head

    member this.Count() = count
    new() = Queue<'a>(new List<'a>())

let queue = new Queue<int>()
queue.Enqueue(1)
queue.Enqueue(2)
queue.Enqueue(3)
queue.Enqueue(4)
printfn "count = %d " (queue.Count())
try 
    printfn "%d" (queue.Dequeue())
with 
    | InvalidOperation(str) -> printfn "%s" str
printfn "count = %d" (queue.Count())
try 
    printfn "%d" (queue.Dequeue())
with 
    | InvalidOperation(str) -> printfn "%s" str
printfn "count = %d" (queue.Count())
