const path = require('path');
const { defineConfig } = require('@vue/cli-service');

module.exports = defineConfig({
  outputDir: path.resolve(__dirname, '/Users/jangsubhin/캡스톤디자인/gourmetdiary/src/main/resources/static'),
  transpileDependencies: true,

});
