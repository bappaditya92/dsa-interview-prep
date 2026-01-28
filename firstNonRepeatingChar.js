const firstNonRepeatingChar = (str) => {
  const count = {};
  for (let char of str) {
    count[char] = (count[char] || 0) + 1;
  }

  for (let char of str) {
    if (count[char] === 1) {
      return char;
    }
  }

  return null;
}

console.log(firstNonRepeatingChar("aabbccd")); 
console.log(firstNonRepeatingChar("aabbcc"));  
