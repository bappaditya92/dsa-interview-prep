const dailyTemperatures = (temps)=> {
    const stack = [];
    const res = new Array(temps.length).fill(0);

    for (let i = 0; i < temps.length; i++) {
        while (stack.length && temps[i] > temps[stack[stack.length-1]]) {
            const idx = stack.pop();
            res[idx] = i - idx;
        }
        stack.push(i);
    }

    return res;
};
