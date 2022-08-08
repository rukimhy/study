const path = require('path');
const RefreshWebpackPlugin = require('@pmmmwh/react-refresh-webpack-plugin');

module.exports = {
    name: 'router-setting',
    mode: 'development',
    // mode: 'production',
    devtool: 'eval',

    resolve: {
        extensions: ['.js', '.jsx', 'ts', 'tsx']
    },

    entry: { // 입력
        app: ['./client'],
    },

    module: {
        rules: [{
            test: /\.jsx?/,
            loader: 'babel-loader',
            options: {
                presets: [
                    ['@babel/preset-env', {
                        targets: {
                            browsers: ['> 10% in KR'], //browserslist
                        },
                        debug: true,
                    }],
                    '@babel/preset-react'
                ],
                plugins: [
                    '@babel/plugin-proposal-class-properties',
                    'react-refresh/babel'
                ]
            }
        }]
    },

    plugins: [
        new RefreshWebpackPlugin()
    ],

    output: { // 출력
        path: path.join(__dirname, 'dist'),
        filename: 'app.js',
        publicPath: '/dist',
    },

    devServer: {
        historyApiFallback: true,
        devMiddleware: { publicPath: '/dist' },
        static: { directory: path.resolve(__dirname) },
        hot: true,
    },
}