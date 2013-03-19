let isPalindrom (str : string) =
        let strArray = str.ToCharArray()
        strArray = Array.rev strArray
System.Console.Write(isPalindrom "abaaba")
System.Console.Write(isPalindrom "bbbbg")
System.Console.Read()
