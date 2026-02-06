const wordBreak = (s, wordDict) => {
    const dict = new Set(wordDict);
    const memo = new Map();

    const dfs = (start) => {
        if (memo.has(start)) return memo.get(start);

        const result = [];

        // reached end → valid sentence
        if (start === s.length) {
            result.push("");
            return result;
        }

        for (let end = start + 1; end <= s.length; end++) {
            const word = s.slice(start, end);

            if (dict.has(word)) {
                const subsentences = dfs(end);

                for (const sub of subsentences) {
                    result.push(sub ? word + " " + sub : word);
                }
            }
        }

        memo.set(start, result);
        return result;
    };

    return dfs(0);
};
