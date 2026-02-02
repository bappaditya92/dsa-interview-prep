class EventEmitter {
  constructor() {
    this.events = {};
  }

  subscribe(event, cb) {
    if (!this.events[event]) this.events[event] = new Set();
    this.events[event].add(cb);
  }

  unsubscribe(event, cb) {
    this.events[event]?.delete(cb);
  }

  emit(event, data) {
    this.events[event]?.forEach(cb => cb(data));
  }
}
