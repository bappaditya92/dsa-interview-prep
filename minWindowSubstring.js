const minWindow = (s, t) => {
    if (!s || !t) return "";

    const need = new Map();
    for (const ch of t) {
        need.set(ch, (need.get(ch) || 0) + 1);
    }

    let left = 0;
    let have = 0;
    const needCount = need.size;

    const window = new Map();

    let minLen = Infinity;
    let start = 0;

    for (let right = 0; right < s.length; right++) {
        const ch = s[right];

        window.set(ch, (window.get(ch) || 0) + 1);

        if (need.has(ch) && window.get(ch) === need.get(ch)) {
            have++;
        }

        while (have === needCount) {

            if (right - left + 1 < minLen) {
                minLen = right - left + 1;
                start = left;
            }

            const leftChar = s[left];

            window.set(leftChar, window.get(leftChar) - 1);

            if (need.has(leftChar) && window.get(leftChar) < need.get(leftChar)) {
                have--;
            }

            left++;
        }
    }

    return minLen === Infinity ? "" : s.substring(start, start + minLen);
};
