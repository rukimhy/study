const path = require('path');

module.exports = {
    name: '99dan-setting',
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
                plugins: []
            }
        }]
    },

    output: { // 출력
        path: path.join(__dirname, 'dist'),
        filename: 'app.js',
    },
}