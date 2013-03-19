let elementsIsDifferent list = 
    match list with
    | [] -> true
    | _ -> 
        let rec difference list1 list2 list3 = 
            match list1, list2, list3 with
            | _, [], [] -> true
            | _, [], list3 -> difference list3.Head list3.Tail list3.Tail
            | list1, x, list3 -> 
                if (list1 = x.Head) then
                    false
                else
                    difference list1 x.Tail list3
        difference list.Head list.Tail list.Tail

System.Console.Write(elementsIsDifferent [1; 5; 6; 2])
System.Console.Read()

