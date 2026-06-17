const createSecureObject = (obj) => {
  return new Proxy(obj, {
    get(target, prop) {
      if (prop.startsWith("_")) {
        throw new Error("Access Denied");
      }
      return target[prop];
    },
    set(target, prop, value) {
      if (prop.startsWith("_")) {
        throw new Error("Cannot modify private property");
      }
      target[prop] = value;
      return true;
    }
  });
}

const account = createSecureObject({
  name: "Bappa",
  _password: "12345"
});

console.log(account.name);        // works
console.log(account._password);   // error
