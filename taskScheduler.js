class TaskScheduler {
  constructor(limit) {
    this.limit = limit;
    this.running = 0;
    this.queue = [];
  }

  addTask(taskFn) {
    return new Promise((resolve) => {
      this.queue.push({ taskFn, resolve });
      this._run();
    });
  }

  _run() {
    if (this.running >= this.limit || !this.queue.length) return;

    const { taskFn, resolve } = this.queue.shift();
    this.running++;

    taskFn().then(result => {
      resolve(result);
      this.running--;
      this._run();
    });
  }
}
