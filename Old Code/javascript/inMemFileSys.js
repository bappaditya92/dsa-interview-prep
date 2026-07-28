class FileSystem {
  constructor() {
    this.root = {};
  }

  _traverse(path) {
    const parts = path.split('/').filter(Boolean);
    let node = this.root;

    for (const part of parts) {
      node[part] = node[part] || {};
      node = node[part];
    }

    return node;
  }

  mkdir(path) {
    this._traverse(path);
  }

  addFile(path, content) {
    const parts = path.split('/');
    const file = parts.pop();
    const dir = this._traverse(parts.join('/'));
    dir[file] = content;
  }

  readFile(path) {
    const parts = path.split('/');
    const file = parts.pop();
    const dir = this._traverse(parts.join('/'));
    return dir[file];
  }

  ls(path) {
    const node = this._traverse(path);
    return Object.keys(node);
  }
}
