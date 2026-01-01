const kthDistinct = (arr, k)=> {
    let map=new Map();

    for(let word of arr)
    {
      if(map.has(word))
      {
        let count=map.get(word) + 1;
        map.set(word,count); 
      }else{
        map.set(word,1);
      }  
    }
    let distinct=0;
    for(let [word,count] of map.entries())
    {
        if(count==1)
        {
            distinct++;
            if(distinct==k)
              return word;
        }
    }
    return "";
};