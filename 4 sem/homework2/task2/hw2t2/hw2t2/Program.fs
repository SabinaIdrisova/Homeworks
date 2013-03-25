let powers = 
     let rec nPowers n = 
         match n with
         | 0 -> [1]
         | n -> (2 * (nPowers (n - 1)).Head) :: nPowers (n - 1) 
     nPowers 5
printfn "%A" (powers)
