'use strict'
const utils = require('./utils')
const webpack = require('webpack')
const config = require('../config')
const merge = require('webpack-merge')
const path = require('path')
const baseWebpackConfig = require('./webpack.base.conf')
const CopyWebpackPlugin = require('copy-webpack-plugin')
const HtmlWebpackPlugin = require('html-webpack-plugin')
const FriendlyErrorsPlugin = require('friendly-errors-webpack-plugin')
const portfinder = require('portfinder')

const HOST = process.env.HOST
const PORT = process.env.PORT && Number(process.env.PORT)


// // mock code
// const express = require('express')
// const app = express()
// const login = require('./../mock/login')
// const revmsg = require('./../mock/receivemsg')
// const sentmsg = require('./../mock/sentmsg')
// const friendmsg = require('./../mock/friendmsg')
// const msgdetail = require('./../mock/msgdetail')
// const sendmsg = require('./../mock/sendmsg')
// const recommendpost = require('./../mock/recommendpost')
// const postdetail = require('./../mock/postdetail')
// const hotreply = require('./../mock/hotreply')
// const reply = require('./../mock/reply')
// const likestatus = require('./../mock/likestatus')
// const makecommentans = require('./../mock/makecommentans')
// const changelikestatus = require('./../mock/changelikestatus')
// const commentlikestatus = require('./../mock/commentlikestatus')
// const changecommentlikestatus = require('./../mock/changecommentlikestatus')
// const reportans = require('./../mock/reportans')
// const createpostans = require('./../mock/createpostans')
// const newreply = require('./../mock/newreply')
// const newpublish = require('./../mock/newpublish')
// const best = require('./../mock/best')
// const all = require('./../mock/all')
// const getuserinfo = require('./../mock/getuserinfo')
// const addfriend = require('./../mock/addfriend')
// const addblacklist = require('./../mock/addblacklist')
// const showmyself = require('./../mock/showmyself')
// const setmyself = require('./../mock/setmyself')
// const sendappealans = require('./../mock/sendappealans')
// const findfriend = require('./../mock/findfriend')
// const getpost = require('./../mock/getpost')
// const getcomment = require('./../mock/getcomment')
// const deletepost = require('./../mock/deletepost')
// const deletecomment = require('./../mock/deletecomment')
// const helpall = require('./../mock/helpall')
// const helpgetfinish = require('./../mock/helpgetfinish')
// const helpsendfinish = require('./../mock/helpsendfinish')
// const helpongoing = require('./../mock/helpongoing')
// const helpsent = require('./../mock/helpsent')
// const helpsend = require('./../mock/helpsend')
// const helpsentfinish = require('./../mock/helpsentfinish')
// const helpclaimfinish = require('./../mock/helpclaimfinish')
// const helpclaim = require('./../mock/helpclaim')
// const helpcancel = require('./../mock/helpcancel')
// const appealget = require('./../mock/appealget')
// const editpwd = require('./../mock/editpwd')
// const appealgetdetail = require('./../mock/appealgetdetail')
// const logout = require('./../mock/logout')
// const routes = express.Router()
// app.use('/api',routes)
// //mock code


