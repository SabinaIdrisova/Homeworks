type Expression =
    | X
    | Const of float
    | Add of Expression * Expression
    | Sub of Expression * Expression
    | Mul of Expression * Expression
    | Div of Expression * Expression
    
let (|Operation|_|) (expression : Expression) =
    match expression with
    | Add(e1, e2) -> Some(Add, e1, e2)
    | Sub(e1, e2) -> Some(Sub, e1, e2)
    | Mul(e1, e2) -> Some(Mul, e1, e2)
    | Div(e1, e2) -> Some(Div, e1, e2)
    | _ -> None

let rec simplifyExpression (expression : Expression) =
    match expression with
    | Add(Const(n1), Const(n2)) -> Const(n1 + n2)
    | Sub(Const(n1), Const(n2)) -> Const(n1 - n2)
    | Mul(Const(n1), Const(n2)) -> Const(n1 * n2)
    | Div(Const(n1), Const(n2)) -> Const(n1 / n2)
    | Add(x, Const(0.0)) -> x |> simplifyExpression
    | Add(Const(0.0), x) -> x |> simplifyExpression
    | Add(Const(n), x) -> Add(x, Const(n)) |> simplifyExpression
    | Sub(x, Const(0.0)) -> x |> simplifyExpression
    | Sub(x, y) when x = y -> Const(0.)
    | Mul(x, Const(1.0)) -> x |> simplifyExpression
    | Mul(Const(1.0), x) -> x |> simplifyExpression
    | Mul(x, Const(0.0)) -> Const(0.)
    | Mul(Const(0.0), x) -> Const(0.)
    | Mul(x, Const(n)) -> Mul(Const(n), x) |> simplifyExpression
    | Mul(Div(Const(n), x1), x2) -> Mul(Const(n), Div(x2, x1)) |> simplifyExpression
    | Mul(x1, Div(Const(n), x2)) -> Mul(Const(n), Div(x1, x2)) |> simplifyExpression
    | Div(Const(0.0), x) -> Const(0.0)
    | Div(x, Const(1.)) -> x |> simplifyExpression
    | Operation (operation, x1, x2) ->
        let y1 = simplifyExpression x1
        let y2 = simplifyExpression x2
        if y1 <> x1 || y2 <> x2 then
            operation(simplifyExpression x1, simplifyExpression x2) |> simplifyExpression
        else
            operation(x1, x2)
    | _ -> expression

let rec derivative (expression : Expression) =
    let der =
        match expression with
        | X -> Const(1.)
        | Const(n) -> Const(0.0)
        | Add(x1, x2) -> Add(derivative x1, derivative x2)
        | Sub(x1, x2) -> Sub(derivative x1, derivative x2)
        | Mul(x1, x2) -> Add(Mul(derivative x1, x2), Mul(x1, derivative x2))
        | Div(x1, x2) -> Div(Sub(Mul(derivative x1, x2), Mul(x1, derivative x2)), Mul(x2, x2))
    simplifyExpression der

let expression1 = derivative (Mul(X, X))
let expression2 = derivative(Mul(Add(X, Const(3.0)), X))
printfn "%A" expression1
printfn "%A" expression2
