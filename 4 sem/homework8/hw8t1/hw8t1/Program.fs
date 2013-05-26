open System
open System.Net
open System.Collections.Generic
open System.Text.RegularExpressions

let getUrl (url: string) =
        let uri = new System.Uri(url)
        let webClient = new WebClient()
        let page = webClient.DownloadString(uri)
        let pattern = "href=\"(http\\S+\/)\""
        let mutable m = Regex.Match(page, pattern, RegexOptions.Compiled)
        let res = new List<String>()
        while m.Success do
            res.Add(m.Groups.[1].ToString())
            m <- m.NextMatch()
        res

let fetchAsync(url: string) =
    async { 
        let uri = new System.Uri(url)
        let webClient = new WebClient()
        let! html = webClient.AsyncDownloadString(uri)
        printfn "%s =  %d" url html.Length
    } 

let runAll() =
    getUrl("http://mail.ru")
    |> Seq.map fetchAsync
    |> Async.Parallel 
    |> Async.RunSynchronously
    |> ignore

runAll()  