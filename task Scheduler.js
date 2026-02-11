class MaxHeap {
  constructor() {
    this.heap = [];
  }

  push(val) {
    this.heap.push(val);
    this.bubbleUp();
  }

  bubbleUp() {
    let i = this.heap.length - 1;
    while (i > 0) {
      let parent = Math.floor((i - 1) / 2);
      if (this.heap[parent] >= this.heap[i]) break;
      [this.heap[parent], this.heap[i]] = [this.heap[i], this.heap[parent]];
      i = parent;
    }
  }

  pop() {
    if (!this.heap.length) return null;

    const top = this.heap[0];
    const end = this.heap.pop();

    if (this.heap.length) {
      this.heap[0] = end;
      this.bubbleDown();
    }

    return top;
  }

  bubbleDown() {
    let i = 0;
    const len = this.heap.length;

    while (true) {
      let left = 2 * i + 1;
      let right = 2 * i + 2;
      let largest = i;

      if (left < len && this.heap[left] > this.heap
