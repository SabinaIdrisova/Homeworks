open System
open System.IO
open System.Text

let addNewRecord contactList = 
    printf "Введите имя: "
    let name = Console.ReadLine()
    printf "Введите номер: "
    let number = Console.ReadLine()
    let contactList = name :: number :: contactList
    contactList

let findRecord contactList (findByName: bool) = 
    if findByName then
        printf "Введите имя "
    else printf "Введите номер "
    let record = Console.ReadLine()
    let array = List.toArray contactList
    let rec find record (array: string[]) i = 
        if i >= 0 then
            if record = array.[i] then 
                if findByName then
                    printfn "Номер: %A" array.[i + 1]
                else printfn "Имя: %A" array.[i - 1]
            else find record array (i - 1)
         else printfn "Контакт не найден"    
    find record array (array.Length - 1)

let saveData contactList = 
    let contact = List.toArray contactList
    let file = File.WriteAllLines("Contact.txt", contact)
    printfn "Данные сохранены"
    file

let readLines file =
    seq { use inp = File.OpenText file in
          while not(inp.EndOfStream) do yield (inp.ReadLine())
        }

let readData file = 
    try 
        readLines file |> printfn "\n %A"
    with 
    | exn -> printfn "Ошибка! %s" exn.Message

let rec phoneBook contactList = 
    printfn "Выберите опреацию:"
    printfn " 0 - выйти\n 1 - добавить запись\n 2 - найти телефон по имени\n 3 - найти имя по телефону\n 4 - сохранить текущие данные в файл\n 5 - считать данные из файла"
    let operation = Console.ReadLine()
    let contactList = 
        match operation with 
            | "1" -> addNewRecord contactList

            | "2" -> findRecord contactList true
                     contactList
            | "3" -> findRecord contactList false
                     contactList
            | "4" -> saveData contactList
                     contactList
            | "5" -> readData "Contact.txt"
                     contactList
            | "0" -> printfn "________________________________"
                     Environment.Exit 1
                     contactList
            |  _  -> printfn "Команда введена неверно! Попробуйте ещё раз"
                     contactList
    phoneBook contactList

phoneBook []

