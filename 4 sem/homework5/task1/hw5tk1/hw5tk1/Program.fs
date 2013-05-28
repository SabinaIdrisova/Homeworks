open System
open System.Collections

type OS = 
    | Windows
    | Linux
    | MacOS

let rand = new Random()

type Computer (OS : OS) = 
    let mutable infected = false
    let infectionChance = 
        match OS with
        | Windows -> 10
        | Linux -> 20
        | MacOS -> 40 
    member this.OS = OS
    member this.isInfected
        with set(value) = infected <- value
        and get() = infected
    member this.attack = 
        let attackPower = rand.Next(100)
        if (attackPower > infectionChance)
            then this.isInfected <- true

type Network(network: bool [] [], computers : Computer []) = 
    member this.network = network
    member this.computers = computers
    member this.getInfectState = 
        Array.init computers.Length (fun i -> computers.[i].isInfected)
    member this.update =
        let currentInfectState = this.getInfectState
        let length = computers.Length
        for i in 0..length - 1 do
            for j in 0..length - 1 do
                if network.[i].[j] then
                    if currentInfectState.[i] then
                        computers.[j].attack
    member this.printState =
        for i in 0..computers.Length - 1 do
            if computers.[i].isInfected then
                    printfn  "%A" ("computer " + string i  + " is infected")
            else 
               printfn "%A" ("computer " +  string i  + " isn't infected")

let network = [|[|false; false; true; false|]; 
              [|false; false; false; true|];
              [|true; false; false; true|];
              [|false; true; true; false|]|]

let comp1 = Computer(Windows)
let comp2 = Computer(Windows)
let comp3 = Computer(Linux)
let comp4 = Computer(MacOS)
comp3.isInfected <- true

let computers = [|comp1; comp2; comp3; comp4|]

let newNetwork = Network(network, computers)

let timer = new System.Timers.Timer(1000.0);

timer.Elapsed.Add(fun _ -> Console.Clear()
                           newNetwork.update
                           newNetwork.printState)
timer.Start()
Console.Read()|>ignore

    




