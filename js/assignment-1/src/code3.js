var bar = 5;
function foo(bar){
    if(bar >=5 ){
        bar = "zzz"
    }else{
        let bar = "qux"
    }
    console.log(bar)
}

foo(2)
foo(5)
console.log(bar)