class RateLimiter {
  constructor(limit, windowMs) {
    this.limit = limit;
    this.windowMs = windowMs;
    this.requests = [];
  }

  allowRequest() {
    const now = Date.now();

    while (this.requests.length && now - this.requests[0] > this.windowMs) {
      this.requests.shift();
    }

    if (this.requests.length < this.limit) {
      this.requests.push(now);
      return true;
    }

    return false;
  }
}
