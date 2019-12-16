let val = "bbbaacdafe"

function solution(str) {
    let map = {};
    for (var i = 0; i < str.length; i++) {
        let key = str.charAt(i);
        if (key in map == false)
            map[key] = 1;
        else
            map[key] += 1;
    }

    console.log(map)

    let idx = 'a';
    let prev = 9007199254740991;
    while (idx <= 'z') {
        //console.log(map[idx])
        if(prev < map[idx])
            return false;
        prev = map[idx]
        idx = String.fromCharCode(idx.charCodeAt()+1);;
    }

    return true;

}

//console.log(solution("bbbaacdafe"))
console.log(solution("bba"))
