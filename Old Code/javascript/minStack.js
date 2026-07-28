class MinStack {

  constructor() {
    this.stack = [];
    this.minStack = [];
  }

  push(val) {

    this.stack.push(val);

    if (
      this.minStack.length === 0 ||
      val <= this.getMin()
    ) {
      this.minStack.push(val);
    }

  }

  pop() {

    const removed = this.stack.pop();

    if (removed === this.getMin()) {
      this.minStack.pop();
    }

  }

  top() {
    return this.stack[this.stack.length - 1];
  }

  getMin() {
    return this.minStack[this.minStack.length - 1];
  }

}
