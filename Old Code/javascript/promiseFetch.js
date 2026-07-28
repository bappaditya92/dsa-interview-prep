const fetchUser = () => {
  return new Promise((resolve) => {
    setTimeout(() => {
      resolve({ id: 1, name: "Bappa" });
    }, 1000);
  });
}

async function getUser() {
  try {
    const user = await fetchUser();
    console.log(user);
  } catch (err) {
    console.error(err);
  }
}

getUser();
