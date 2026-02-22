class MinStack {

  constructor() {
    this.stack = [];
    this.min = Infinity;
  }

  push(val) {

    if (val <= this.min) {
      this.stack.push(this.min);
      this.min = val;
    }

    this.stack.push(val);

  }

  pop() {

    const val = this.stack.pop();

    if (val === this.min) {
      this.min = this.stack.pop();
    }

  }

  top() {
    return this.stack[this.stack.length - 1];
  }

  getMin() {
    return this.min;
  }

}
