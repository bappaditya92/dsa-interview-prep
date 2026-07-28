const isValid = (s)=> {
    const stack = [];
    const map = {
        ')': '(',
        '}': '{',
        ']': '['
    };

    for (let char of s) {
        if (char === '(' || char === '{' || char === '[') {
            stack.push(char);
        } else {
            if (stack.length === 0) return false;

            const top = stack.pop();
            if (top !== map[char]) return false;
        }
    }
    return stack.length === 0;
};
