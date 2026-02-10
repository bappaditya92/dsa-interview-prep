class ParkingLot {
  constructor(size) {
    this.slots = new Array(size).fill(null);
  }

  park(vehicle) {
    const index = this.slots.indexOf(null);
    if (index === -1) return "Full";

    this.slots[index] = vehicle;
    return index;
  }

  leave(index) {
    this.slots[index] = null;
  }

  freeSlots() {
    return this.slots.filter(s => s === null).length;
  }
}

const lot = new ParkingLot(3);
console.log(lot.park("Car1"));
console.log(lot.freeSlots());
