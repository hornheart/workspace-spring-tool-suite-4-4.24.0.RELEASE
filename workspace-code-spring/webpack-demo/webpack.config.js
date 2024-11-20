const HtmlWebpackPlugin = require('html-webpack-plugin');
const path = require('path');

module.exports = {
  entry: './src/index.js',
  output: {
    filename: 'bundle.js',
    path: path.resolve(__dirname, 'dist'),
  },
  plugins:[
    new HtmlWebpackPlugin({
      template:'./template.html'
    }),

  ],
  module: {
    rules: [
      {
        test: /\.css$/i,
        use: ['style-loader', {
                               loader: "css-loader", 
                               options: { 
                                          url: false,
                                        
                                        }
                               },],
      },
      {
        test: /\.(png|svg|jpg|jpeg|gif)$/i,
        use: [
            {
              loader: 'file-loader',
              options: {
                name: '[name].[ext]',
                outputPath: 'image',
              },
            },
          ],
      },
    ],
  },
};