const orders = [
  {
    id: 1,
    customer: "Aman",
    status: "delivered",
    items: [
      { name: "Laptop", price: 50000, qty: 1 },
      { name: "Mouse", price: 500, qty: 2 }
    ]
  },
  {
    id: 2,
    customer: "Rahul",
    status: "pending",
    items: [
      { name: "Keyboard", price: 1500, qty: 1 }
    ]
  },
  {
    id: 3,
    customer: "Neha",
    status: "delivered",
    items: [
      { name: "Phone", price: 20000, qty: 1 },
      { name: "Case", price: 500, qty: 1 }
    ]
  }
];

const totalRevenue = orders
  // 1️⃣ Filter delivered orders
  .filter(order => order.status === "delivered")

  // 2️⃣ Map each order → order total
  .map(order =>
    order.items.reduce((sum, item) => sum + item.price * item.qty, 0)
  )

  // 3️⃣ Reduce → grand total revenue
  .reduce((total, orderTotal) => total + orderTotal, 0);

console.log("Total Revenue:", totalRevenue);
