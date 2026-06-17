const maxProduct = (root) => {
  const MOD = 1000000007n;
  let totalSum = 0n;
  let maxProd = 0n;
  const getTotalSum = (node) => {
    if (!node) return 0n;
    return BigInt(node.val) + getTotalSum(node.left) + getTotalSum(node.right);
  };
  totalSum = getTotalSum(root);
  const dfs = (node) => {
    if (!node) return 0n;
    const leftSum = dfs(node.left);
    const rightSum = dfs(node.right);
    const subTreeSum = BigInt(node.val) + leftSum + rightSum;
    const product = subTreeSum * (totalSum - subTreeSum);
    maxProd = maxProd > product ? maxProd : product;
    return subTreeSum;
  };
  dfs(root);
  return Number(maxProd % MOD);
};
