const user = {
  name: "Bappa",
  age: 25
};

const handler = {
  get(target, prop) {
    console.log(`Accessing property: ${prop}`);
    return target[prop];
  },
  set(target, prop, value) {
    if (prop === "age" && value < 0) {
      throw new Error("Age cannot be negative");
    }
    target[prop] = value;
    return true;
  }
};

const proxyUser = new Proxy(user, handler);

console.log(proxyUser.name);   // logs access
proxyUser.age = 30;            // allowed
proxyUser.age = -5;            // throws error
