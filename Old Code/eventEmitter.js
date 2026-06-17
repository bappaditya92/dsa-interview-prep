class EventEmitter {

 constructor(){
  this.events={}
 }
 subscribe(event,callback){
  if(!this.events[event]){
   this.events[event]=[]
  }
  this.events[event].push(callback)
 }

 emit(event,data){
  if(this.events[event]){
   this.events[event].forEach(cb=>cb(data))
  }
 }
}

const emitter=new EventEmitter()

emitter.subscribe("login",data=>console.log(data))

emitter.emit("login","User logged in")
