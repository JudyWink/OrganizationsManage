module.exports = {
  devServer: {
    open: false, //浏览器自动打开页面
    host: "localhost",
    port: 8020,
    https: false,
    hotOnly: false,
  },
  configureWebpack: {
    resolve: {
      alias: {
        'assets': '@/assets',
        'common': '@/common',
        'components': '@/components',
        'network': '@/network',
        'views': '@/views',
      }
    }
  }
}

