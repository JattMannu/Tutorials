function sum(){
    let ans = 0;
    [1,2,3,4,5,"a",NaN].forEach((element) => {
        const e = parseInt(element);
        if(!isNaN(e)){
            ans += e;
        }
    });
    return ans;
}


console.log(sum())