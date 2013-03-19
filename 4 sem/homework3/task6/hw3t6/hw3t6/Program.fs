let isPrime number =
    let rec check i =
        i > number / 2 || (number % i <> 0 && check (i + 1))
    check 2
let sequence = seq { for x in Seq.initInfinite (fun i -> i + 1) do if isPrime x then yield x }
for x in sequence do
    printfn "%d" x