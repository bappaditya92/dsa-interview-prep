const findLongestWord = (s, dictionary) => {
    let result = "";

    for (const word of dictionary) {
        if (isSubsequence(word, s)) {
            if (
                word.length > result.length ||
                (word.length === result.length && word < result)
            ) {
                result = word;
            }
        }
    }

    return result;
};

const isSubsequence = (word, s) => {
    let i = 0;

    for (const char of s) {
        if (char === word[i]) i++;
        if (i === word.length) return true;
    }

    return i === word.length;
};
