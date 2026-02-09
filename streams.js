const fs = require('fs');
const { Transform, pipeline } = require('stream');

// 1️⃣ Readable Stream
const readStream = fs.createReadStream('input.txt', {
  encoding: 'utf8',
  highWaterMark: 16 // small chunks for demo
});

// 2️⃣ Transform Stream (modify data)
const upperCaseTransform = new Transform({
  transform(chunk, encoding, callback) {
    const modified = chunk.toUpperCase();
    callback(null, modified);
  }
});

// 3️⃣ Writable Stream
const writeStream = fs.createWriteStream('output.txt');


// 4️⃣ Pipeline (BEST PRACTICE ⭐)
pipeline(
  readStream,
  upperCaseTransform,
  writeStream,
  (err) => {
    if (err) {
      console.error('❌ Stream failed:', err);
    } else {
      console.log('✅ Stream completed successfully');
    }
  }
);
