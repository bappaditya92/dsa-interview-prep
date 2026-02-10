class RateLimiter {
  constructor(limit, interval) {
    this.limit = limit;
    this.interval = interval;
    this.requests = [];
  }

  allow() {
    const now = Date.now();

    this.requests = this.requests.filter(
      time => now - time < this.interval
    );

    if (this.requests.length < this.limit) {
      this.requests.push(now);
      return true;
    }

    return false;
  }
}

// usage
const limiter = new RateLimiter(3, 1000);

console.log(limiter.allow());
console.log(limiter.allow());
console.log(limiter.allow());
console.log(limiter.allow()); // false
