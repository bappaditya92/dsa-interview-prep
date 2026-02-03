const express = require("express");
const app = express();

app.use(express.json());

app.get("/users/:id", (req, res) => {
  const id = req.params.id;

  res.json({
    id,
    name: "Bappaditya",
    role: "Developer"
  });
});

app.listen(3000, () => console.log("Server running"));
