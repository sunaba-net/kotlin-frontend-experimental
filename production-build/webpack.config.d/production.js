if (config.devServer == null) {
    config.mode = "production"
}

config.module.rules.push({
    "test": /\.js$/,
    exclude: /node_modules/,
    loader: 'babel-loader',
})