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

let findByName contactList = 
    printf "Введите имя "
    let name = Console.ReadLine()
    let array = List.toArray contactList
    let rec find name (array: string[]) i = 
        if i > 0 then
            if name = array.[i] then printfn "Номер: %A" array.[i + 1]
            else find name array (i - 1)
         else printfn "Контакт не найден"    
    find name array (array.Length - 1)

let findByNumber contactList = 
    printf "Введите номер "
    let number = Console.ReadLine()
    let array = List.toArray contactList
    let rec find number (array: string[]) i = 
        if i > 0 then
            if number = array.[i] then printfn "Имя: %A" array.[i - 1]
            else find number array (i - 1)
        else printfn "Контакт не найден"   
    find number array (array.Length - 1)

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
    readLines file |> Seq.toArray |> printfn "\n %A"


let rec phoneBook contactList = 
    printfn "Выберите опреацию:"
    printfn " 0 - выйти\n 1 - добавить запись\n 2 - найти телефон по имени\n 3 - найти имя по телефону\n 4 - сохранить текущие данные в файл\n 5 - считать данные из файла"
    let operation = Console.ReadLine()
    let contactList = 
        match operation with 
            | "1" -> addNewRecord contactList

            | "2" -> findByName contactList
                     contactList
            | "3" -> findByNumber contactList
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

