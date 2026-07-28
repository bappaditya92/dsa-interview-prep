function myPromiseAll(promises){

 return new Promise((resolve,reject)=>{

  let result=[]
  let count=0

  promises.forEach((p,i)=>{

   Promise.resolve(p).then(res=>{

    result[i]=res
    count++

    if(count===promises.length){
     resolve(result)
    }

   }).catch(reject)

  })

 })

}