const devWebpackConfig = merge(baseWebpackConfig, {
  module: {
    rules: utils.styleLoaders({ sourceMap: config.dev.cssSourceMap, usePostCSS: true })
  },
  // cheap-module-eval-source-map is faster for development
  devtool: config.dev.devtool,

  // these devServer options should be customized in /config/index.js
  devServer: {
    clientLogLevel: 'warning',
    historyApiFallback: {
      rewrites: [
        { from: /.*/, to: path.posix.join(config.dev.assetsPublicPath, 'index.html') },
      ],
    },
    hot: true,
    contentBase: false, // since we use CopyWebpackPlugin.
    compress: true,
    host: HOST || config.dev.host,
    port: PORT || config.dev.port,
    open: config.dev.autoOpenBrowser,
    overlay: config.dev.errorOverlay
      ? { warnings: false, errors: true }
      : false,
    publicPath: config.dev.assetsPublicPath,
    proxy: config.dev.proxyTable,
    quiet: true, // necessary for FriendlyErrorsPlugin
    watchOptions: {
      poll: config.dev.poll,
    },
    // mock code
    // before(app){
    //   app.post('/api/login', (req, res) => {
    //     res.json(login)
    //   })
    //   app.get('/api/message/receive', (req, res) => {
    //     res.json(revmsg)
    //   })
    //   app.get('/api/message/sent', (req, res) => {
    //     res.json(sentmsg)
    //   })
    //   app.get('/api/user/getfriend', (req, res) => {
    //     res.json(friendmsg)
    //   })
    //   app.get('/api/message/detail', (req, res) => {
    //     res.json(msgdetail)
    //   })
    //   app.post('/api/message/send', (req, res) => {
    //     res.json(sendmsg)
    //   })
    //   app.get('/api/forum/recommend', (req, res) => {
    //     res.json(recommendpost)
    //   })
    //   app.get('/api/forum/detail', (req, res) => {
    //     res.json(postdetail)
    //   })
    //   app.get('/api/forum/gethotcomment', (req, res) => {
    //     res.json(hotreply)
    //   })
    //   app.get('/api/forum/getcomment', (req, res) => {
    //     res.json(reply)
    //   })
    //   app.get('/api/forum/getlike', (req, res) => {
    //     res.json(likestatus)
    //   })
    //   app.post('/api/forum/createcomment', (req, res) => {
    //     res.json(makecommentans)
    //   })
    //   app.post('/api/forum/changelike', (req, res) => {
    //     res.json(changelikestatus)
    //   })
    //   app.get('/api/forum/getcommentlike', (req, res) => {
    //     res.json(commentlikestatus)
    //   })
    //   app.post('/api/forum/changecommentlike', (req, res) => {
    //     res.json(changecommentlikestatus)
    //   })
    //   app.post('/api/report/create', (req, res) => {
    //     res.json(reportans)
    //   })
    //   app.post('/api/forum/createpost', (req, res) => {
    //     res.json(createpostans)
    //   })
    //   app.get('/api/forum/newreply', (req, res) => {
    //     res.json(newreply)
    //   })
    //   app.get('/api/forum/newpublish', (req, res) => {
    //     res.json(newpublish)
    //   })
    //   app.get('/api/forum/best', (req, res) => {
    //     res.json(best)
    //   })
    //   app.get('/api/forum/all', (req, res) => {
    //     res.json(all)
    //   })
    //   app.get('/api/user/getuserinfo', (req, res) => {
    //     res.json(getuserinfo)
    //   })
    //   app.post('/api/user/addfriend', (req, res) => {
    //     res.json(addfriend)
    //   })
    //   app.post('/api/user/addblacklist', (req, res) => {
    //     res.json(addblacklist)
    //   })
    //   app.get('/api/user/showmyself', (req, res) => {
    //     res.json(showmyself)
    //   })
    //   app.post('/api/user/setmyself', (req, res) => {
    //     res.json(setmyself)
    //   })
    //   app.post('/api/appeal/send', (req, res) => {
    //     res.json(sendappealans)
    //   })
    //   app.get('/api/user/findfriend', (req, res) => {
    //     res.json(findfriend)
    //   })
    //   app.get('/api/user/getpost', (req, res) => {
    //     res.json(getpost)
    //   })
    //   app.get('/api/user/getcomment', (req, res) => {
    //     res.json(getcomment)
    //   })
    //   app.post('/api/user/deletepost', (req, res) => {
    //     res.json(deletepost)
    //   })
    //   app.post('/api/user/deletecomment', (req, res) => {
    //     res.json(deletecomment)
    //   })
    //   app.get('/api/help/all', (req, res) => {
    //     res.json(helpall)
    //   })
    //   app.get('/api/help/ongoing', (req, res) => {
    //     res.json(helpongoing)
    //   })
    //   app.get('/api/help/sent', (req, res) => {
    //     res.json(helpsent)
    //   })
    //   app.get('/api/help/sendfinish', (req, res) => {
    //     res.json(helpsendfinish)
    //   })
    //   app.get('/api/help/getfinish', (req, res) => {
    //     res.json(helpgetfinish)
    //   })
    //   app.post('/api/help/send', (req, res) => {
    //     res.json(helpsend)
    //   })
    //   app.post('/api/help/claim', (req, res) => {
    //     res.json(helpclaim)
    //   })
    //   app.post('/api/help/cancel', (req, res) => {
    //     res.json(helpcancel)
    //   })
    //   app.post('/api/help/claimfinish', (req, res) => {
    //     res.json(helpclaimfinish)
    //   })
    //   app.post('/api/help/sentfinish', (req, res) => {
    //     res.json(helpsentfinish)
    //   })
    //   app.get('/api/appeal/get', (req, res) => {
    //     res.json(appealget)
    //   })
    //   app.post('/api/editpwd', (req, res) => {
    //     res.json(editpwd)
    //   })
    //   app.get('/api/appeal/getdetail', (req, res) => {
    //     res.json(appealgetdetail)
    //   })
    //   app.post('/api/logout', (req, res) => {
    //     res.json(logout)
    //   })
    // }
    // mock code
  },
  plugins: [
    new webpack.DefinePlugin({
      'process.env': require('../config/dev.env'),
      'apiRoot': "'http://localhost:8081/api'"
    }),
    new webpack.HotModuleReplacementPlugin(),
    new webpack.NamedModulesPlugin(), // HMR shows correct file names in console on update.
    new webpack.NoEmitOnErrorsPlugin(),
    // https://github.com/ampedandwired/html-webpack-plugin
    new HtmlWebpackPlugin({
      filename: 'index.html',
      template: 'index.html',
      inject: true
    }),
    // copy custom static assets
    new CopyWebpackPlugin([
      {
        from: path.resolve(__dirname, '../static'),
        to: config.dev.assetsSubDirectory,
        ignore: ['.*']
      }
    ])
  ]
})

module.exports = new Promise((resolve, reject) => {
  portfinder.basePort = process.env.PORT || config.dev.port
  portfinder.getPort((err, port) => {
    if (err) {
      reject(err)
    } else {
      // publish the new Port, necessary for e2e tests
      process.env.PORT = port
      // add port to devServer config
      devWebpackConfig.devServer.port = port

      // Add FriendlyErrorsPlugin
      devWebpackConfig.plugins.push(new FriendlyErrorsPlugin({
        compilationSuccessInfo: {
          messages: [`Your application is running here: http://${devWebpackConfig.devServer.host}:${port}`],
        },
        onErrors: config.dev.notifyOnErrors
        ? utils.createNotifierCallback()
        : undefined
      }))

      resolve(devWebpackConfig)
    }
  })
})
