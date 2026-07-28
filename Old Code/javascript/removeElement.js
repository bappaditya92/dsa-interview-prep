const removeElement = (nums, value)=> {
    let k = 0;

    for (let i = 0; i < nums.length; i++) {
        if (nums[i] !== value) {
            nums[k] = nums[i];
            k++;
        }
    }
    return k;
};
