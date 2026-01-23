const flattenObject = (obj, parent = '', res = {}) => {
  for (let key in obj) {
    const newKey = parent ? `${parent}.${key}` : key;

    if (typeof obj[key] === 'object' && obj[key] !== null) {
      flattenObject(obj[key], newKey, res);
    } else {
      res[newKey] = obj[key];
    }
  }
  return res;
}
console.log(flattenObject({ a: { b: { c: 1 } } }));
