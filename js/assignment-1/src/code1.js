
function math(operation, x){
    const OPT = {
        '*': (a,b) => a * b,
        '/': (a,b)=> a / b,
        '+': (a,b)=> a + b,
        '-': (a,b)=> a - b,
    }

    return function(y){
        return OPT[operation](x,y)
    }
}

const mul = math("*", 5)
const add = math("+", mul(2))

console.log(typeof add)
console.log(add(math("-" , 25)(20)))