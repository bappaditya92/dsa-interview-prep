const s = "aabbccdd";
const freq = new Array(256).fill(0);

for (let i = 0; i < s.length; i++) {
    freq[s.charCodeAt(i)]++;
}

for (let i = 0; i < s.length; i++) {
    const code = s.charCodeAt(i);
    if (freq[code] !== 0) {
        console.log(s[i] + " : " + freq[code]);
        freq[code] = 0;
    }
}
