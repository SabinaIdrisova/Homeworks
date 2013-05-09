type Builder (number : int) =

    let round(count : float) = System.Math.Round(float count, number)
    member this.Bind(result : float, rest : float -> float) = 
        let res = round result
        rest res
    member this.Return(count : float) = round count

let rounding number = new Builder(number)

let answer = 
    rounding 3 {
        let! x = 2.0 / 12.0
        let! y = 3.5
        return x / y
    }

printfn "%A" answer


