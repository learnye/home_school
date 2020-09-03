var uriUtil = require('../../utils/uri.js');
var httpUtil = require('../../utils/http.js');
var homeUtil = require('../../utils/home.js');
var app = getApp();
Page({

  data: {
    baseUrl: uriUtil.BASE_URL,
    baseImgUrl: uriUtil.BASE_URL_UPLOAD,
    countDown: 3
  },

  onLoad: function () {
    var that = this;
    //3秒后跳转
    let intervalId = setInterval(function () {
      let count = that.data.countDown;
      that.setData({
        countDown: --count
      })
      if (count == 0) {
        clearInterval(intervalId);
        let userInfo = uriUtil.getUserInfo();
        if (userInfo) {
          let userType = uriUtil.getUserType();
          if (userType == uriUtil.USER_TYPE_NORMAL) {
            wx.redirectTo({
              url: '../parentHome/parentHome',
            })
          } else {
            wx.redirectTo({
              url: '../teacherHome/teacherHome',
            })
          }
        } else {
          //判断是否登录以及跳转的界面
          wx.redirectTo({
            url: '../login/login',
          })
        }
      }
    }, 1200);
  },
})