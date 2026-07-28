const logMethods = (obj)=>{
  return new Proxy(obj, {
    get(target, prop) {
      const original = target[prop];
      if (typeof original === "function") {
        return function (...args) {
          console.log(`Calling ${prop} with`, args);
          return original.apply(this, args);
        };
      }
      return original;
    }
  });
}
