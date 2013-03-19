let reverse list = 
    let rec loop list reversedList = 
        match list with
        | head::tail ->
            let reversedList = list.Head :: reversedList
            loop list.Tail reversedList
        | [] -> reversedList
    loop list []

System.Console.Write(reverse [1; 2; 3; 4])
System.Console.Read()


