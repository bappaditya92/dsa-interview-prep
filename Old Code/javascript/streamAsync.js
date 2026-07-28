const fs = require('fs');

async function processFile() {
  const readStream = fs.createReadStream('input.txt', { encoding: 'utf8' });
  const writeStream = fs.createWriteStream('output.txt');

  try {
    // loop chunk-by-chunk
    for await (const chunk of readStream) {
      const modified = chunk.toUpperCase();
      writeStream.write(modified);
    }

    writeStream.end();
    console.log('✅ Done processing');
  } catch (err) {
    console.error('❌ Error:', err);
  }
}

processFile();
