const longestPalindrome = (s) => {
  if (s.length < 2) return s;
  let start = 0;
  let maxLength = 1;

  const expand = (left, right) => {
    while (left >= 0 && right < s.length && s[left] === s[right]) {
      const length = right - left + 1;
      if (length > maxLength) {
        start = left;
        maxLength = length;
      }
      left--;
      right++;
    }
  };

  for (let i = 0; i < s.length; i++) {
    expand(i, i);
    expand(i, i + 1);
  }
  return s.substring(start, start + maxLength);
};
