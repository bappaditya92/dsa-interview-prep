class LRUCache {
  constructor(capacity) {
    this.capacity = capacity;
    this.map = new Map();
  }

  get(key) {
    if (!this.map.has(key)) return -1;

    const value = this.map.get(key);

    // move to recent
    this.map.delete(key);
    this.map.set(key, value);

    return value;
  }

  put(key, value) {
    if (this.map.has(key)) {
      this.map.delete(key);
    }

    this.map.set(key, value);

    if (this.map.size > this.capacity) {
      const firstKey = this.map.keys().next().value;
      this.map.delete(firstKey);
    }
  }
}

// usage
const cache = new LRUCache(2);
cache.put(1, 10);
cache.put(2, 20);
console.log(cache.get(1)); // 10
cache.put(3, 30); // removes 2
