open System.ComponentModel

let sum(array: int[], finished: bool[]) =
    let result = ref 0
    for i = 0 to 99 do
        let worker = new BackgroundWorker()
        worker.DoWork.Add(fun args -> for j = (i * 9999) to (i + 1) * 9999 do result:= array.[j] + !result)
        worker.RunWorkerCompleted.Add(fun args -> finished.[i] <- true)
        worker.RunWorkerAsync()

    while not (Array.forall(fun x -> x = true) finished) do ()     
    printfn "%A" !result

let array = Array.create 1000000 1
let mutable finished = Array.create 100 false

sum(array, finished)

