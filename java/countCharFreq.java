const s = "programming";
const map = new Map();

for (let ch of s) {
    map.set(ch, (map.get(ch) || 0) + 1);
}

for (let [key, value] of map) {
    console.log(`${key} : ${value}`);
}
