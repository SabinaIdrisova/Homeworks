let rec firstPosition list number position = 
     match list with
     | [] -> None
     | head::tail ->
         if (number = list.Head) then
             Some position
         else firstPosition list.Tail number (position + 1)
System.Console.Write(firstPosition [1; 2; 3] 2 0)
System.Console.Read() |> ignore
